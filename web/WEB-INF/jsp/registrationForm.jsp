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