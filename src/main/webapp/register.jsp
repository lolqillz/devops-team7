<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RegisterServlet" method="post">
	Name: <input type="text" name="userName">
	Password: <input type="password" name="password">
	Email: <input type="text" name="email">
	Language: <select name="language">
		<option>English</option>
		<option>Spanish</option>
		<option>French</option>
	</select>
	<input type="submit" value="Call Servlet" />
</form>

</body>
</html>