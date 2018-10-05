package database;

import database.DataBaseCursor;

import java.util.HashMap;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DataBaseExecute {

	private Connection cr;
	private ResultSet rs = null;
	
	public DataBaseExecute() {
		this.cr = DataBaseCursor.getCr();
	}
	
	public boolean execute(String query) {
		boolean res = false;
		try {
			Statement statement = cr.createStatement();
			rs = statement.executeQuery(query);
			res = true;
		}catch (SQLException e){
			switch (e.getErrorCode()) {
			case 0:
				res = true;
				System.out.println("La query e\' stata eseguita con successo. Risultato: " + e.getMessage());
				break;
			default:
				System.out.println("La query non e\' stata eseguita. CODICE ERRORE: " + e.getErrorCode() + " INFO: " + e.getMessage());
				break;
			}			
		}
		return res;
	}
	
}
