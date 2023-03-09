package minhhieu.AddFriends.validation.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import minhhieu.AddFriends.service.FriendService;
import minhhieu.AddFriends.validation.annotation.FriendIdExists;

public class FriendIdExistsValidator implements ConstraintValidator<FriendIdExists, Integer> {
	private String message;
	private FriendService service;
	
	public FriendIdExistsValidator(FriendService friendService) {
		service = friendService;
	}
	
	@Override
	public void initialize(FriendIdExists constraintAnnotation) {
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(Integer friendId, ConstraintValidatorContext context) {
		boolean isExisted = service.isExisted(friendId);
		
		if(isExisted)
			return true;
		
		return false;
	}

}
