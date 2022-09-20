package minhhieu.AddFriends.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validator;

import minhhieu.AddFriends.service.UserService;
import minhhieu.AddFriends.util.ValidatorUtil;
import minhhieu.AddFriends.validation.annotation.ExistUserId;

public class ExistUserIdValidator implements ConstraintValidator<ExistUserId, Integer> {
	private String message;
	private UserService service;
	
	public ExistUserIdValidator(UserService userService) {
		service = userService;
	}
	@Override
	public void initialize(ExistUserId constraintAnnotation) {
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(Integer userId, ConstraintValidatorContext context) {
		
		boolean isExisted = service.isExistedId(userId);
		
		if(isExisted)
			return true;
		
		ValidatorUtil.addError(context, message);
		return false;
	}

}
