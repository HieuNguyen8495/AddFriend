package minhhieu.AddFriends.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



import minhhieu.AddFriends.dto.CreateUserDto;
import minhhieu.AddFriends.util.ValidatorUtil;
import minhhieu.AddFriends.validation.annotation.ConfirmPassword;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPassword, CreateUserDto> {
	private String message;
	
	@Override
	public void initialize(ConfirmPassword constraintAnnotation) {
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(CreateUserDto dto, ConstraintValidatorContext context) {
		if(dto.getPassword() == null || dto.getConfirmPassword() == null) {
			ValidatorUtil.addError(context, message);
			return false;
		}
		
		if(dto.getPassword().equals(dto.getConfirmPassword())) {
			return true;
		}
		
		ValidatorUtil.addError(context, message);
		return false;
	}
	

}
