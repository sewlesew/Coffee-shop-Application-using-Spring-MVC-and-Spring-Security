<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<body>


<div align="center" style="margin-top:15px">
<h2>Order Summary</h2>
        <table border="1">
           
            <tr>
                <td colspan="2" align="center">
                    <h3>Customer Data</h3>
                </td>
            </tr>
            <tr>
                <td>First Name:</td>
               <td>${order.person.firstName}</td>
            </tr>
            <tr>
                <td>Last Name:</td>
              <td>${order.person.lastName}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${order.person.email}</td>
            </tr>           
 
        </table>
    </div>
    
    <div align="center" style="margin-top:15px">

  <table border="1">
            <tr>
                <td colspan="5" align="center"><h2>Order</h2></td>
            </tr>
            <tr>
            <td><h3>Product Name</h3></td>
            <td><h3>Product Type</h3></td>
             <td><h3>Quantity</h3></td>
             <td><h3>Price</h3></td>             
              <td><h3>Order Date</h3></td>
            </tr>
            
            <c:forEach items="${order.orderLines}" var="orderLine">
					<tr>
						<td>${orderLine.product.productName}</td>
						<td>${orderLine.product.productType}</td>
						<td>${orderLine.quantity}</td>
						<td>${orderLine.product.price}</td>
						<td>${orderLine.order.orderDate}</td>
					</tr>
				</c:forEach>
            <tr>
                
        </table>
    </div>
    
     <div align="center" style="margin-top:15px">
     <form:form action="${flowExecutionUrl}">
              <table width="30%" border="0" cellspacing="2"
							cellpadding="2"  style="margin-left:75px"
							>
							<tr>
								<td ><button type="submit" id="previous"
										name="_eventId_previous">
										<spring:message code="previous" />
									</button></td>
								<td><button type="submit" id="next"
										name="_eventId_next">
										<spring:message code="orderNow" />
									</button></td>
								<td><button type="submit" id="cancel"
										name="_eventId_cancel">
										<spring:message code="cancel" />
									</button></td>
							</tr>
												</table>
												</form:form>
</div>

	
</body>