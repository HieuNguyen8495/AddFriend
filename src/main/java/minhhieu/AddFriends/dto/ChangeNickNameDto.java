package minhhieu.AddFriends.dto;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeNickNameDto {
	@NotNull
	private int id;
	
	@NotNull
	private String newNickName;
}
