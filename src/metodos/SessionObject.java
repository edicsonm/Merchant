/**
 * 
 */
package metodos;

/**
 * @author edicson
 *
 */
public class SessionObject {

	private String orderNumber;
	private String autorizationNumber;

	/**
	 * 
	 */
	public SessionObject() {
	}
	
	public SessionObject(String orderNumber) {
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getAutorizationNumber() {
		return autorizationNumber;
	}

	public void setAutorizationNumber(String autorizationNumber) {
		this.autorizationNumber = autorizationNumber;
	}

}
