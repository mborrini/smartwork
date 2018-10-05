package manager;

import gui.application.*;

public class UserPasswordManager {
	
	//private String DBName = "";
	private String user = "";
	private String password = "";
	
	private static final UserPasswordManager instance = new UserPasswordManager();
	
	private UserPasswordManager() {}
	
	public static UserPasswordManager getInstance() {
		return instance;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void update(CreateDataBaseGui obj) {
		setUser(obj.getUsername());
		setPassword(obj.getPassword());
	}
}
