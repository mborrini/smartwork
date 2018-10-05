package gui.submit.errrormanager;

import java.io.File;
import java.util.HashMap;

import gui.application.CreateDataBaseGui;


public class CreateDataBaseCheckError extends CheckErrorBase{
	
	private CreateDataBaseGui dbGui;
	
	public CreateDataBaseCheckError() {
		dbGui = CreateDataBaseGui.getInstance();
	}
	
	public void check() {
		HashMap<String, String>inputs = new HashMap<String, String>();
		inputs.put("Username", dbGui.getUsername());
		inputs.put("Password", dbGui.getPassword());
		inputs.put("Nome DataBase", dbGui.getdbName()._getRes());
		errorBuilder(inputs);
		
		HashMap<String, File>inputsFile = new HashMap<String, File>();
		File dumpFile = dbGui.getfileDump().getFile().getSelectedFile();
		inputsFile.put(".dump", dumpFile);
		errorBuilderFile(inputsFile);
	}

	
}
