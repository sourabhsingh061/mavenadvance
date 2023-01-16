<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String cpwd = request.getParameter("cpwd");
	%>

	<h1 align="center">User Registration</h1>
	
	<table align="center">
		<tr>
			<th>First Name:</th>
			<td> <%=fname %></td>
		</tr>
		<tr>
			<th>Last Name:</th>
			<td> <%= lname%></td>
		</tr>
		<tr>
			<th>Gender:</th>
			<td> <%=gender%></td>
		</tr>
		<tr>
			<th>Email</th>
			<td> <%= email%></td>
		</tr>
		<tr>
			<th>Password:</th>
			<td> <%=pwd %></td>
		</tr>
		<tr>
			<th>Confirm Password:</th>
			<td> <%= cpwd%></td>
		</tr>
	</table>
	 
</body>
</html>

