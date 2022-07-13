<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
	crossorigin="anonymous">


<title>Students Directory</title>



</head>
<body>
	<div class="container mt-5">

		<h3>Students Directory</h3>
		
		<br>
		<br>
		
	   <h2>Hi! ${username}</h2>
		
		<a style="float:right;color: white" href="/DebateEvent/logout" class="btn btn-warning mb-3 btn-lg active"
			role="button" aria-pressed="true">Logout
			</a>
		
		<br>
		<br>	
		<hr>
		
		

		<a href="/DebateEvent/student/showFormForAdd" class="btn btn-warning mb-3 btn-lg active"
			style="color: white" role="button" aria-pressed="true">Add
			student</a>

		<table class="table table-bordered table-striped">
			<thead class="table-warning">
				<tr>
					<th>Student id</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Course</th>
					<th>Country</th>
					<th>Actions</th>

				</tr>
			</thead>

			<tbody>
				<c:forEach items="${students}" var="tempStudent">
					<tr>
						<td>${tempStudent.id}</td>
						<td>${tempStudent.firstName}</td>
						<td>${tempStudent.lastName}</td>
						<td>${tempStudent.course}</td>
						<td>${tempStudent.country}</td>
						<td><a class="delete" id="del"
							href="/DebateEvent/student/delete?id=${tempStudent.id}"
							onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">
								<i class="fa fa-trash" style="color: red; margin-left: 2rem"
								aria-hidden="true"></i>
						</a> <a href="/DebateEvent/student/showFormForUpdate?id=${tempStudent.id}"><i
								class="fas fa-edit" style="margin-left: 2rem"></i></a></td>




					</tr>
				</c:forEach>

			</tbody>
		</table>




	</div>

</body>
</html>