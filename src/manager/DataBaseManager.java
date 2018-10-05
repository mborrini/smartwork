package manager;

import java.io.File;

import manager.UserPasswordManager;
import database.DataBaseExecute;
import process.*;

import database.DataBaseCursor;
import database.DataBaseExecute;
import database.DataBaseTestConnection;
import java.sql.Connection;

public class DataBaseManager{
	
	private String user;
	private String password;
	private UserPasswordManager login;
	
	private Connection cr;
	private boolean dbConnected;
	
	public DataBaseManager() {
		getLogin();
		DataBaseTestConnection testConnection = new DataBaseTestConnection(user,password);
		this.dbConnected = testConnection.getdbConnected();
	}
	
	private void getLogin() {
		login = UserPasswordManager.getInstance();
		user = login.getUser();
		password = login.getPassword();
	}
	
	public boolean createNewDB(String DBName) {
		boolean res = false;
		if (dbConnected) {
			String query = "CREATE DATABASE " + DBName + " WITH OWNER " + user + " TEMPLATE template0 ENCODING 'UTF8'";
			DataBaseExecute ex = new DataBaseExecute();
			res = ex.execute(query);
		}
		return res;
	}
	
	public boolean restoreDump(String DBName, File dumpFile) {
		RestoreExecute ex = new RestoreExecute(DBName, user, dumpFile);
		ex.execute();
		return true;
	}

}
