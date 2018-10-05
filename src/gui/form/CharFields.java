package gui.form;

import gui.form.FormFields;
import gui.form.InterfaceFields;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class CharFields extends FormFields implements InterfaceFields<JTextField, String>{
	
	private String _name = "char.fields";
	private JTextField jText;
	
	public CharFields(String name, int size) {
		super(name);
		this.jText = new JTextField(size);
	}
	
	public CharFields(String name) {
		super(name);
		this.jText = new JTextField(defaultSize);
	}
	
	public void setDefault(String defaultValue) {
		this.jText.setText(defaultValue);
	}
	
	public String _getName() {
		return _name;
	}
	
	public JLabel getLabel() {
		return labelField;
	}
	
	public JTextField getInput() {
		return jText;
	}
	
	public void setReadonly() {
		readonly = true;
		jText.setEditable(false);
	}
	
	public String _getRes() {
		return this.jText.getText();
	}
}
