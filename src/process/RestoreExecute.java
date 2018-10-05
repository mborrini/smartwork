package process;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import gui.application.CreateDataBaseGui;

import gui.submit.errrormanager.ErrorinForms;

public class RestoreExecute extends NewProcessExecute{
	
	private String dbName;
	private String user;
	private File dumpFile;
	
	public RestoreExecute(String dbName, String user, File dumpFile) {
		this.dbName = dbName;
		this.user = user;
		this.dumpFile = dumpFile;
	}
	
	public boolean execute() {
		ArrayList<String> c = new ArrayList<String>();
		c.add("psql");
        c.add("-U");
        c.add("openerp");
        c.add(dbName);
        c.add("<");
        c.add(dumpFile.getPath());//Location to store db Dump backup
		
		this.command = c;
		
		CreateDataBaseGui dbGui = CreateDataBaseGui.getInstance();
		
		try {
			_execute();
		}catch (IOException ioEx) {
			ErrorinForms err = new ErrorinForms("Input Output Error: " + ioEx.getMessage());
			dbGui.setError(err);
			return false;
		}catch (InterruptedException intEx) {
			ErrorinForms err = new ErrorinForms("Interrupt Error: " + intEx.getMessage());
			dbGui.setError(err);
			return false;
		}
		return true;
	}
}

