package metodos;

import java.util.HashMap;

import object.RespuestaVO;

public class SessionManager {
	
	private static SessionManager instance;
	public HashMap<String, RespuestaVO> hashMapSessions = new HashMap<String, RespuestaVO>();
	public static SessionManager getInstance() {
		if (instance == null) {
			instance = new SessionManager();
		}
		return instance;
	}
	
	private SessionManager() {}
	
	public RespuestaVO getAutorizationNumber(String orderNumber){
		return hashMapSessions.get(orderNumber);
	}
	
	public void setOrderNumber(String orderNumber){
		hashMapSessions.put(orderNumber, null);
	}
	
	public void setAutorizationNumber(String orderNumber, RespuestaVO respuestaVO){
		hashMapSessions.put(orderNumber, respuestaVO);
	}
}
