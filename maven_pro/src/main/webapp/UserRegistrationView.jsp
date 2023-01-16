<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ includefile= "Header.jsp" %>

	<%
		String fname = (String) request.getAttribute("fname");
		String lname = (String) request.getAttribute("lname");
		String gender = (String) request.getAttribute("gender");
		String email = (String) request.getAttribute("email");
		String pwd = (String) request.getAttribute("pwd");
		String cpwd = (String) request.getAttribute("cpwd");
		String error = (String) request.getAttribute("error");
		String user = (String) request.getAttribute("user");

		if (user != null) {
	%>
	<%=user%>
	<%} else if (error != null) {%>
	<%=error%>
	<%
		}
	%>



	<h1 align="center">User Registration</h1>
	<form action="UserRegistrationCtl" method="post">
		<table align="center">
			<tr>
				<th>First Name:</th>
				<td><input type="text" name="fname" value=""
					placeholder="Enter Your Name">
						<%if (fname != null)%><%=fname%>
					</td>
			
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><input type="text" name="lname" value=""
					placeholder="Enter Your Last Name">
				<%if (lname != null)%><%=lname%>
</td>
			</tr>
			
			
			<tr>
				<th>Gender:</th>
				<td><input type="radio" name="gender" value="male">
					Male <input type="radio" name="gender" value="female">
					Female </td>
					<td><%if (gender != null)%><%=gender%></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="Email" name="email" value=""
					placeholder="Enter Your Email"></td>
				<%if (email != null)%><%=email%>
</td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="pwd" value=""
					placeholder="Enter Your Password">
				<%if (pwd != null)%><%=pwd%>
</td>
			</tr>
			<tr>
				<th>confirm Password:</th>
				<td><input type="Password" name="cpwd" value=""
					placeholder="Confirm Password">
				<%if (cpwd != null)%><%=cpwd%>
</td>
			</tr>
			<tr>
				<th>Submit:</th>
				<td><input type="submit" name="submit" value="Submit">
					<input type="reset" name="cancel" value="Cancel"></td>
			</tr>


		</table>

	</form>
	<%@ includefile= "Footer.jsp" %>

</body>
</html>