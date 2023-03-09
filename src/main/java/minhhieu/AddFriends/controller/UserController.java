package minhhieu.AddFriends.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import minhhieu.AddFriends.dto.AddFriendDto;
import minhhieu.AddFriends.dto.ChangeNickNameDto;
import minhhieu.AddFriends.dto.CreateUserDto;
import minhhieu.AddFriends.dto.FriendDto;
import minhhieu.AddFriends.dto.UpdateUserDto;
import minhhieu.AddFriends.dto.UserDto;
import minhhieu.AddFriends.model.Friend;
import minhhieu.AddFriends.model.User;
import minhhieu.AddFriends.service.UserService;


@Validated
@RestController
@RequestMapping("/api/user")
public class UserController {
	private UserService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UserController(UserService userService) {
		service = userService;
	}
	
	@GetMapping
	public List<UserDto> findAllUsers(){
		List<UserDto> userDtos = service.findAllUsers();
		return userDtos;
	}
	
	@PostMapping
	public UserDto addUser(@Valid @RequestBody CreateUserDto userDto){
		UserDto addUser = service.addNewUser(userDto);
		return  addUser; 
	} 
	
	@PutMapping
	public UserDto updateUser(@Valid @RequestBody UpdateUserDto updateUserDto) {
		UserDto updateUser = service.updateUser(updateUserDto , updateUserDto.getId());
		return updateUser;
	}
	
	@DeleteMapping("/{user-id}")
	public void deleteUser(@PathVariable("user-id") int userId) {
		service.deleteById(userId);
	}
	
	@PostMapping("/{user-id}/friends")
	public FriendDto addFriendToUser(@PathVariable("user-id") int userId, @Valid @RequestBody AddFriendDto dto) {
		FriendDto friendDto = service.addFriendId(dto, userId);
  		return friendDto; 
	}
	
	@PutMapping("/{friend-id}")
	public FriendDto updatedNickname(@PathVariable("friend-id") int friendId, @Valid @RequestBody ChangeNickNameDto dto) {
		FriendDto updateNickname = service.updateNickname(dto, friendId);
		return updateNickname;
	}
}
