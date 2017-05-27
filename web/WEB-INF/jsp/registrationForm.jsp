<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <spring:url value="/css/style.css" var="urlCss"/>
        <link rel="stylesheet" href="${urlCss}" type="text/css" /> 
        <title>Example Spring Validation</title>
    </head>
    <body>
        <h1>Example Spring Validation</h1>

        <form:form method="POST" action="registration.htm" modelAttribute="registration">

            <p><label>User Name:</label>
                <form:input path="userName" size = "20"/>&nbsp;
                <form:errors path="userName" cssClass="error"/>
            </p>
            <p><label>Password:</label>
                <form:password path="password" size = "20"/>&nbsp;
                <form:errors path="password" cssClass="error"/>
            </p>
            <p><label>Confirm Password:</label>
                <form:password path="confirmPassword" size = "20"/>&nbsp;
                <form:errors path="confirmPassword" cssClass="error"/>
            </p>
            <p class="note">Note: Slides are unclear here.<br>
                They say both @ModelAttribute and @Valid can be used to inject the fields of this form into processRegistration() of the RegistrationController.<br>
                This is not true though. With @ModelAttribute (as it is now), all annotations for validation (so including our custom @ValidEmail) will be ignored!<br>
                This is not a problem for the other fields, because they are validated in the controller with registrationValidation.validate(). Try this by submitting the form with an empty email. The next commit will contain the correct code.
            </p>
            <p><label>Email:</label>
                <form:input path="email" size = "20"/>&nbsp;
                <form:errors path="email" cssClass="error"/>
            </p>
            
            <p>
                <input type="submit" value="OK" />           
            </p>

        </form:form>

    </body>
</html>