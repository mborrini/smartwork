package gui.submit.submit;

import gui.application.*;
import manager.UserPasswordManager;


public abstract class SubmitForms {
	
	private UserPasswordManager userpassmanager = UserPasswordManager.getInstance();
	
	public SubmitForms(CreateDataBaseGui dbGUI) {
		userpassmanager.setUser(dbGUI.getUsername());
		userpassmanager.setPassword(dbGUI.getPassword());
	}
	
	public SubmitForms() {
		userpassmanager.setUser("");
		userpassmanager.setPassword("");
	}
}
