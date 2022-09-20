package minhhieu.AddFriends.util;

import javax.validation.ConstraintValidatorContext;

public class ValidatorUtil {
	public static void addError(ConstraintValidatorContext context, String message) {
		context.buildConstraintViolationWithTemplate(message)
		       .addConstraintViolation()
		       .disableDefaultConstraintViolation();
	}
}
