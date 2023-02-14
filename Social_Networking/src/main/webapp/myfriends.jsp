<%@page import="java.net.http.HttpClient.Redirect"%>
<%@page import="java.io.Console"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page import="com.bitlabs.dao.UserDetails" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="ISO-8859-1">
      <title>My Friends</title>
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
      <link rel="stylesheet"
         href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
         integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
         crossorigin="anonymous">
      <script type="text/javascript">
         $(document).ready(function() {
             $.ajax({
                 type: "POST",
                 url: "http://localhost:8080<%=request.getContextPath()%>/myfriends",
                 success: function(data) {
                     // process the response from the controller
                 }
             });
         });
      </script>
   </head>
   <body>
      <jsp:include page="header.jsp"></jsp:include>
      <div class="container col-md-8 col-md-offset-3" style="overflow: auto">
         <%if(session.getAttribute("statusmsg")!=""){		 %>
         <div class="alert alert-success center" role="alert">
            <p><%=session.getAttribute("statusmsg") %></p>
         </div>
         <%}%>
         <%UserDetails userObj = (UserDetails)session.getAttribute("userdetails");
            if (userObj != null && userObj.getId()>0) {%>
         <h1>Hello, <%= userObj.getName() %></h1>
         <h4>Friends List</h4>
         <%}else{ response.sendRedirect("index.jsp");%>
         <%} %>
         <form action="<%=request.getContextPath()%>/Search" method="post">
         </form>
         <hr/>
         <div class="col-lg-12 row">
            <% 
               List<UserDetails> users = (List<UserDetails>)session.getAttribute("friendsList");
               if(users!=null && users.size()>0)
               {%>
            <%
               SimpleDateFormat formatter = new SimpleDateFormat("MMM dd,YYYY");
               for (UserDetails user : users) {
               if(user.isAccepted()){
               Date dob=new SimpleDateFormat("yyyy-MM-dd").parse(user.getDob());
               String formattedDate = formatter.format(dob);
               %>
            <div class="col-lg-4 p-2">
               <div class="card m-1 col-12">
                  <div class="row">
                     <div class="col-2 pt-4">
                        <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" style="width:72px">
                     </div>
                     <div class="col-10">
                     <form>
                        <div class="card-body">
                           <input name="friendId" value="<%= user.getId() %>" style="display:none;" />
                           <div class=""><b><%= user.getName() %></b></div>
                           <div class="small"><span class="iocn"></span><i><%= user.getCity() %></i></div>
                           <div>Born on <%= 
                              formattedDate %> and<br>age is <b><%= (int)((new java.util.Date().getTime()-dob.getTime())/(365L * 24L * 60L * 60L * 1000L)) %> years</b></div>
                              <button class="btn btn-danger" formaction="<%=request.getContextPath()%>/reject" style="position:absolute;top:0;right:0;font-weight:300;font-size:22px;">x</button>
                        </div>
                      </form>
                     </div>
                  </div>
               </div>
            </div>
            <%}}}else{%>
            <div class="text-center">
               <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
               <lottie-player src="https://assets6.lottiefiles.com/packages/lf20_kay5m4bw.json"  background="transparent"  speed="1"  style="width: 300px; height: 300px;"  loop  autoplay></lottie-player>
            </div>
            <div>
               <h5>Oh! you don't have any friends...!<br>try to search new friends by clicking <a href="home.jsp">here</a>.</h5>
            </div>
            <%}%>
         </div>
         <hr/>
         <h4>Friend Requests</h4>
         <div class="col-lg-12 row">
            <% 
               if(users!=null && users.size()>0)
               {%>
            <%
               SimpleDateFormat formatter = new SimpleDateFormat("MMM dd,YYYY");
               for (UserDetails user : users) {
               
               if(!user.isAccepted()){
               Date dob=new SimpleDateFormat("yyyy-MM-dd").parse(user.getDob());
               String formattedDate = formatter.format(dob);
               %>
            <div class="col-lg-4 p-2">
               <div class="card m-1 col-12">
                  <div class="row">
                     <div class="col-2 pt-4">
                        <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" style="width:72px">
                     </div>
                     <div class="col-10">
                     <form>
                        <div class="card-body">
                           <input name="friendId" value="<%= user.getId() %>" style="display:none;" />
                           <div class=""><b><%= user.getName() %></b></div>
                           <div class="small"><span class="iocn"></span><i><%= user.getCity() %></i></div>
                           <div>Born on <%= 
                              formattedDate %> and<br>age is <b><%= (int)((new java.util.Date().getTime()-dob.getTime())/(365L * 24L * 60L * 60L * 1000L)) %> years</b></div>
                           <button class="btn btn-success" formaction="<%=request.getContextPath()%>/approve" style="position:absolute;top:0;right:40px;font-weight:bold;font-size:22px;">+</button>
                           <button class="btn btn-danger" formaction="<%=request.getContextPath()%>/reject" style="position:absolute;top:0;right:0;font-weight:300;font-size:22px;">x</button>
                        </div>
                     </form>
                     </div>
                  </div>
               </div>
            </div>
            <%}}}%>
         </div>
      </div>
      <jsp:include page="footer.jsp"></jsp:include>
   </body>
</html>