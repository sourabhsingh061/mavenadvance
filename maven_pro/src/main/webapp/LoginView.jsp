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
	<form action="Loginctll" method="post">
		<%
			String one = (String) request.getAttribute("one");
			String email = (String) request.getAttribute("email");
			String pwd = (String) request.getAttribute("pwd");
			String two = (String) request.getAttribute("two");
			String mssg = (String) request.getAttribute("mssg");


		%>
		
		

		<table align="center">
			<h1 align="center">LogIn</h1>
			<%
				if (one != null) {
			%>
			<h3 style="color: red" align="center"><%=one%></h3>

			<%
				}
			%>

			<%
				if (two != null) {
			%>
			<h3 style="color: red" align="center"><%=two%></h3>

			<%
				}
			%>

			<tr>
				<th>Username:</th>
				<td><input type="text" name="username" value=""
					placeholder="Enter Your Username"> 
					
<%if (email != null) {
 %> <%=email%> <%
 	}
 %></td>

			</tr>


			<tr>
				<th>Password:</th>
				<td><input type="password" name="pwd" value=""
					placeholder="Enter Your Password"> <%
 	if (pwd != null) {
 %> <%=pwd%> <%
 	}
 %>   
 
 <%
				if (mssg != null) {
			%>
			<h3 style="color: red" align="center"><%=mssg%></h3>

			<%
				}
			%>
 
 </td>
			</tr>
			
			<tr>
				<th>Submit:</th>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
				<th>Cancel:</th>
				<td><input type="reset" name="cancel" value="Cancel"></td>
			</tr>

			<tr>
				<td><a href="UserRegistrationView.jsp">Create an account</a> |
					<a href="ForgetView.jsp">Forget Password</a></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="hidden" name="jsession" value="<%=session.getId()%>"></td>
			</tr>
		</table>
	</form>




	<%@ includefile= "Footer.jsp" %>

</body>
</html>

