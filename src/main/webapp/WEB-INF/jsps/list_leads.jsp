<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Leads</title>
</head>
<body>
	<h2>...List All Leads...</h2>
	<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Actions</th>
			</tr>
			
			<tr>
				<c:forEach var="lead" items="${leads}" >
				 <tr>
				    <td>${lead.firstName}</td>
				    <td>${lead.lastName}</td>
				    <td>${lead.email}</td>
				    <td>${lead.mobile}</td>
				    
				    <td>
				      <a href="delete?id=${lead.id}">DELETE</a>
				      <a href="update?id=${lead.id}">UPDATE</a>
				    </td>
				 </tr>
				</c:forEach>
			</tr>
			
			<tr>
				<td><input type="submit" value="SAVE"></td>
			</tr>
		</table>
	
</body>
</html>