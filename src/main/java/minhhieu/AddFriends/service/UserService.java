package minhhieu.AddFriends.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.Query;

import minhhieu.AddFriends.dto.AddFriendDto;
import minhhieu.AddFriends.dto.ChangeNickNameDto;
import minhhieu.AddFriends.dto.CreateUserDto;
import minhhieu.AddFriends.dto.FriendDto;
import minhhieu.AddFriends.dto.UpdateUserDto;
import minhhieu.AddFriends.dto.UserDto;
import minhhieu.AddFriends.model.Friend;
import minhhieu.AddFriends.model.User;

public interface UserService {
	
	List<UserDto> findAllUsers();

	UserDto addNewUser(CreateUserDto userDto);

	UserDto updateUser(UpdateUserDto updateUserDto, int id);

	void deleteById(int userId);

	boolean isExistedId(Integer userId);

	boolean isTakenUserName(String userName);

	boolean isTakenEmail(String email);

	UserDto addFriendId(AddFriendDto dto, int userId);

	FriendDto updateNickname(ChangeNickNameDto dto);




}
