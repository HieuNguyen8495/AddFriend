//      package minhhieu.AddFriends.validation.validator;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//
//
//import minhhieu.AddFriends.validation.annotation.ExistFriendId;
//
//public class ExistFriendIdValidator implements ConstraintValidator<ExistFriendId, Integer> {
//	private String message;
//	private FriendService service;
//	
//	public ExistFriendIdValidator(FriendService friendService) {
//		service = friendService;
//	}
//	
//	@Override
//	public void initialize(ExistFriendId constraintAnnotation) {
//		message = constraintAnnotation.message();
//	}
//
//	@Override
//	public boolean isValid(Integer friendId, ConstraintValidatorContext context) {
//		boolean isExisted = service.isExisted(friendId);
//		
//		if(isExisted)
//			return true;
//		
//		ValidatorUtil.addError(context, message);
//		    return false;
//	}
//
//}
