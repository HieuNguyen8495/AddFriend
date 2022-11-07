package minhhieu.AddFriends.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import minhhieu.AddFriends.model.Friend;
import minhhieu.AddFriends.util.UserStatus;

@Getter
@Setter
public class UserDto {
	
	@NotNull
	@Size(min = 2, max = 50)
//	@Column(unique = true)
	private String userName;
	
	@NotNull
	private String password;
	
	@NotNull
	private String confirmPassword;
	
	private String nickName;
	private Date birthday;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	@Email
	@Column(unique = true)
	@NotNull
	private String email;
	
	
	
}
