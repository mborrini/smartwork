package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseTestConnection {
	
	private String user;
	private String password;
	private boolean dbConnected;
	
	public DataBaseTestConnection(String user, String password) {
		this.user = user;
		this.password = password;
		boolean driverRes = DriverExist();
		boolean connectionRes = TestConnection();
		dbConnected = (driverRes && connectionRes) ? true : false;
	}
	
	public boolean TestConnection() {
		boolean res = false;
		String url = "jdbc:postgresql://localhost/";
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			connection.close();
			res = true;
		}catch (SQLException ex) {
			res = false;
		}
		
		return res;
	}
	
	public static boolean DriverExist() {
		try {
			Class.forName("org.postgresql.Driver");
			return true;
		}catch (ClassNotFoundException e) {
			System.out.println("Nessuna classe trovata" + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean getdbConnected() {
		return dbConnected;
	}
	
	public boolean MainDataBaseExist() {
		boolean res = false;
		String url = "jdbc:postgresql://localhost/smartWorkDB";
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			connection.close();
			res = true;
		}catch (SQLException ex) {
			int num = ex.getErrorCode();
			System.out.println(num);
			res = false;
		}
		return res;
	}
}
