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
	    String rollno = (String) request.getAttribute("rollno");

		String fname = (String) request.getAttribute("fname");
		String lname = (String) request.getAttribute("lname");
		String user = (String) request.getAttribute("lname");
		String error = (String) request.getAttribute("error");



		
	%>
	
	<%
 	if (user != null) {
 %> <%=user%> <%
 	}
 %>
 
 
 
 <%
 	if (error != null) {
 %> <%=error%> <%
 	}
 %>
	
	
	<form action="AddMarksheetCtl" method="post"  >
		<table align="center">
		<h1 align="center">Add Marksheet</h1>
			<tr>
				<th>Rollno :</th>
				<td><input type=text name=rollno value=""
					Placeholder="Enter Roll No."></td>
					
					<td>
					<%
 	if (rollno != null) {
 %> <%=rollno%> <%
 	}
 %>
					</td>
					
			</tr>
			<tr>
				<th>First Name :</th>
				<td><input type=text name=fname value=""
					Placeholder="Enter First Name"></td>
					
						
					<td>
					<%
 	if (fname != null) {
 %> <%=fname%> <%
 	}
 %>
					</td>
			</tr>
			<tr>
				<th>Last Name :</th>
				<td><input type=text name=lname value=""
					Placeholder="Enter last Name"></td>
						
					<td>
					<%
 	if (lname != null) {
 %> <%=lname%> <%
 	}
 %>
					</td>
			</tr>
			<tr>
				<th>Physics :</th>
				<td><input type=text name=phy value=""
					Placeholder="Enter Physics Marks"></td>
					
			</tr>
			<tr>
				<th>Chemistry :</th>
				<td><input type=text name=chem value=""
					Placeholder="Enter Chemistry Marks"></td>
					
			</tr>
			<tr>
				<th>Maths :</th>
				<td><input type=text name=maths value=""
					Placeholder="Enter Maths Marks"></td>
					
			</tr>
			<tr>
				<th>Submit :</th>
				<td><input type=Submit name="operation" value="Submit"> &emsp;
				<input type=Submit name="operation" value="Update"></td>
				
			</tr>

		</table>
		
		
		
		
		
	</form>
	<%@ includefile= "Footer.jsp" %>

</body>
</html>