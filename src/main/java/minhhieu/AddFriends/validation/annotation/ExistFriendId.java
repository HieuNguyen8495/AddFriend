//package minhhieu.AddFriends.validation.annotation;
//
//import static java.lang.annotation.ElementType.FIELD;
//import static java.lang.annotation.RetentionPolicy.RUNTIME;
//
//import java.lang.annotation.Retention;
//import java.lang.annotation.Target;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//
//import minhhieu.AddFriends.validation.validator.ExistFriendIdValidator;
//
//
//
//@Constraint(validatedBy = ExistFriendIdValidator.class)
//@Retention(RUNTIME)
//@Target(FIELD)
//public @interface ExistFriendId {
//	public String message() default "FriendID does not exist";
//	
//	Class<?>[] groups() default { };
//
//	Class<? extends Payload>[] payload() default { };
//}
