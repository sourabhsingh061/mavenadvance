<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.marksheet.MarksheetBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
a{
text-decoration:none;}
</style>
</head>
<body>

	<%@ includefile= "Header.jsp" %>
	<%
		MarksheetBean bean = new MarksheetBean();

		List list = (List) request.getAttribute("lis");
		Iterator<MarksheetBean> it = list.iterator();
	%>





	<form action="MarksheetListCtl" method="post">

		<h1 align="center">Marksheet records</h1>

		<table align="center">
			<tr align="center">

				<td><label>Name:</label> <input type=name name="fname" value=""
					placeholder="Enter your Name"> &emsp; <label>RollNo:</label><input
					type=name name="rollno" value="" placeholder="Enter Roll no.">
					&emsp;  <input type="submit" name="operation" value="search"></td>
			</tr>
			
			
			
			
			
		</table>
		<br>

		<table border="1" align="center"
			style="background-color: BurlyWood; text-align: center;" width="100%">



			<tr>
				<th>Select All <input type="checkbox" name="operation" value=""> </th>
				<th>ID</th>
				<th>Roll NO</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Physics</th>
				<th>Chemistry</th>
				<th>Maths</th>
				<th>Edit</th>
				
			</tr>
			<%
				while (it.hasNext()) {
					bean = it.next();
			%>
			<tr>
				<td><input type="checkbox" name="operation" value=""></td>
			
				<td><%=bean.getId()%></td>
				<td><%=bean.getRollno()%></td>
				<td><%=bean.getFname()%></td>
				<td><%=bean.getLname()%></td>
				<td><%=bean.getPhy()%></td>
				<td><%=bean.getChem()%></td>
				<td><%=bean.getMaths()%></td>
				<td><a href="AddMarksheet.jsp">Edit</a></td>
				
				
			</tr>

			<%
				}
			%>
		</table>
		</table>
		<table width="100%">

			<tr>
				<td><input type="submit" name="operation" value="Previous"></td>
				<td><input type="submit" name="operation" value="Add"></td>
				<td><input type="submit" name="operation" value="delete"></td>
				<td align="right"><input type="submit" name="operation" value="Next"></td>
			</tr>
		</table>


	</form>
	<%@include file="Footer.jsp"%>
</body>
</html>