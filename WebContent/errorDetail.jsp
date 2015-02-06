<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="metodos.SessionManager"%>
<%@ page import="object.RespuestaVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error in payment</title>
</head>
<%
	RespuestaVO respuestaVO = (RespuestaVO)session.getAttribute("respuestaVO");
%>
<body>
<% 
	out.print("Answer was Received, unfortunately was impossible approve your transaction."+"<br>");
	out.print("OrderNumber: " + respuestaVO.getOrderNumber()+"<br>");
	out.print("status: " + respuestaVO.getStatus()+"<br>");
	out.print("message: " + respuestaVO.getMessage()+"<br>");
	out.print("data: " + respuestaVO.getData()+"<br>");
%>
<form action="index.jsp">
	<input type="submit" value="Start Again">
</form>
</body>
</html>