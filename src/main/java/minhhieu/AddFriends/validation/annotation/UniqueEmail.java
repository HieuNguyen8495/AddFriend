package minhhieu.AddFriends.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import minhhieu.AddFriends.validation.validator.UniqueEmailValidator;


@Constraint(validatedBy = UniqueEmailValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueEmail {
	public String message() default "Email is existed";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
