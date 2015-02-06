<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Merchant Sells ....</title>
</head>
<script type="text/javascript">

</script>
<% 
%>
<body>
	<form id="formID" action="sendPayment.jsp" method="post">
		<table border="1">
			<tr>
				<td colspan="2" align="center">
					Merchant Site
				</td>
			</tr>
			<!-- <tr>
				<td>
					Order Number
				</td>
				<td>
					<input id="orderNumber" name="orderNumber" type="text" value="1003021">
				</td>
			</tr> -->
			<tr>
				<td>
					Currency
				</td>
				<td>
					<input id="currency" name="currency" type="text" value="USD">
				</td>
			</tr>
			<tr>
				<td>
					MerchantID
				</td>
				<td>
					<input id="merchantID" name="merchantID" type="text" value="2">
				</td>
			</tr>
			<tr>
				<td>
					Transaction Amount
				</td>
				<td>
					<input id=transactionAmount name="transactionAmount" type="text" value="550.76">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Pay">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>