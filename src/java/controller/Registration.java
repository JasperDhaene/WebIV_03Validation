package controller;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Email;
import validator.ValidEmail;

public class Registration {

    @Pattern(regexp = "^[a-zA-Z]+", message = "username must be alphanumeric with no spaces")
    private String userName;

    @Size(min = 4, max = 20)
    private String password;

    @NotEmpty
    private String confirmPassword;

    @NotEmpty
    @Email
    //@ValidEmail
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
