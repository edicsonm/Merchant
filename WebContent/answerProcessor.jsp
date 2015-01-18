<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="metodos.SessionManager"%>
<%@ page import="DB.ManageData"%>
<%@ page import="object.*"%>
<%
	String approbationNumber = (String)request.getParameter("approbationNumber");
	String orderNumber = (String)request.getParameter("orderNumber");
	System.out.println("approbationNumber: " + approbationNumber);
	System.out.println("orderNumber: " + orderNumber);
	RespuestaVO respuestaVO = new RespuestaVO();
	respuestaVO.setOrderNumber(orderNumber);
	respuestaVO.setApprobationNumber(approbationNumber);
	SessionManager.getInstance().setAutorizationNumber(orderNumber, respuestaVO);
	OrderVO orderVO = new OrderVO();
	orderVO.setOrderID(orderNumber);
	orderVO.setAutoID(approbationNumber);
	ManageData manageData = new ManageData();
	int answer = manageData.updateOrder(orderVO);
	System.out.println("Respuesta: " + answer);
	if(answer != 1) {
		response.sendError(999,"Wasn't possible save the information");
	}
%>
