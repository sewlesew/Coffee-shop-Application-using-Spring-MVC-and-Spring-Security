<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Management</title>
</head>
<body>
<h1>Order Management</h1>


<a href="<c:url value="/orders/list" />">List of Orders</a> <br>
<br>
<a href="<c:url value="/admin" />"> Back </a>

</body>
</html>