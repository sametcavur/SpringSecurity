<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<security:authorize access="hasRole('USER')">
<h1>Buraya user erişebilir</h1>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
<h1>Buraya admin erişebilir</h1>
</security:authorize>

</body>
</html>