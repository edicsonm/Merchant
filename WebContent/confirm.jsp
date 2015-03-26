<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="object.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirm Transaction</title>
<script src="js/jquery-2.1.1.js"></script>
</head>
<script type="text/javascript">
	
	function openWin() {
		setInterval(function(){
			$("#msgid").load("paymentReceived.jsp");	
		}, 2000);
		myWindow = window.open("","VentanaPago", "fullscreen=yes,scrollbars=yes");
		/* myWindow = window.open("","VentanaPago", "directories=yes,titlebar=yes,toolbar=yes,location=yes,status=yes,menubar=yes,scrollbars=yes"); */
	    $("#formID").submit();
	}
	
</script>
<% 
	ObjectVO objectVO = (ObjectVO)session.getAttribute("objectVO");
%>
<body>	
	<form id="formID" action="http://www.portal.billingbuddy.com/web/guest/paymentpage" target = "VentanaPago" method="post">
	<!-- <form id="formID" action="http://portal.billingbuddy.com/web/paymentbillingbuddy" target = "VentanaPago" method="post"> -->
	<!-- <form id="formID" action="http://portal.billingbuddy.com/web/paymentsite" target = "VentanaPago" method="post"> -->
	<!-- <form id="formID" action="https://billingbuddy/web/paymentsite" target = "VentanaPago" method="post"> -->
	
		<table border="1">
			<tr>
				<td colspan="2" align="center">
					Merchant Site - Confirmation Page
				</td>
			</tr>
			<tr>
				<td>
					Order Number
				</td>
				<td>
					<%=objectVO != null && objectVO.getOrderNumber() != null ? objectVO.getOrderNumber() : "N/D"%>
					<input id="orderNumber" name="orderNumber" type="hidden" value="<%=objectVO != null && objectVO.getOrderNumber() != null ? objectVO.getOrderNumber() : "N/D"%>">
				</td>
			</tr>
			<tr>
				<td>
					Currency
				</td>
				<td>
					<%=objectVO != null && objectVO.getCurrency() != null ? objectVO.getCurrency() : "N/D"%>
					<input id="currency" name="currency" type="hidden" value="<%=objectVO != null && objectVO.getCurrency() != null ? objectVO.getCurrency() : "N/D"%>">
				</td>
			</tr>
			<tr>
				<td>
					MerchantID
				</td>
				<td>
					<%=objectVO != null && objectVO.getMerchantID() != null ? objectVO.getMerchantID() : "N/D"%>
					<input id="merchantID" name="merchantID" type="hidden" value="<%=objectVO != null && objectVO.getMerchantID() != null ? objectVO.getMerchantID() : "N/D"%>">
				</td>
			</tr>
			<tr>
				<td>
					Transaction Amount
				</td>
				<td>
					<%=objectVO != null && objectVO.getTransactionAmount() != null ? objectVO.getTransactionAmount() : "N/D"%>
					<input id=transactionAmount name="transactionAmount" type="hidden" value="<%=objectVO != null && objectVO.getTransactionAmount() != null ? objectVO.getTransactionAmount() : "N/D"%>">
				</td>
			</tr>
			
			<tr>
				<td>
					Sha1
				</td>
				<td>
					<%=objectVO != null && objectVO.getSha1Value() != null ? objectVO.getSha1Value() : "N/D"%>
					<input id=sha1Value name="sha1Value" type="hidden" value="<%=objectVO != null && objectVO.getSha1Value() != null ? objectVO.getSha1Value() : "N/D"%>">
				</td>
			</tr>
			
			<tr>
				<td>
					Sha1 Sign
				</td>
				<td>
					<%=objectVO != null && objectVO.getSignSha1() != null ? (objectVO.getSignSha1().substring(0, 32) + "..."+objectVO.getSignSha1().substring(objectVO.getSignSha1().length() - 32, objectVO.getSignSha1().length())) : "N/D"%>
					<input id=signSha1 name="signSha1" type="hidden" value="<%=objectVO != null && objectVO.getSignSha1() != null ? objectVO.getSignSha1() : "N/D"%>">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="Send payment ..." onclick="openWin();">
				</td>
			</tr>
		</table>
		<div id="msgid"></div>
		<div id="msgid2"></div>
	</form>
</body>
<script type="text/javascript">
	/* $("#msgid").html("This is Hello World by JQuery"); */
</script>
</html>
