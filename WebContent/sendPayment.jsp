<%@page import="metodos.SessionObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DB.ManageData"%>
<%@ page import="metodos.ProcesarRequest"%>
<%@ page import="metodos.SessionManager"%>
<%@ page import="object.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send Payment</title>
</head>
<body>
<% 
		String generatedPassword = null;	
		/* String orderNumber = (String)request.getParameter("orderNumber"); */
		String currency = (String)request.getParameter("currency");
		String merchantID = (String)request.getParameter("merchantID");
		String transactionAmount = (String)request.getParameter("transactionAmount");
		
		OrderVO orderVO = new OrderVO();
		orderVO.setOrderAmount(transactionAmount);
		ManageData manageData = new ManageData();
		int answer = manageData.insertOrder(orderVO);
		if(answer != 0) {
			String value = orderVO.getOrderID()+currency+merchantID+transactionAmount;
			ProcesarRequest procesarRequest = new ProcesarRequest();
			String sha1Value = procesarRequest.sha1Calculator(value);
			String signSha1 = procesarRequest.signSha1(sha1Value);
			
			ObjectVO objectVO = new ObjectVO();
			objectVO.setCurrency(currency);
			objectVO.setMerchantID(merchantID);
			objectVO.setOrderNumber(orderVO.getOrderID());
			objectVO.setTransactionAmount(transactionAmount);
			objectVO.setSha1Value(sha1Value);
			objectVO.setSignSha1(signSha1);
			session.setAttribute("orderID",orderVO.getOrderID());
			session.setAttribute("objectVO",objectVO);
			SessionManager.getInstance().setOrderNumber(orderVO.getOrderID());
			response.sendRedirect("confirm.jsp");
		} else {
			out.print("Wasn't possible save the order information, is impossible to continue with this proccess.");
		}
%>
</body>
</html>