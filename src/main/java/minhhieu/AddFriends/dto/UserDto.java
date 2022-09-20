package minhhieu.AddFriends.dto;

import java.util.Date;
import java.util.Set;

import minhhieu.AddFriends.util.UserStatus;



public interface UserDto {
	public int getId();
	
	public String getUserName();
	
	public String getNickName();
	
	public Date getBirthday();
	
	public UserStatus getStatus();
		
	public String getEmail();
	
	
	
}
