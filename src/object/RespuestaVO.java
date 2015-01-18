package object;

public class RespuestaVO {
	
	private String orderNumber;
	private String status;
	private String message;
	private String data;
	private String approbationNumber;
	
	public String getApprobationNumber() {
		return approbationNumber;
	}
	public void setApprobationNumber(String approbationNumber) {
		this.approbationNumber = approbationNumber;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
