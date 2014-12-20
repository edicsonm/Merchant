<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="metodos.SessionManager"%>
<%
	String approbationNumber = SessionManager.getInstance().getAutorizationNumber((String)session.getAttribute("orderID"));
	/* System.out.println("Charging..." + session.getId());
	String approbationNumber = (String)session.getAttribute("approbationNumber"); */
	if(approbationNumber != null) {
	 	out.print("Approbation Number Was Received: " + approbationNumber);
	 	%>
	 		<script type="text/javascript">
	 			$("#formID").attr("target","_self");	
	 			$("#formID").attr("action","congratulations.jsp");
    			$("#formID").submit();
    		</script>
    	<%
	} else { 
	 	System.out.println("Waiting for payment ...");
	 	out.println("Waiting for payment ...");
	}
%>