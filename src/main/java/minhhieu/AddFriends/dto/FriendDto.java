 package minhhieu.AddFriends.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import minhhieu.AddFriends.model.User;

@Getter
@Setter
public class FriendDto {
	@NotNull
	private int friendUser;
	
	@NotNull
	private int user;
	
	private String nickName;
	
}
