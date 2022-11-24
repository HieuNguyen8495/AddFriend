package minhhieu.AddFriends.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import minhhieu.AddFriends.model.User;

@Getter
@Setter
public class FriendDto {
	
	@OneToOne
	@JoinColumn(referencedColumnName = "id")
	private User friendUser;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private User user;
	
	private String nickName;
	
}
