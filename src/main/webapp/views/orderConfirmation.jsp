<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>

	<div style="height: 100px;"></div>
	<div
		style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 16px;">
		<table width="100%">
			<tr>
				<td align="center">
					<table width="40%" border="0" cellspacing="3" cellpadding="1">
						<tr>
							<td><form:form method="post"  commandName="complete">
									<h1>
										<spring:message code="orderConfMsg" />
									</h1>
									
									<input type="submit" value="Finish">
								</form:form></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

	</div>
</body>

</html>