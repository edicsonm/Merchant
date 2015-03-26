package object;

import java.io.Serializable;

public class MerchantVO implements Serializable {

	private static final long serialVersionUID = -4018736516088290513L;
	
	private String idMerchant;
	private String nameMerchant;

	public String getIdMerchant() {
		return idMerchant;
	}

	public void setIdMerchant(String idMerchant) {
		this.idMerchant = idMerchant;
	}

	public String getNameMerchant() {
		return nameMerchant;
	}

	public void setNameMerchant(String nameMerchant) {
		this.nameMerchant = nameMerchant;
	}
	
}
