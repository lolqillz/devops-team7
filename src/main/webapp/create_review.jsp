<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CreateReviewServlet" method="post">
	Name: <input type="text" name="userName">
	Id: <input type="number" name="id">
	Book_id: <input type="number" name="book_id">
	Review: <input type="text" name="review">
	<input type="submit" value="Call Servlet">
</form>

</body>
</html>