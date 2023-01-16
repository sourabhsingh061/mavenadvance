<%@page import="com.rays.mavenpro.UserRegistrationBean"%>
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
		String email = (String) request.getAttribute("email");
		String send = (String) request.getAttribute("send");
		String use = (String) request.getAttribute("use");
	%>



  
	<form align="center" action="ForgetCtl" method ="post">


		<h3 align="center">Forgot Your Password</h3>
				<h3 align="center">Your Password is: 
				
				<%
 	if (send != null) {
 %>
 <%=send%>  <%
 	}
 %>
				
				</h3>
		
		<tr>
			<th>Username:</th>
			<td><input type="text" name="username" value=""
				placeholder="Enter Your Username"> 
				<%
 	if (email != null) {
 %> <%=email%> <%
 	}
 %>
 
 
  <%
 	if (use != null) {
 %>
 <%=use%>  <%
 	}
 %></td>
		</tr>
		<tr>
			<th>Submit:</th>
			<td><input type="submit" name="submit" value="Submit"></td>
		</tr>



	</form>


	<%@ includefile= "Footer.jsp" %>


</body>
</html>