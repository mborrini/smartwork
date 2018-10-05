package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.Class;
import java.lang.ClassNotFoundException;

public class DataBaseCore {
	
	private String DBName;
	private String user;
	private String password;
	private Connection cr;
	
	// Use Singleton 
	private static DataBaseCore instance = null;
	
	public static DataBaseCore getInstance(String DBName, String user, String password) {
		if (instance == null) {
			instance = new DataBaseCore(DBName, user, password);
		}
		return instance;
	}
	
	private DataBaseCore(String DBName, String user, String password) {
		this.DBName = DBName;
		this.user = user;
		this.password = password;
		
	}
	
	public void GetConnection() {
		String url = "jdbc:postgresql://localhost/" + this.DBName;
		try {
			this.cr = DriverManager.getConnection(url,user,password);
		}catch (SQLException ex) {
			this.cr = null;
			System.out.println("Impossibile Collegarsi a Database");
		}
	}
	
	public boolean CreateDataBase() throws SQLException {
		boolean res = false;
		
		this.cr.close();
		return res;
	}
	
//	private static final DataBaseCore instance = new DataBaseCore();
//	
//	public static DataBaseCore getInstance() {
//		return instance;
//	}
	
	
	
}
