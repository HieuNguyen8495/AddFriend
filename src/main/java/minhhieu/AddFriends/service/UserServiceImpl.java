package minhhieu.AddFriends.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import minhhieu.AddFriends.dto.AddFriendDto;
import minhhieu.AddFriends.dto.ChangeNickNameDto;
import minhhieu.AddFriends.dto.CreateUserDto;
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
	public User addNewUser(CreateUserDto userDto) {
		User newUser = new User();
		
		newUser.setUserName(userDto.getUserName());
		newUser.setNickName(userDto.getNickName());
		newUser.setEmail(userDto.getEmail());
		newUser.setBirthday(userDto.getBirthday());
		newUser.setPassword(userDto.getPassword());
		newUser.setConfirmPassword(userDto.getConfirmPassword());
		newUser.setStatus(UserStatus.ACTIVE);
		
		return repository.save(newUser);
	}

	@Override
	public User updateUser(UpdateUserDto updateUserDto, int id) {
		User updateUser = repository.getById(id);
		
		updateUser.setUserName(updateUserDto.getUserName());
		updateUser.setNickName(updateUserDto.getNickName());
		updateUser.setEmail(updateUserDto.getEmail());
		
		return repository.save(updateUser);
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
	public User addFriendId(AddFriendDto dto, int userId2) {
		User myUser = repository.getById(userId2);
		User targerFriend = repository.getById(dto.getFriendUserID());
		String nickName = dto.getNickName();
		
		myUser.addFriend(targerFriend, nickName);
		
		return repository.save(myUser);
	}
	

    @Transactional
	@Override
	public Friend updateNickname(ChangeNickNameDto dto) {
   		Friend newNickName = repo.getById(dto.getId());
   		
   		newNickName.setNickName(dto.getNewNickName());
   		
		return repo.save(newNickName);
	}

}	

	

	
	
