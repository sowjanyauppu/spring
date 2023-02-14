<%@ page import="com.bitlabs.dao.UserDetails" %>
<header>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: tomato">
		<div>
			<a href="https://www.javaguides.net" class="navbar-brand"> Social Networking</a>
		</div>

		<ul class="navbar-nav navbar-collapse justify-content-end">
		<% if(session.getAttribute("userdetails")==null){ %>
			<li><a href="<%= request.getContextPath() %>/index.jsp" class="nav-link">Login</a></li>
			<li><a href="<%= request.getContextPath() %>/register.jsp" class="nav-link">Signup</a></li>
			<%}else{ %>
			<li>Hi, <%= ((UserDetails)session.getAttribute("userdetails")).getName() %></li>
			<li><a href="<%= request.getContextPath() %>/home.jsp" class="nav-link">Home</a></li>
			<li><a href="<%= request.getContextPath() %>/myfriends.jsp" class="nav-link">My Friends</a></li>
			<li><a href="<%= request.getContextPath() %>/updateuser.jsp" class="nav-link">Profile</a></li>
			<li><a href="<%= request.getContextPath() %>/index.jsp" class="nav-link">Logout</a></li>
			<%} %>
		</ul>
	</nav>
</header>