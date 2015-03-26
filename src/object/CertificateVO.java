package object;

import java.io.Serializable;

public class CertificateVO  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4806535646801216802L;
	
	private String idMerchant;
	private String passwordKeyStore;
	private String passwordKey;
	private String keyName;
	
	public String getPasswordKeyStore() {
		return passwordKeyStore;
	}
	public void setPasswordKeyStore(String passwordKeyStore) {
		this.passwordKeyStore = passwordKeyStore;
	}
	public String getPasswordKey() {
		return passwordKey;
	}
	public void setPasswordKey(String passwordKey) {
		this.passwordKey = passwordKey;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getIdMerchant() {
		return idMerchant;
	}
	public void setIdMerchant(String idMerchant) {
		this.idMerchant = idMerchant;
	}
}
