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
		request.setAttribute("laptop", "hp");

		String fruits = (String) request.getAttribute("fruits");
		String car = (String) request.getAttribute("car");
		String laptop = (String) request.getAttribute("laptop");
	%>


	<%=fruits%>


	<%=car%>

	<%=laptop%>


</body>
</html>