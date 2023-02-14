<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

	<h2>User Register Form</h2>
	<div class="col-md-6 col-md-offset-3">
			<div class="alert alert-success center" role="alert">
				<p><%=session.getAttribute("statusmsg") %></p>
			</div>
			
			<form action="<%=request.getContextPath()%>/RegController" method="post">
				<div class="form-group">
				<label for="uname">Full Name:</label> <input type="text"
					class="form-control" id="username" placeholder="User Name"
					name="name">
			</div>
			<div class="form-group">
				<label for="mail">Email Id:</label> <input type="text"
					class="form-control" id="mail" placeholder="email id"
					name="email">
			</div>

			<div class="form-group">
				<label for="ps">Password:</label> <input type="password"
					class="form-control" id="ps" placeholder="Password"
					name="pwd">
			</div>

			<div class="form-group">
				<label for="phno">Mobile Number:</label> <input type="text"
					class="form-control" id="phno" placeholder="mobile no"
					name="mbno">
			</div>
			<div class="form-group">
				<label>Gender: </label><br>
				<input type="radio" id="gender" name="gender" value="M">
				<label for="gender"> Male</label>
				<input class="clear" type="radio" id="gender" name="gender" value="F">
				<label for="gender"> Female</label><br>
			</div>
			<div class="form-group">
				<label>Marital Status: </label><br>
				<input type="radio" id="marital" name="marital" value="S">
				<label for="marital"> Single</label>
				<input class="clear" type="radio" id="marital" name="marital" value="M">
				<label for="marital"> Married</label><br>
			</div>
			<div class="form-group">
				<label for="dob">Date Of Birth:</label> <input type="text"
					class="form-control" id="dob" placeholder="dob"
					name="dob">
			</div>
			<div class="form-group">
				<label for="city">City:</label> <input type="text"
					class="form-control" id="city" placeholder="city"
					name="city">
			</div>
					<button type="submit" class="btn btn-primary">Submit</button>

				</form>
			</div>
		</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>