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
<title>Comment Management</title>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Comments</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/create_comment.jsp"
					class="btn-success">Add New Comment</a>
			</div>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table" id="commentTable" role="commentList">
				<thead>
					<tr>
						<th>Name</th>
						<th>ID</th>
						<th>Comment</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet's response to a loop -->
				<tbody>
					<c:forEach var="comment" items="${listComments}">
						<!-- For each user in the database, display their information accordingly -->
						<tr>
							<td><c:out value="${comment.name}" /></td>
							<td><c:out value="${comment.id}" /></td>
							<td><c:out value="${comment.comment}" /></td>
							<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->
							<td><a href="edit?name=<c:out value='${comment.name}' />">Edit</a>
							<a href="delete?name=<c:out value='${comment.name}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>