<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Data</title>
</head>
<body>	
		<a href="<c:url value="/logout" />"> LogOut </a> 
		<br> 
		<br>		
		<h2>Customer data</h2>
		
		
		
		<table>
		
		<tr>
		<td>First_Name </td>
		<td>Last_Name</td>
		<td>Email </td>
		<td>Phone</td>
        <td>city</td>
        <td>State</td>	
        <td>Country</td>	
        <td>ZipCode</td>			
		</tr>
		
		<c:forEach var="customer" items="${cust}">		
		<tr>	
		<td>${customer.firstName}</td>
		<td>${customer.lastName}</td>
		<td>${customer.email}</td>
		<td>${customer.phone}</td>
		<td>${customer.address.city}</td>
		<td>${customer.address.state}</td>
		<td>${customer.address.country}</td>
		<td>${customer.address.zipcode}</td>
		</tr>
		</c:forEach>
		
		</table>
		
		
		
		<a href="<c:url value="/customers/list" />"> Back </a>
		
		
		
		
</body>
</html>