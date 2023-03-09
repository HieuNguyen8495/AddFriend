package minhhieu.AddFriends.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import minhhieu.AddFriends.util.UserStatus;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Getter
@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	@NotNull
	private int id;
	
	@NotNull
	@Size(min = 2, max = 50)
	@Column(unique = true)
	private String userName;
	
	@NotNull
	private String password;
	
	@NotNull
	private String confirmPassword;
	
	private String nickName;
	
	private Date birthday ;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	@Email
	@Column(unique = true)
	@NotNull
	private String email;
	
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
						  fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Friend> friendList = new HashSet<>();
	

	public void addFriend(User friendUser,String nickName) {
		Friend fr = new Friend();
		fr.setUser(this); //this.Equals(user)
		fr.setFriendUser(friendUser);
		fr.setNickName(nickName);
		
		friendList.add(fr);
	}
	
	

}
