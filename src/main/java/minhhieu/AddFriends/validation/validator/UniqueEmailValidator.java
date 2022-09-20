package minhhieu.AddFriends.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import minhhieu.AddFriends.service.UserService;
import minhhieu.AddFriends.util.ValidatorUtil;
import minhhieu.AddFriends.validation.annotation.UniqueEmail;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{
	private String message;
	private UserService service;
	
	public UniqueEmailValidator(UserService userService) {
		service = userService;
	}
	
	@Override
	public void initialize(UniqueEmail constraintAnnotation) {
		message = constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if(email == null)
			return false;
		
		boolean isTaken = service.isTakenEmail(email);
		
		if(!isTaken)
			return true;
		
		ValidatorUtil.addError(context, email);	
		return false;
	}

}
