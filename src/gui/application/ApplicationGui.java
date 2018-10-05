package gui.application;

import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.BorderFactory;

import manager.*;
import gui.button.*;
import gui.form.*;
import gui.submit.errrormanager.*;

public abstract class ApplicationGui extends JPanel{
	
	public static final long serialVersionUID = 30L;
	
	protected GUIManager guiManager = GUIManager.getInstance();
	protected DataBaseManager dataManager = new DataBaseManager();
	
	// Grid Layout
	protected JPanel formFields;
	protected JPanel formButtons;
	protected JPanel formMessage;
	protected ArrayList<String>messagesMessages = new ArrayList<String>();
	protected ArrayList<ErrorinForms>messagesErrors = new ArrayList<ErrorinForms>();
	private GridBagLayout gridBag;
	private GridBagConstraints gridConstr;
	
	
	
	public ApplicationGui(boolean border) {
		super();
		formFields = new JPanel();
		formButtons = new JPanel();
		gridBag = new GridBagLayout();
		gridConstr = new GridBagConstraints();
		formFields.setLayout(gridBag);
		if (border) {
			setBorder();
		}
	}
	
	private void setBorder() {
		formFields.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder("Informazioni DataBase"),
					BorderFactory.createEmptyBorder(5, 5, 5, 5)
				));
		formButtons.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Operazioni"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)
			));
		formFields.setAlignmentX(CENTER_ALIGNMENT);
		formButtons.setAlignmentX(CENTER_ALIGNMENT);
	}
	
	protected void setErrorMessages() {
		for (ErrorinForms e: messagesErrors) {
			JLabel errorLabel = new JLabel("Errore: ");
			formMessage.add(errorLabel);
			JLabel errorText = new JLabel(e.getErrorMessage());
			formMessage.add(errorText);
		}
	}
	
	protected void setMessageMessages() {
		for (String s: messagesMessages) {
			JLabel messageLabel = new JLabel("Messaggio: ");
			formMessage.add(messageLabel);
			JLabel messageText = new JLabel(s + ": OK");
			formMessage.add(messageText);
		}
	}
	
	protected void setLayoutMessage() {
		formMessage = new JPanel();
		formMessage.setLayout(new GridLayout(0,2));
		formMessage.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Messaggi"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)
			));
	}
	
	protected void setLayout(CharFields field) {
		
		//HashMap.Entry<JLabel,JTextField>entry = field.formViewGet().entrySet().iterator().next();
		// Set Label and Field 
		setLabel();
		formFields.add(field.getLabel(), gridConstr);
		setField();
		formFields.add(field.getInput(), gridConstr);
	}
	
	protected void setLayout(PasswordFields field) {
		//HashMap.Entry<JLabel,JPasswordField>entry = field.formViewGet().entrySet().iterator().next();
		// Set Label and Field 
		setLabel();
		formFields.add(field.getLabel(), gridConstr);
		setField();
		formFields.add(field.getInput(), gridConstr);
	}
	
	protected void setLayout(FileFields field) {
		//HashMap.Entry<JLabel,JTextField>entry = field.formViewGet().entrySet().iterator().next();
		// Set Label and Field 
		setLabel();
		formFields.add(field.getLabel(), gridConstr);
		setField();
		formFields.add(field.getInput(), gridConstr);
	}
	
	protected void setLayout(BooleanFields field) {
		//HashMap.Entry<JLabel,JCheckBox>entry = field.formViewGet().entrySet().iterator().next();
		// Set Label and Field 
		setLabel();
		formFields.add(field.getLabel(), gridConstr);
		setField();
		formFields.add(field.getInput(), gridConstr);
	}
	
	private void setLabel() {
		gridConstr.gridwidth = GridBagConstraints.RELATIVE;
		gridConstr.fill = GridBagConstraints.NONE;
		gridConstr.weightx = 0.0;
	}
	
	private void setField() {
		gridConstr.gridwidth = GridBagConstraints.REMAINDER;
		gridConstr.fill = GridBagConstraints.HORIZONTAL;
		gridConstr.weightx = 1.0;
	}
	
	protected void setButton(OpenFileButton openFile) {
		formButtons.add(openFile, BorderLayout.AFTER_LINE_ENDS);
	}
	
	protected void setButton(GuiButton openFile) {
		formButtons.add(openFile, BorderLayout.AFTER_LINE_ENDS);
	}
}
