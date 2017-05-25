<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer profile</title>
</head>
<body>	
		<h1>Get Customer Data </h1>
			
		
		<form action="/cutomers/list" method="post">
		<input type="text" name="email" >
		<input type="submit" value="get Customer Data (By Email) ">		
		</form>
		<a href="<c:url value="/customers/manage" />"> Back </a>
		
		
		
</body>
</html>