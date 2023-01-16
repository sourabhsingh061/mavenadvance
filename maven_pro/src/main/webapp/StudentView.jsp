
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.student.Studentbean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Studentlistctl">	
<%
Studentbean bean = new Studentbean();

List list =(List) request.getAttribute("lis");
Iterator <Studentbean>it = list.iterator();
%>


      <h1 align="center">Student Record</h1>
      <table width="100%">
                <tr>
                    <td align="center"><label> Name :</label> <input type="text" name="name" value="">
                        &emsp; <label>RollNo :</label> <input type="text" name="rollNo" value="">&emsp;
                        <input type="submit" name="operation" value="Search">
                    </td>
                </tr>
            </table>
<table border="1" align="center" style="background-color: BurlyWood ;  text-align: center;" width="100%">

	
	
<tr>
<td> Id</td>
<td> Rollno</td>
<td> First Name</td>
<td> Last Name</td>
<td> Session</td>

</tr>
<%
while(it.hasNext()){
	bean =it.next();
%>
<tr>
<td><%=bean.getId() %></td>
<td><%=bean.getRollno() %></td>
<td><%=bean.getFname() %></td>
<td><%=bean.getLname() %></td>
<td><%=bean.getSession() %></td>


</tr>
<%
}
%>

<table width="100%">

<tr>
<td >  <input type = "submit" name = "operation" value = "Previous" ></td> 
<td >  <input type = "submit" name = "operation" value = "Add" ></td> 
<td >  <input type = "submit" name = "operation" value = "Delete"> </td>
<td align ="right">  <input type = "submit" name = "operation" value = "Next" ></td> 
</tr>
</table>
</table>
</form>
</body>
</html>