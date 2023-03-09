package minhhieu.AddFriends.dto;

 import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import minhhieu.AddFriends.validation.annotation.UniqueEmail;
import minhhieu.AddFriends.validation.annotation.UniqueUserName;

@Getter
@Setter
public class UpdateUserDto {
	@NotNull
	private int id;
	
	@NotBlank(message = "{user.name.not-blank}")
	@Size(min = 3, max = 50, message = "{user.size.name}")
	@UniqueUserName(message = "{user.username.unique}")
	private String userName;
	
	private String nickName;
	
	@Email(message = "{user.email.valid}")
	@NotBlank(message = "{user.email.not-blank}")
	@UniqueEmail(message = "{user.email.unique}")
	private String email;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date birthday;
	
}
