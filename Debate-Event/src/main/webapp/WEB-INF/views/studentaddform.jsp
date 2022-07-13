<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Student</title>


</head>
<body>

	<div class="container">


		<hr>

		<p class="h4 mb-4">Enter the student details</p>

		<form action="save" method="POST">



			<div class="form-inline">
				<input type="text" name="firstName" value="${student.firstName}"
					class="form-control mb-4 col-4" placeholder="First Name">



			</div>

			<div class="form-inline">

				<input type="text" name="lastName" value="${student.lastName}"
					class="form-control mb-4 col-4" placeholder="Last Name">



			</div>
			
			
			<div class="form-inline">

				<input type="text" name="course" value="${student.course}"
					class="form-control mb-4 col-4" placeholder="Course">



			</div>

			<div class="form-inline">

				<input type="text" name="country" value="${student.country}"
					class="form-control mb-4 col-4" placeholder="Country">



			</div>


			<button type="submit" id="save"
				class="btn btn-success btn-info col-2">Save</button>


		</form>

		<hr>
		<a href="/DebateEvent/student/list">Back to Students List</a>



	</div>


</body>
</html>