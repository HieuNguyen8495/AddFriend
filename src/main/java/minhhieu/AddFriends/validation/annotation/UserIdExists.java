package minhhieu.AddFriends.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import minhhieu.AddFriends.validation.validator.UserIdExistsValidator;

@Constraint(validatedBy = UserIdExistsValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface UserIdExists {
	public String message() default "UserID does not exist";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
