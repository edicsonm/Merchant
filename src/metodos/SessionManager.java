package metodos;

import java.util.HashMap;

public class SessionManager {
	
	private static SessionManager instance;
	public HashMap<String, String> hashMapSessions = new HashMap<String, String>();
	public static SessionManager getInstance() {
		if (instance == null) {
			instance = new SessionManager();
		}
		return instance;
	}
	
	private SessionManager() {}
	
	public String getAutorizationNumber(String orderNumber){
		return hashMapSessions.get(orderNumber);
	}
	
	public void setOrderNumber(String orderNumber){
		hashMapSessions.put(orderNumber, null);
	}
	
	public void setAutorizationNumber(String orderNumber, String autorizationNumber){
		hashMapSessions.put(orderNumber, autorizationNumber);
	}
}
