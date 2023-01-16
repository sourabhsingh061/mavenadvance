<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">User Registration</h1>
	<form  action="UserRegistrationData.jsp" model="post">
		<table align="center">
			<tr>
				<th>First Name:</th>
				<td><input type="text" name="fname" value="" placeholder="Enter Your Name"></td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><input type="text" name="lname" value="" placeholder="Enter Your Last Name"></td>
			</tr>
			<tr>
				<th>Gender:</th>
				<td><input type="radio" name="gender" value="male"> Male 
				<input type="radio" name="gender" value="female"> Female</td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="Email" name="email" value="" placeholder="Enter Your Email">  </td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="pwd" value="" placeholder="Enter Your Password"></td>
			</tr>
			<tr>
				<th>confirm Password:</th>
				<td><input type="Password" name="cpwd" value="" placeholder="Confirm Password"></td>
			</tr>
			<tr>
				<th>Submit:</th>
				<td><input type="submit" name="submit" value="Submit"> <input type="reset" name="cancel" value="Cancel"> </td>
			</tr>
			
			
		</table>

	</form>
</body>
</html>