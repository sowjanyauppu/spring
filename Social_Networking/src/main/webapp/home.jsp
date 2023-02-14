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
      <title>Dashboard</title>
      <style>
         .card:hover{
         background-color:#dedede;
         }
      </style>
      <link rel="stylesheet"
         href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
         integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
         crossorigin="anonymous">
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
         <h4>Welcome to social networking website. Find - Connect - Chat with new friends.</h4>
         <%}else{ response.sendRedirect("index.jsp");%>
         <%} %>
         <hr>
         <form action="<%=request.getContextPath()%>/Search" method="post">
            Find new friends having age from <input type="text"
               class="" id="fromAge" placeholder="Enter age from"
               name="fromAge"> To <input type="text"
               class="" id="toAge" placeholder="Enter age to"
               name="toAge"> and looking for 
            <select name="gender">
               <option value="">Any</option>
               <option value="M">Male</option>
               <option value="F">Female</option>
            </select>
            with marital status as 
            <select name="marital">
               <option value="">Any</option>
               <option value="S">Single</option>
               <option value="M">Married</option>
            </select>
            people.<br/><br/>Also, i like the 
            <input type="text" class="" id="city" placeholder="Enter city" name="city">
            city, search the people nearby this city.<br/><br/>
            <button type="submit" class="btn btn-primary">Find Friends</button>
         </form>
         <hr/>
         <div class="col-lg-12 row">
            <% 
               List<UserDetails> searchResultList = (List<UserDetails>)session.getAttribute("userList");
               if(searchResultList!=null && searchResultList.size()>0)
               {%>
            <%
               SimpleDateFormat formatter = new SimpleDateFormat("MMM dd,YYYY");
               for (UserDetails individualUser : searchResultList) {
               Date dob=new SimpleDateFormat("yyyy-MM-dd").parse(individualUser.getDob());
               String formattedDate = formatter.format(dob);
               %>
            <div class="col-lg-4 p-2">
               <div class="card m-1 col-12">
                  <div class="row">
                     <div class="col-2 pt-4">
                        <% if(individualUser.getGender().startsWith("M")) {%>
                        <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" style="width:72px">
                        <%}else if(individualUser.getGender().trim().startsWith("F")){ %>
                        <img src="https://cdn-icons-png.flaticon.com/512/417/417776.png" style="width:72px">
                        <%}%>
                     </div>
                     <div class="col-10">
                        <div class="card-body">
                        <form>
                           <input name="friendId" value="<%= individualUser.getId() %>" style="display:none;" />
                           <div class=""><b><%= individualUser.getName() %></b></div>
                           <div class="small"><span class="iocn"></span><i><%= individualUser.getCity() %></i></div>
                           <div>Born on <%= formattedDate %> and<br>age is <b><%= (int)((new java.util.Date().getTime()-dob.getTime())/(365L * 24L * 60L * 60L * 1000L)) %> years</b>
                           </div>
                           <button class="btn btn-warning" formaction="<%=request.getContextPath()%>/addfriend" style="position:absolute;top:0;right:0;font-weight:bold;font-size:22px;">+</button>
                           </form>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <%}%>
            <%}else{%>
            <div class="text-center">
               <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
               <lottie-player src="https://assets6.lottiefiles.com/packages/lf20_kay5m4bw.json"  background="transparent"  speed="1"  style="width: 300px; height: 300px;"  loop  autoplay></lottie-player>
            </div>
            <div>
               <h5>Oh! seems no one meet your requirement. Try to adjust your requirement to get more connections...!</h5>
            </div>
            <%}%>
         </div>
      </div>
      <jsp:include page="footer.jsp"></jsp:include>
   </body>
</html>