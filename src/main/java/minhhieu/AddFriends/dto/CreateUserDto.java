  package minhhieu.AddFriends.dto;

import java.text.DateFormat;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import minhhieu.AddFriends.validation.annotation.ConfirmPassword;
import minhhieu.AddFriends.validation.annotation.UniqueEmail;
import minhhieu.AddFriends.validation.annotation.UniqueUserName;

@Getter
@Setter
@ConfirmPassword(message = "{user.confirmpassword}")
public class CreateUserDto {
	@NotBlank(message = "{user.name.not-blank}")
	@Size(min = 3, max = 50, message = "{user.size.name}")
	@UniqueUserName(message = "{user.username.unique}")
	private String userName;
	
	@NotBlank(message = "{user.passwork.not-blank}")
	@Size(min = 2, max = 20, message = "{user.size.password}")
	private String password;
	
	@NotBlank(message = "{user.passwork.not-blank}")
	@Size(min = 2, max = 20, message = "{user.size.password}")
	private String confirmPassword;
	
	private String nickName;
	
	@CreatedDate
//	@DateTimeFormat(pattern = DateUtils.Date_format)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.Date_format)
	private LocalDateTime birthday = LocalDateTime.now();
	
	@Email(message = "{user.email.valid}")
	@NotBlank(message = "{user.email.not-blank}")
	@UniqueEmail(message = "{user.email.unique}")
	private String email;

	
}
	

