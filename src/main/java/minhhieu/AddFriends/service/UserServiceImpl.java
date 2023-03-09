package minhhieu.AddFriends.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import minhhieu.AddFriends.dto.AddFriendDto;
import minhhieu.AddFriends.dto.ChangeNickNameDto;
import minhhieu.AddFriends.dto.CreateUserDto;
import minhhieu.AddFriends.dto.FriendDto;
import minhhieu.AddFriends.dto.UpdateUserDto;
import minhhieu.AddFriends.dto.UserDto;
import minhhieu.AddFriends.model.Friend;
import minhhieu.AddFriends.model.User;
import minhhieu.AddFriends.repository.FriendRepository;
import minhhieu.AddFriends.repository.UserRepository;
import minhhieu.AddFriends.util.UserStatus;
import springfox.documentation.swagger2.mappers.ModelMapper;


@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepo;
	private FriendRepository friendRepo;
	
	
	public UserServiceImpl(UserRepository userRepository,FriendRepository friendRepository) {
		userRepo= userRepository;
		friendRepo = friendRepository;
		
	}
	
	@Override
	public List<UserDto> findAllUsers() {
		User user = new User();
		
		List<UserDto> dtos = new ArrayList();
		List<User> users = userRepo.findAll();
		
		for (User u : users) {
			UserDto dto = new UserDto();
			dto.setUserName(u.getUserName());
			dto.setBirthday(u.getBirthday());
			dto.setEmail(u.getEmail());
			dto.setNickName(u.getNickName());
			
			dtos.add(dto);
		}
		
		
		List<UserDto> dto1 = users.stream().map(u -> {
			UserDto dto = new UserDto();
			dto.setUserName(u.getUserName());
			dto.setBirthday(u.getBirthday());
			dto.setEmail(u.getEmail());
			dto.setNickName(u.getNickName());
			return dto;
		}).toList();
		
		return dtos;
	}

	@Override
	public UserDto addNewUser(CreateUserDto dto) {
		User newUser = new User();

	        newUser.setUserName(dto.getUserName());
	        newUser.setNickName(dto.getNickName());
	        newUser.setEmail(dto.getEmail());
	        newUser.setBirthday(dto.getBirthday());
	        newUser.setPassword(dto.getPassword());
	        newUser.setConfirmPassword(dto.getConfirmPassword());
	        newUser.setStatus(UserStatus.ACTIVE);

        User savedUser = userRepo.save(newUser);
        
	        UserDto userDto = new UserDto();
	        userDto.setUserName(savedUser.getNickName());
	        userDto.setEmail(savedUser.getEmail());
	        userDto.setNickName(savedUser.getNickName());
	        userDto.setStatus(savedUser.getStatus());
	        userDto.setBirthday(savedUser.getBirthday());
	        
        return userDto;
	}

	@Override
	public UserDto updateUser(UpdateUserDto updateUserDto, int id) {
		User updateUser = userRepo.getById(id);
			updateUser.setUserName(updateUserDto.getUserName());
			updateUser.setNickName(updateUserDto.getNickName());
			updateUser.setEmail(updateUserDto.getEmail());
			
		User updatedUser = userRepo.save(updateUser);
		
		UserDto dto = new UserDto();
			dto.setUserName(updatedUser.getUserName());
			dto.setNickName(updatedUser.getNickName());
			dto.setEmail(updatedUser.getEmail());
		return  dto;
	}

	@Override
	public void deleteById(int userId) {
		userRepo.deleteById(userId);
	}

	@Override
	public boolean isExistedId(Integer userId) {
		return userRepo.existsById(userId);
		
	}

	@Override
	public boolean isTakenUserName(String userName) {
		return userRepo.countByUserName(userName) >= 1;
	}

	@Override
	public boolean isTakenEmail(String email) {
		return userRepo.countByEmail(email) >= 1;
	}
	
	@Transactional
	@Override
	public FriendDto addFriendId(AddFriendDto dto, int userId2) {
		User myUser = userRepo.getById(userId2);
		User targetFriend = userRepo.getById(dto.getFriendUserID());
		String nickName = dto.getNickName();
		
		myUser.addFriend(targetFriend, nickName);
		
		User u = userRepo.save(myUser);
		
		FriendDto friendDto = new FriendDto();
		friendDto.setUser(userId2);
		friendDto.setFriendUser(targetFriend.getId());
		friendDto.setNickName(myUser.getNickName());
		
		return friendDto;
	}

    @Transactional
	@Override
	public FriendDto updateNickname(ChangeNickNameDto dto, int friendId) {
   		Friend newNickName = friendRepo.getById(friendId);
   		newNickName.setNickName(dto.getNewNickName());
   		
		Friend fr = friendRepo.save(newNickName);
		
		FriendDto friendDto = new FriendDto();
		friendDto.setNickName(fr.getNickName());
		
		return friendDto;
	}

}	

	

	
	
