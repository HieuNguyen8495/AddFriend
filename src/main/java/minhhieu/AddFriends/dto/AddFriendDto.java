package minhhieu.AddFriends.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import minhhieu.AddFriends.model.User;

@Getter
@Setter
public class AddFriendDto {
	
	@NotNull
	private int friendUserID;
	
	private String nickName;
	
}
