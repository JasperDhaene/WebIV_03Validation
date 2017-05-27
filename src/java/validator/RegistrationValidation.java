package validator;

import controller.Registration;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegistrationValidation implements Validator {

    @Override
    public boolean supports(Class<?> klass) {
        return Registration.class.isAssignableFrom(klass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Registration registration = (Registration) target;

        //validate username
        String userName = registration.getUserName();
        if (userName.length() < 4 || userName.length() > 15) {
            errors.rejectValue("userName",
                    "lengthOfUser.registration.userName",
                    "username must be between 4 and 15 characters long.");
        }
        if (userName.contains(" ")) {
            errors.rejectValue("userName",
                    "patternOfUser.registration.userName",
                    "username must be alphanumeric with no spaces.");
        }
        //validate password
        if (!(registration.getPassword()).equals(
                registration.getConfirmPassword())) {
            errors.rejectValue("password",
                    "matchingPassword.registration.password",
                    "password does not match the confirm password.");
        }
        //email validation done with custom @ValidEmail annotation
    }
}
