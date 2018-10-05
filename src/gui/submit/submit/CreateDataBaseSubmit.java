package gui.submit.submit;

import gui.application.CreateDataBaseGui;
import gui.submit.errrormanager.CreateDataBaseCheckError;
import manager.DataBaseManager;

import java.io.File;

import java.util.HashMap;

public class CreateDataBaseSubmit extends SubmitForms{
	
	private String dbName;
	private File restoreDump;
	private boolean delServerMail;
	private boolean delMailMail;
	private boolean delMailMessage;
	private DataBaseManager manager;
	
	public CreateDataBaseSubmit() {
		super(CreateDataBaseGui.getInstance());
		CreateDataBaseGui dbGui = CreateDataBaseGui.getInstance();
		
		// Create Fields
		this.dbName = dbGui.getdbName()._getRes();
		this.restoreDump = dbGui.getfileDump().getFile().getSelectedFile();
		this.delServerMail = dbGui.getdelServerMail()._getRes();
		this.delMailMail = dbGui.getdelMailMail()._getRes();
		this.delMailMessage = dbGui.getdelMailMessage()._getRes();
	}
	
	private boolean credateDBFunc() {
		boolean resDB = manager.createNewDB(this.dbName);
		return resDB;
	}
	
	private boolean restoreDumpFile() {
		boolean resRestore = manager.restoreDump(this.dbName, this.restoreDump);
		return resRestore;
	}
	
	public HashMap<String, Boolean> submit() {
		manager = new DataBaseManager();
		HashMap<String, Boolean>submitMap = new HashMap<String, Boolean>();
		boolean db = credateDBFunc();
		submitMap.put("Creazione DataBase", db);
//		if (db) {
//			boolean restore = restoreDumpFile();
//			submitMap.put("Restore del File .dump", restore);
//		}
		
		
		return submitMap;
	}
	
	public static CreateDataBaseCheckError check() {
		CreateDataBaseCheckError checkForm = new CreateDataBaseCheckError();
		checkForm.check();
		return checkForm;
	}
	
	
}
