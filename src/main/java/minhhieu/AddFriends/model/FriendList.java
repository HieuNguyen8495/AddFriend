package minhhieu.AddFriends.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "FriendList")
public class FriendList {
	@Id
	@GeneratedValue
	private int friendUserID;
	
	private int userID;
	
	private String nickName;
	
	@ManyToMany(mappedBy = "friendList")
	private Set<User> groups = new HashSet<>();
	

}
