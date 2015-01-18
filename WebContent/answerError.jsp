<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="metodos.SessionManager"%>
<%@ page import="DB.ManageData"%>
<%@ page import="object.*"%>
<%
	/* ServletContext context = request.getSession().getServletContext(); */
	String orderNumber = (String)request.getParameter("orderNumber");
	String status = (String)request.getParameter("status");
	String message = (String)request.getParameter("message");
	String data = (String)request.getParameter("data");
	
	System.out.println("orderNumber: " + orderNumber);
	System.out.println("status: " + status);
	System.out.println("message: " + message);
	System.out.println("data: " + data);
	
	RespuestaVO respuestaVO = new RespuestaVO();
	respuestaVO.setOrderNumber(orderNumber);
	respuestaVO.setStatus(status);
	respuestaVO.setMessage(message);
	respuestaVO.setData(data);
	respuestaVO.setApprobationNumber(null);
	
	/*System.out.println("# Elementos3: " + SessionManager.getInstance().hashMapSessions.size()); */
	SessionManager.getInstance().setAutorizationNumber(orderNumber, respuestaVO);
	
	OrderVO orderVO = new OrderVO();
	orderVO.setOrderID(orderNumber);
	orderVO.setAutoID(null);
	ManageData manageData = new ManageData();
	int answer = manageData.updateOrder(orderVO);
	
	System.out.println("Respuesta: " + answer);
	if(answer != 1) {
		response.sendError(999,"Wasn't possible save the information");
	}
	/* if(approbationNumber != null ){
			session.setAttribute("approbationNumber", approbationNumber);
			System.out.println("answerProcesor.jsp --> Approbation Number Received " + approbationNumber + " on " + session.getId());
	} */
%>
