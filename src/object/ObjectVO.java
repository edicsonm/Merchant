package object;

import java.io.Serializable;

public class ObjectVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7162204331009571226L;
	private String orderNumber;
	private String currency;
	private String merchantID;
	private String transactionAmount;
	private String sha1Value;
	private String signSha1;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getSha1Value() {
		return sha1Value;
	}

	public void setSha1Value(String sha1Value) {
		this.sha1Value = sha1Value;
	}

	public String getSignSha1() {
		return signSha1;
	}

	public void setSignSha1(String signSha1) {
		this.signSha1 = signSha1;
	}

}
