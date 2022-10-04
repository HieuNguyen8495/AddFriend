package minhhieu.AddFriends.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import minhhieu.AddFriends.service.UserService;
import minhhieu.AddFriends.util.ValidatorUtil;
import minhhieu.AddFriends.validation.annotation.UniqueUserName;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {
	
	private UserService service;
	
	public UniqueUserNameValidator(UserService userService) {
		service = userService;
	}
	@Override
	public void initialize(UniqueUserName constraintAnnotation) {
		
	}
	@Override
	public boolean isValid(String userName, ConstraintValidatorContext context) {
		if(userName == null)
			return false;
		
		boolean isTaken = service.isTakenUserName(userName);
		
		if(!isTaken)
			return true;
		
		return false;
	}

}
