<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ page import="metodos.SessionManager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Congratulations</title>
</head>
<body>
 	We have received your payment under number <% out.print(SessionManager.getInstance().getAutorizationNumber((String)session.getAttribute("orderID"))); %>
</body>
</html>