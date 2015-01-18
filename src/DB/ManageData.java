package DB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
			conn =
		       DriverManager.getConnection("jdbc:mysql://merchant.billingbuddy.com/Merchant?" +
		                                   "user=root&password=Bulldog2014");
		
			/*conn =
				       DriverManager.getConnection("jdbc:mysql://localhost/Merchant?" +
				                                   "user=root&password=Bulldog2014");*/
		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
	
}
