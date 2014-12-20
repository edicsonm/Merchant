package metodos;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.commons.codec.binary.Hex;

public class ProcesarRequest {
	
	String sha1Value = null;
	public static ConfigurationApplication configurationApplication = ConfigurationApplication.getInstance();
	
	public String requestProccesor(){
		return sha1Value;
	}
	
	public String signSha1(String mensajeRecibido){
		String mensajeFirmado = null;
		try {
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			char[] password = configurationApplication.getKey("passwordKeyStore").toCharArray();//Key Store Password
			java.io.FileInputStream fis = new java.io.FileInputStream(configurationApplication.getKey("privacyKeyStore"));
			ks.load(fis, password);
			fis.close();
			char[] keypassword = configurationApplication.getKey("keypassword").toCharArray();//
			Key myKey = ks.getKey(configurationApplication.getKey("keyName"), keypassword);
			PrivateKey myPrivateKey = (PrivateKey) myKey;
			// 4.2 Firmar el mensaje
		    Signature mySign = Signature.getInstance("MD5withRSA");
		    mySign.initSign(myPrivateKey);
		    mySign.update(mensajeRecibido.getBytes());
		    byte[] byteSignedData = mySign.sign();//Mensaje firmado
		    mensajeFirmado = byteToHexa(byteSignedData);//Convert signed message from bytes to hexa and return the result as string.
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		return mensajeFirmado;
	}
	
	public String sha1Calculator(String value) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
			messageDigest.update(value.getBytes());
			return byteToHexa(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String byteToHexa(byte[] bytes){
		return Hex.encodeHexString(bytes);
	}
	
}
