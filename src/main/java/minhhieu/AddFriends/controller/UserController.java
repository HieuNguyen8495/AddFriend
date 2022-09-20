package minhhieu.AddFriends.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import minhhieu.AddFriends.dto.CreateUserDto;
import minhhieu.AddFriends.dto.UpdateUserDto;
import minhhieu.AddFriends.dto.UserDto;
import minhhieu.AddFriends.model.User;
import minhhieu.AddFriends.service.UserService;


@Validated
@RestController
@RequestMapping("/api/user")
public class UserController {
	private UserService service;
	
	public UserController(UserService userService) {
		service = userService;
	}
	
	@GetMapping("/find")
	public List<UserDto> findAllUsers(){
		List<UserDto> users = service.findAllDto();
		return users;
	}
	
	@PostMapping("/add")
	public User addUser(@Valid @RequestBody CreateUserDto userDto){
		User addUser = service.addNewUser(userDto);
		return addUser;
	} 
	
	@PutMapping("/update")
	public User updateUser(@Valid @RequestBody UpdateUserDto updateUserDto) {
		User updateUser = service.updateUser(updateUserDto , updateUserDto.getId());
			return updateUser;
	}
	
	@DeleteMapping("/{user-id}")
	public void deleteUser(@PathVariable("user-id") int userId) {
		service.deleteById(userId);
	}
	
//	@PostMapping("/add-friend")
//	public User addFriendToUser(@Valid @RequestBody AddFriendDto dto) {
//		User userFriend = service.addFriend(dto);
//  		  return userFriend; 
//	}
	
//	@PostMapping("/change-nickname")
//	public User updatedNickname(@Valid @RequestBody ChangeNicknameDto dto) {
//		User updateNickname = service.updateNickname(dto);
//		return updateNickname;
//	}
}
