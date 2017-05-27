package controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import validator.RegistrationValidation;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationValidation registrationValidation;

    @RequestMapping(method = RequestMethod.GET)
    public String showHomePage(Model model) {
        model.addAttribute("registration", new Registration());
        return "registrationForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@Valid Registration registration, BindingResult result) {

        if (result.hasErrors()) {
            return "registrationForm";
        }
        
        registration.setConfirmPassword(null);
        registration.setPassword(null);
        return "registrationSuccess";
    }

}
