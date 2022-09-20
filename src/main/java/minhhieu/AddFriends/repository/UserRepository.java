package minhhieu.AddFriends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import minhhieu.AddFriends.dto.CreateUserDto;
import minhhieu.AddFriends.dto.UserDto;
import minhhieu.AddFriends.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
		
	@Query("SELECT u FROM User u")
	List<UserDto> findAllUserDto();
	
	int countByUserName(String userName);

	int countByEmail(String email);
	
	
	
}
