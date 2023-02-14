<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.bitlabs.dao.UserDetails" %>
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
<%UserDetails user = (UserDetails)session.getAttribute("userdetails");%>
	<h2>User Register Form</h2>
	<div class="col-md-6 col-md-offset-3">
	<%if(session.getAttribute("statusmsg")!=""){%>
			<div class="alert alert-success center" role="alert">
				<p><%=session.getAttribute("statusmsg") %></p>
			</div>
			<%} %>
			<form method="post">
				<div class="form-group">
				<label for="uname">Full Name:</label> <input type="text" value="<%= user.getName() %>"
					class="form-control" id="username" placeholder="User Name"
					name="name">
			</div>
			<div class="form-group">
				<label for="mail">Email Id:</label> <input type="text" value="<%= user.getEmail() %>"
					class="form-control" id="mail" placeholder="email id"
					name="email">
			</div>

			<div class="form-group">
				<label for="phno">Mobile Number:</label> <input type="text" value="<%= user.getMobilenumber() %>"
					class="form-control" id="phno" placeholder="mobile no"
					name="mbno">
			</div>
			
			<div class="form-group">
				<label for="dob">Date Of Birth:</label> <input type="text" value="<%= user.getDob() %>"
					class="form-control" id="dob" placeholder="dob"
					name="dob">
			</div>
			<div class="form-group">
				<label for="city">City:</label> <input type="text" value="<%= user.getCity() %>"
					class="form-control" id="city" placeholder="city"
					name="city">
			</div>
					<button type="submit" class="btn btn-primary" formaction="<%=request.getContextPath()%>/userupdate">Update</button>
					<button type="submit" class="btn btn-danger" formaction="<%=request.getContextPath()%>/userdelete">Delete My Profile</button>

				</form>
			</div>
		</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>