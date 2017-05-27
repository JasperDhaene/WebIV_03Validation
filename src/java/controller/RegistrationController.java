package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String processRegistration(@ModelAttribute Registration registration, BindingResult result) {
        //Changed registration from @Valid to @ModelAttribute.
        //Validation will be done by registrationValidation below, instead of by Spring itself
        //All annotations in Registration class will be ignored, including the custom @ValidEmail
        registrationValidation.validate(registration, result);

        if (result.hasErrors()) {
            return "registrationForm";
        }
        
        return "registrationSuccess";
    }

}
