<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<% session.removeAttribute("userdetails"); %>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
	<% if(session.getAttribute("statusmsg")!=null && session.getAttribute("statusmsg")!=""){ %>
	<div class="alert alert-success center" role="alert">
				<p><%=session.getAttribute("statusmsg") %></p>
			</div>
			<%} %>
		<h1>Login Form</h1>
		<form action="<%=request.getContextPath()%>/LoginController" method="post">

			
			<div class="form-group">
				<label for="mail">Email Id:</label> <input type="text"
					class="form-control" id="mail" placeholder="email id"
					name="email" required>
			</div>

			<div class="form-group">
				<label for="ps">Password:</label> <input type="password"
					class="form-control" id="ps" placeholder="Password"
					name="pwd" required>
			</div>
	
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>