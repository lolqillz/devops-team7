<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Reviews</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/create_review.jsp"
					class="btn btn success">Add New Reviews</a>
			</div>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>ID</th>
						<th>Book ID</th>
						<th>Review</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet's response to a loop -->
				<tbody>
					<c:forEach var="review" items="${listReviews}">
						<!-- For each user in the database, display their information accordingly -->
						<tr>
							<td><c:out value="${review.name}" /></td>
							<td><c:out value="${review.id}" /></td>
							<td><c:out value="${review.book_id}" /></td>
							<td><c:out value="${review.review}" /></td>
							<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->
							<td><a href="edit?name=<c:out value='${review.name}' />">Edit</a>
							<a href="delete?name=<c:out value='${review.name}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>