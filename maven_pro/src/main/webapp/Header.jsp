<%@page import="com.rays.mavenpro.UserRegistrationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
	<table style="width: 100%">
	<%UserRegistrationBean bin=(UserRegistrationBean)session.getAttribute("user"); 
	boolean loggedin = bin!=null;
	
	%>
	
		<tr>
			<td><a href="WelcomeView.jsp">Welcome</a> |
			
			<%if(loggedin){ %>
			 <a href="Logout.jsp">Logout</a><h3>Hi,<%=bin.getFname() %></h3>
			 <%}else{ %>
			 <a href="LoginView.jsp">Login</a>
			  <h3>Hi,Guest</h3>
			 <%} %>
			
			 </td>
			<td><img style= "width:180px; height:80px" src="img/aaa.png" align="right" ></td>
		</tr>
		<%if(loggedin){ %>
		<tr>
		<td colspan="2"><a href="MyProfileView.jsp">My Profile</a> |
		<a href="GetMarksheet.jsp">Get Marksheet</a> |
	<a href="">Merit Marksheet List</a>|
	<a href="">Change Password</a>|
	<a href="">Java Doc</a>|
	<a href="AddMarksheet.jsp">Add Marksheet</a>|
	<a href="MarksheetListCtl">Marksheet List</a>|
	<a href="">Add User</a>|
	<a href="">User List</a>|
	<a href="">Add College</a>|
	<a href="">College List</a>|
	<a href="">Add Student</a>|
	<a href="">Student List</a>|
	<a href="">Add Role</a>|
	<a href="">Role List</a>|
	
		</td>
		</tr>
		<%} %>
	</table>
	<hr>

</body>
</html>