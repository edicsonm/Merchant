package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodos.SessionManager;
import object.OrderVO;
import object.RespuestaVO;

import org.apache.catalina.connector.Request;
import org.json.simple.JSONObject;

import DB.ManageData;


public class Rejected extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4099191990249828904L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ejecuta el servlet Rejected ... Rejected");
		final String callback = request.getParameter("jsoncallback");
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
		
		SessionManager.getInstance().setAutorizationNumber(orderNumber, respuestaVO);
		
		OrderVO orderVO = new OrderVO();
		orderVO.setOrderID(orderNumber);
		orderVO.setAutoID(null);
		ManageData manageData = new ManageData();
		int answer = manageData.updateOrder(orderVO);
		
//		System.out.println("Respuesta: " + answer);
//		if(answer != 1) {
//			response.sendError(999,"Wasn't possible save the information");
//		}
		
//		String approbationNumber = (String)request.getParameter("approbationNumber");
//		String orderNumber = (String)request.getParameter("orderNumber");
//		System.out.println("approbationNumber: " + approbationNumber);
//		System.out.println("orderNumber: " + orderNumber);
//		RespuestaVO respuestaVO = new RespuestaVO();
//		respuestaVO.setOrderNumber(orderNumber);
//		respuestaVO.setApprobationNumber(approbationNumber);
//		SessionManager.getInstance().setAutorizationNumber(orderNumber, respuestaVO);
//		OrderVO orderVO = new OrderVO();
//		orderVO.setOrderID(orderNumber);
//		orderVO.setAutoID(approbationNumber);
//		ManageData manageData = new ManageData();
//		int answer = manageData.updateOrder(orderVO);
//		System.out.println("Respuesta: " + answer);
		
		response.setContentType("text/javascript");
        response.setHeader("Cache-Control", "no-store");
        final PrintWriter out = response.getWriter();
        String respuesta;
		if(answer != 1) {
			respuesta = generaJSONRegistrada();
			respuesta = callback + "(" + respuesta +");";
			out.write(respuesta);
	        out.flush();
	        out.close();
		}else{
			respuesta = generaJSONNORegistrada();
			respuesta = callback + "(" + respuesta +");";
			out.write(respuesta);
	        out.flush();
	        out.close();
		}
		System.out.println(respuesta);
		/*
		final String param1 = request.getParameter("parametro1");
		final String callback = request.getParameter("jsoncallback");
        response.setContentType("text/javascript");
        response.setHeader("Cache-Control", "no-store");           
        final PrintWriter out = response.getWriter();
        String respuesta = generaJSON(param1);
        respuesta = callback + "(" + respuesta +");";
        System.out.println(respuesta);
        out.write(respuesta);
        out.flush();
        out.close();*/
    }
     
    private String generaJSON(String parametro) {
        JSONObject json = new JSONObject();
        json.put("nombre", "prueba");
        json.put("tipo", "Cross-domain");
        json.put("parametro", parametro);
        return json.toJSONString();
    }
    
    private String generaJSONRegistrada() {
        JSONObject json = new JSONObject();
        json.put("date", Calendar.getInstance().getTimeInMillis());
        json.put("status", "processed");
        json.put("confirmationNumber",  (int)(new Random().nextDouble() * 10000));
        return json.toJSONString();
    }
    
    private String generaJSONNORegistrada() {
        JSONObject json = new JSONObject();
        json.put("date", Calendar.getInstance().getTimeInMillis());
        json.put("status", "unprocessed");
        json.put("reason", "Data base error");
        return json.toJSONString();
    }

}
