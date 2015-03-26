 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ page import="DB.ManageData"%>
 <%@ page import="object.MerchantVO"%>
 <%@ page import="java.util.ArrayList"%>
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Certificate Upload - Java web application</title>
    </head>
    <body>
    <%
	    ManageData manageData = new ManageData();
    	ArrayList<MerchantVO> listMerchant = (ArrayList<MerchantVO>)manageData.listMerchant();
    %>
        <div>
            <h3> Choose a Certificate to Upload in the Server </h3>
            <form action="upload" method="post" enctype="multipart/form-data">
	            <table>
	            	
	            	<tr>
	            		<td>Select your Merchant Name: </td>
	            		<td>
							<select name="merchant" id="merchant">
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
	            		<td>Enter Certificate KeyStore password: </td>
	            		<td><input type="text" id="passwordKeyStore" name=passwordKeyStore /></td>
	            	</tr>
	            	<tr>
	            		<td>Enter Certificate Key password: </td>
	            		<td><input type="text" id="passwordKey" name=passwordKey /></td>
	            	</tr>
	            	<tr>
	            		<td>Enter Key Name</td>
	            		<td><input type="text" id="keyName" name="keyName" /></td>
	            	</tr>
	            	<tr>
	            		<td>Select a File</td>
	            		<td><input type="file" name="file" /></td>
	            	</tr>
	            	<tr>
	            		<td></td>
	            		<td><input type="submit" value="upload" /></td>
	            	</tr>
	            </table>
            </form>          
        </div>
    </body>
</html>