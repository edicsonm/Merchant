<%@page import="javax.naming.Context"%>
<%@ page import="DB.ManageData"%>
<%@ page import="object.MerchantVO"%>
<%@ page import="java.util.ArrayList"%>
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
	ManageData manageData = new ManageData();
	ArrayList<MerchantVO> listMerchant = (ArrayList<MerchantVO>)manageData.listMerchantWithCertificates();
%>
<body>
	<form id="formID" action="sendPayment.jsp" method="post">
		<table border="1">
			<tr>
				<td colspan="2" align="center">
					Merchant Site
				</td>
			</tr>
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
					<select name="merchantID" id="merchantID">
						<% 
							for(int i =0; i<listMerchant.size();i++){
								MerchantVO merchantVO = (MerchantVO)listMerchant.get(i);
								%>
									<option value="<%=merchantVO.getIdMerchant() %>"><%=merchantVO.getNameMerchant()%></option>
								<%
							}
						%>
					</select>
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
	<br/><br/><br/><br/>
	<form action="upload.jsp">
		<input type="submit" value="Go to configure Certificate ...">
	</form>
</body>
</html>