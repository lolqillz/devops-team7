<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Comment Form</title>
</head>
<body>
<form action="CreateCommentServlet" id="form-content" role="createCommentForm" method="post">
	Name: <input type="text" name="userName">
	Id: <input type="number" name="id">
	Comment: <input type="text" name="comment">
	<input type="submit" value="Call Servlet">
</form>

</body>
</html>