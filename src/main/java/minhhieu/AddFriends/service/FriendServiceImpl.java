package minhhieu.AddFriends.service;

import minhhieu.AddFriends.repository.FriendRepository;

public class FriendServiceImpl implements FriendService {
	private FriendRepository friendRepo;
	
	@Override
	public boolean isExisted(Integer friendId) {
		return friendRepo.existsById(friendId);
	}

}
