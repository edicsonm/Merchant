package DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import object.CertificateVO;
import object.MerchantVO;
import object.OrderVO;

public class ManageData {
	
	Connection conn = null;
	public ManageData(){
		try {
//			String myDriver = "org.gjt.mm.mysql.Driver";
//			String myUrl = "jdbc:mysql://localhost/test";
//			Class.forName(myDriver);
//			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			Class.forName("com.mysql.jdbc.Driver");
			/*conn =
		       DriverManager.getConnection("jdbc:mysql://merchant.billingbuddy.com/Merchant?" +
		                                   "user=root&password=Bulldog2014");*/
		
			/*conn =
				       DriverManager.getConnection("jdbc:mysql://localhost/Merchant?" +
				                                   "user=root&password=Bulldog2014");*/
			
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/Merchant");
			conn = ds.getConnection();
			System.out.println("Aplicanfo caomomasd");
		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public int insertOrder(OrderVO orderVO){
		CallableStatement cstmt = null;
		int status = 0;
		try {
			cstmt = conn.prepareCall("{call Merchant.PROC_INSERT_ORDER( ?, ?)}");
			cstmt.setString(1, orderVO.getOrderAmount());
			cstmt.setInt(2, 0);
			status = cstmt.executeUpdate();
			orderVO.setOrderID(cstmt.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}
	
	public int updateOrder(OrderVO orderVO) {
		CallableStatement cstmt = null;
		int status = 0;
		try {
			cstmt = conn.prepareCall("{call Merchant.PROC_UPDATE_ORDER( ?, ?)}");
			cstmt.setString(1, orderVO.getOrderID());
			cstmt.setString(2, orderVO.getAutoID() != null ? orderVO.getAutoID(): "0");
			status = cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}
	
	public ArrayList<MerchantVO> listMerchant() {
		ResultSet resultSet = null; 
		PreparedStatement pstmt = null;
		ArrayList<MerchantVO> list = null;
		try {
			pstmt = conn.prepareCall("{call Merchant.PROC_LIST_MERCHANTS()}");
			resultSet = (ResultSet)pstmt.executeQuery();
			if (resultSet != null) {
				list = new ArrayList<MerchantVO>();
				while (resultSet.next()) {
					MerchantVO merchantVO = new MerchantVO();
					merchantVO.setIdMerchant(resultSet.getString("Merc_ID"));
					merchantVO.setNameMerchant(resultSet.getString("Merc_Name"));
					list.add(merchantVO);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<MerchantVO> listMerchantWithCertificates() {
		ResultSet resultSet = null; 
		PreparedStatement pstmt = null;
		ArrayList<MerchantVO> list = null;
		try {
			pstmt = conn.prepareCall("{call Merchant.PROC_LIST_MERCHANTS_WITH_CERTIFICATE()}");
			resultSet = (ResultSet)pstmt.executeQuery();
			if (resultSet != null) {
				list = new ArrayList<MerchantVO>();
				while (resultSet.next()) {
					MerchantVO merchantVO = new MerchantVO();
					merchantVO.setIdMerchant(resultSet.getString("Merc_ID"));
					merchantVO.setNameMerchant(resultSet.getString("Merc_Name"));
					list.add(merchantVO);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int insertUpdateCertificate(CertificateVO certificateVO){
		CallableStatement cstmt = null;
		int status = 0;
		try {
			cstmt = conn.prepareCall("{call Merchant.PRC_INSERT_UPDATE_CERTIFICATE( ?, ?, ?, ?)}");
			cstmt.setString(1, certificateVO.getPasswordKeyStore());
			cstmt.setString(2, certificateVO.getPasswordKey());
			cstmt.setString(3, certificateVO.getKeyName());
			cstmt.setString(4, certificateVO.getIdMerchant());
			status = cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}
	
	public CertificateVO listCertificateDetails(CertificateVO certificateVO) {
		ResultSet resultSet = null; 
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareCall("{call Merchant.LIST_CERTIFICATE_DETAIL( ? )}");
			pstmt.setString(1, certificateVO.getIdMerchant());
			resultSet = (ResultSet)pstmt.executeQuery();
			certificateVO = null;
			if (resultSet != null) {
				while (resultSet.next()) {
					certificateVO = new CertificateVO();
					certificateVO.setIdMerchant(resultSet.getString("Merc_ID"));
					certificateVO.setPasswordKeyStore(resultSet.getString("PasswordKeyStore"));
					certificateVO.setPasswordKey(resultSet.getString("PasswordKey"));
					certificateVO.setKeyName(resultSet.getString("KeyName"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return certificateVO;
	}
	
	
}
