<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Giriş Yapınız</title>
</head>
<body>
<form name="login" action="/login" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		Kullanıcı Adı = <input type="text" name="username"><br/>
		Şifre = <input type="password" name="password"><br/>
		<input type="submit" value="Giriş Yap"> 
	</form>
</body>
</html>