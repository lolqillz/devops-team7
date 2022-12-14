<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="CommentServlet" method ="post">
	Name : <input type="text" name="userName">
	Comment: <input type="text" name="comment">
	
	<input type="submit" value="Call Servlet" />
</form>
</body>
</html>