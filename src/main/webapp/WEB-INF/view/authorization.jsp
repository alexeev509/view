<%--
  Created by IntelliJ IDEA.
  User: apathy
  Date: 25/07/2019
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form:form method="post" modelAttribute="user" action="/pageAfterAuthorization">
    <fieldset>
        <form:label path="login">Name: </form:label>
        <form:input path="login"></form:input>

        <form:label path="password">Password: </form:label>
        <form:input path="password"></form:input>
    </fieldset>
    <footer>
        <input type="submit" value="Login">
    </footer>
</form:form>

</body>
</html>
