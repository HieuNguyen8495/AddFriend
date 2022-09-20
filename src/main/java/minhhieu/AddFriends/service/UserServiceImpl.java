package minhhieu.AddFriends.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import minhhieu.AddFriends.dto.CreateUserDto;
import minhhieu.AddFriends.dto.UpdateUserDto;
import minhhieu.AddFriends.dto.UserDto;
import minhhieu.AddFriends.model.User;
import minhhieu.AddFriends.repository.UserRepository;
import minhhieu.AddFriends.util.UserStatus;


@Service
public class UserServiceImpl implements UserService {
	private UserRepository repository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		repository = userRepository;
		
	}
	
	@Override
	public List<UserDto> findAllDto() {
		return repository.findAllUserDto();
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

//	@Override
//	@Transactional
//	public User addFriend(AddFriendDto dto) {
//		User user = repository.getById(dto.getUserId());
//		Friend friend = friendRepository.getById(dto.getFriendId());
//		
//		return user.addFriend(friend);
//	}
//	
//	@Override
//	@Transactional
//	public User updateNickname(ChangeNicknameDto dto) {
//		User user = repository.getById(dto.getUserId());
//		Friend friend = friendRepository.getById(dto.getFriendId());
//		
//		return  user.changeNickname(friend, dto);
//	}

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

	

	
	
}
