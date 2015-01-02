<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="metodos.SessionManager"%>
<%@ page import="DB.ManageData"%>
<%@ page import="object.*"%>
<%
	/* ServletContext context = request.getSession().getServletContext(); */
	String approbationNumber = (String)request.getParameter("approbationNumber");
	String orderNumber = (String)request.getParameter("orderNumber");
	System.out.println("approbationNumber: " + approbationNumber);
	System.out.println("orderNumber: " + orderNumber);
	/*System.out.println("# Elementos3: " + SessionManager.getInstance().hashMapSessions.size()); */
	SessionManager.getInstance().setAutorizationNumber(orderNumber, approbationNumber);
	OrderVO orderVO = new OrderVO();
	orderVO.setOrderID(orderNumber);
	orderVO.setAutoID(approbationNumber);
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
