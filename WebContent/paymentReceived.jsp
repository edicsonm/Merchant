<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="metodos.SessionManager"%>
<%@ page import="object.RespuestaVO"%>
<%
	RespuestaVO respuestaVO = SessionManager.getInstance().getAutorizationNumber((String)session.getAttribute("orderID"));
	//System.out.println("Buscando orderID #..." + (String)session.getAttribute("orderID") + " --> " +respuestaVO);
	//System.out.println("respuestaVO.getApprobationNumber()..." + respuestaVO.getApprobationNumber());
	/* System.out.println("Charging..." + session.getId());
	String approbationNumber = (String)session.getAttribute("approbationNumber"); */
	if(respuestaVO != null && respuestaVO.getApprobationNumber() != null) {
		session.setAttribute("respuestaVO", respuestaVO);
		out.print("Approbation Number Was Received: " + respuestaVO.getApprobationNumber());
	 	%>
	 		<script type="text/javascript">
	 			$("#formID").attr("target","_self");	
	 			$("#formID").attr("action","congratulations.jsp");
    			$("#formID").submit();
    		</script>
    	<%
	}else if(respuestaVO != null && respuestaVO.getApprobationNumber() == null) {
		session.setAttribute("respuestaVO", respuestaVO);
		/* out.print("Answer was Received, unfortunately was impossible approve your transaction.");
		out.print("OrderNumber: " + respuestaVO.getOrderNumber());
		out.print("status: " + respuestaVO.getStatus());
		out.print("message: " + respuestaVO.getMessage());
		out.print("data: " + respuestaVO.getData()); */
	 	%>
	 		<script type="text/javascript">
	 			$("#formID").attr("target","_self");	
	 			$("#formID").attr("action","errorDetail.jsp");
    			$("#formID").submit();
    		</script>
    	<%
	} else { 
	 	System.out.println("Waiting for payment ...");
	 	out.println("Waiting for payment ...");
	}
%>