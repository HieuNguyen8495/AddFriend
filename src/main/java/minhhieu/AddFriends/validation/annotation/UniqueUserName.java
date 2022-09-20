package minhhieu.AddFriends.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import minhhieu.AddFriends.validation.validator.UniqueUserNameValidator;


@Constraint(validatedBy = UniqueUserNameValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueUserName {
	public String message() default "This name is existed";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
