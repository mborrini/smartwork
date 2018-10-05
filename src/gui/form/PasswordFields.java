package gui.form;

import gui.form.InterfaceFields;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

import gui.form.FormFields;

public class PasswordFields extends FormFields implements InterfaceFields<JPasswordField, String>{
	
	private String _name = "password.fields";
	private JPasswordField jText;
	
	public PasswordFields(String name, int size) {
		super(name);
		this.jText = new JPasswordField(size);
	}
	
	public PasswordFields(String name) {
		super(name);
		this.jText = new JPasswordField(defaultSize);
	}
	
	public void setDefault(String defaultValue) {
		this.jText.setText(defaultValue);
	}
	
	public void setReadonly() {
		readonly = true;
		jText.setEditable(false);
	}
	
	public String _getName() {
		return _name;
	}
	
	public JLabel getLabel() {
		return labelField;
	}
	
	public JPasswordField getInput() {
		return jText;
	}
	public String _getRes() {
		return this.jText.getText();
	}
}
