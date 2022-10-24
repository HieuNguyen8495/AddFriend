package minhhieu.AddFriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import minhhieu.AddFriends.model.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {
	
}
