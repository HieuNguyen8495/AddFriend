package minhhieu.AddFriends.service;

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


@Service
public class UserServiceImpl implements UserService {
	private UserRepository repository;
	private FriendRepository repo;
	
	public UserServiceImpl(UserRepository userRepository,FriendRepository friendRepository) {
		repository = userRepository;
		repo = friendRepository;
		
	}
	
	@Override
	public List<User> findAllDto() {
		return repository.findAllUser();
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

        User savedUser = repository.save(newUser);
        
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
		User updateUser = repository.getById(id);
		
		updateUser.setUserName(updateUserDto.getUserName());
		updateUser.setNickName(updateUserDto.getNickName());
		updateUser.setEmail(updateUserDto.getEmail());
		
		User updatedUser = repository.save(updateUser);
		
		UserDto dto = new UserDto();
		dto.setUserName(updatedUser.getUserName());
		dto.setNickName(updatedUser.getNickName());
		dto.setEmail(updatedUser.getEmail());
		return  dto;
	}

	
	@Override
	public void deleteById(int userId) {
		repository.deleteById(userId);
	}


	@Override
	public boolean isExistedId(Integer userId) {
		return repository.existsById(userId);
		
	}

	@Override
	public boolean isTakenUserName(String userName) {
		return repository.countByUserName(userName) >= 1;
	}

	@Override
	public boolean isTakenEmail(String email) {
		return repository.countByEmail(email) >= 1;
	}
	
	@Transactional
	@Override
	public UserDto addFriendId(AddFriendDto dto, int userId2) {
		User myUser = repository.getById(userId2);
		User targetFriend = repository.getById(dto.getFriendUserID());
		String nickName = dto.getNickName();
		
		myUser.addFriend(targetFriend, nickName);
		
		User u = repository.save(myUser);
		
		UserDto userDto = new UserDto();
		userDto.setNickName(myUser.getNickName());
		
		
		return userDto;
	}
	

    @Transactional
	@Override
	public FriendDto updateNickname(ChangeNickNameDto dto) {
   		Friend newNickName = repo.getById(dto.getId());
   		
   		newNickName.setNickName(dto.getNewNickName());
   		
		Friend fr = repo.save(newNickName);
		
		FriendDto friendDto = new FriendDto();
		friendDto.setNickName(fr.getNickName());
		
		return friendDto;
	}

}	

	

	
	
