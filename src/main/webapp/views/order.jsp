<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Page</title>
</head>
<body>
	<h1>order Page</h1> <a href="<c:url value="/logout" />">logout </a>
		
		
		<form action="/user" method="post">
		<input type="Submit" value="Back"/>
		
		</form>
		
		
		
</body>
</html>