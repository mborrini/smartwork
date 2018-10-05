package database;

import manager.UserPasswordManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseCursor {

	private static DataBaseCursor instance = null;
	private Connection cr = null;
	private String user;
	private String password;
	
	private DataBaseCursor() {
		getLogin();
		getConnection();
	}
	
	public void getConnection() {
		String url = "jdbc:postgresql://localhost/";
		try {
			this.cr = DriverManager.getConnection(url,user,password);
		}catch (SQLException ex) {
			this.cr = null;
			System.out.println("Impossibile Collegarsi a Database");
		}
	}
	
	private void getLogin() {
		UserPasswordManager login = UserPasswordManager.getInstance();
		user = login.getUser();
		password = login.getPassword();
	}
	
	public static Connection getCr() {
		if (instance == null || instance.cr == null) {
			instance = new DataBaseCursor();
			return instance.cr;
		}
		return instance.cr;
	}
}
