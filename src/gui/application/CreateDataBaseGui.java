package gui.application;

import gui.form.*;
import gui.button.*;
import gui.application.ApplicationGui;
import gui.submit.submit.CreateDataBaseSubmit;
import gui.submit.errrormanager.*;

import java.io.File;
import java.util.HashMap;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;
import javax.swing.BoxLayout;

public class CreateDataBaseGui extends ApplicationGui implements ActionListener, DataBaseConnectionInterface{
	
	private static final long serialVersionUID = 40L;
	
	// Implements SingleTon
	private static final CreateDataBaseGui instance = new CreateDataBaseGui();
	public static CreateDataBaseGui getInstance() {
		return instance;
	}
	
	// Fields
	private CharFields nomeDB = new CharFields("Nome Database");
	private CharFields userName = new CharFields("Nome Utente");
	private PasswordFields password = new PasswordFields("Password");
	private FileFields fileDump = new FileFields("File .dump", true, false);
	private BooleanFields delServerMail = new BooleanFields("Elim. Server Mail");
	private BooleanFields delMailMail = new BooleanFields("Elim. Mail in Uscita");
	private BooleanFields delMailMessage = new BooleanFields("Elim. Tutti i Messaggi");
	
	
	// Buttons
	private OpenFileButton openFile = new OpenFileButton();
	private GuiButton createDB = new GuiButton("Crea Database", "createDB");
	
	private CreateDataBaseGui() {
		super(true);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		Layout();
		fieldSpec();
		Activations();
		setOpaque(true);
	}
	
	private void showError() {
		setLayoutMessage();
		setErrorMessages();
		add(formMessage);
		guiManager.ShowFrame();
	}
	
	private void showMessage() {
		setLayoutMessage();
		setMessageMessages();
		add(formMessage);
		guiManager.ShowFrame();
	}
	
	private void showErrorandMessage() {
		setLayoutMessage();
		setMessageMessages();
		setErrorMessages();
		add(formMessage);
		guiManager.ShowFrame();
	}
	
	private void fieldSpec() {
		fileDump.setReadonly();
		delServerMail.setDefault(true);
		delMailMail.setDefault(true);
		delMailMessage.setDefault(true);
	}
	
	private void Layout() {
		setLayout(nomeDB);
		setLayout(userName);
		setLayout(password);
		setLayout(fileDump);
		setLayout(delServerMail);
		setLayout(delMailMail);
		setLayout(delMailMessage);
		setButton(openFile);
		setButton(createDB);
		add(formFields);
		add(formButtons);
	}
	
	private void Activations() {
		openFile.addActionListener(this);
		createDB.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "openFile":
			selectionFile();
			break;
		case "createDB":
			creationDataBase();
			break;
		default:
			System.out.println("Azione non Considerata");
			break;
		}
	}
	
	private void selectionFile() {
		JFileChooser fc = fileDump.getFile();
		int returnVal = fc.showOpenDialog(CreateDataBaseGui.this);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			fileDump.setTextValue(file.getPath());
		}
	}
	
	public CharFields getdbName() {
		return this.nomeDB;
	}
	
	public String getUsername() {
		return this.userName._getRes();
	}
	
	public String getPassword() {
		return this.password._getRes();
	}
	
	public FileFields getfileDump() {
		return this.fileDump;
	}
	
	public BooleanFields getdelServerMail() {
		return this.delServerMail;
	}
	
	public BooleanFields getdelMailMail() {
		return this.delMailMail;
	}
	
	public BooleanFields getdelMailMessage() {
		return this.delMailMessage;
	}
	
	public void setMessage(String message) {
		messagesMessages.add(message);
	}
	
	public void setError(ErrorinForms error) {
		messagesErrors.add(error);
	}
	
	private void creationDataBase() {
		CreateDataBaseCheckError checkedError =  CreateDataBaseSubmit.check();
		if (checkedError.hasError()) {
			// If the form is no correct
			messagesErrors = checkedError.getErrors();
			showError();
			
		}else {
			// Create DataBase
			CreateDataBaseSubmit submitForm = new  CreateDataBaseSubmit();
			HashMap<String, Boolean>submitMap = submitForm.submit();
			
			// Create Messages
			for (HashMap.Entry<String, Boolean>entry: submitMap.entrySet()) {
				if (entry.getValue()) {
					setMessage(entry.getKey());
					//messagesMessages.add(entry.getKey());
				}else {
					setError(new ErrorinForms(entry.getKey()));
					//messagesErrors.add(new ErrorinForms(entry.getKey()));
				}
			}
			
			// Display First Messages and then Errors
			showErrorandMessage();
		}
		
	}
	
	
}
