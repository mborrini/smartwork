package gui.form;

import gui.form.FormFields;
import gui.form.InterfaceFields;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FileFields extends FormFields implements InterfaceFields<JTextField, String>{
	
	private String _name = "file.fields";
	private JFileChooser jFile;
	private JTextField jText;
	private boolean file;
	private boolean directory;	
	
	public FileFields(String name, int size, boolean file, boolean directory) {
		super(name);
		this.jText = new JTextField(size);
		this.file = file;
		this.directory = directory;
		this.jFile = new JFileChooser();
		setFileMode();
	}
	
	public FileFields(String name, boolean file, boolean directory) {
		super(name);
		this.jText = new JTextField(defaultSize);
		this.file = file;
		this.directory = directory;
		this.jFile = new JFileChooser();
		setFileMode();
	}
	
	private void setFileMode() {
		if (directory && file) {
			jFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		}else if (directory && !file) {
			jFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}else {
			jFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
		}
	}
	
	public void setDefault(String defaultValue) {
		this.jText.setText(defaultValue);
	}
	
	public void setTextValue(String path) {
		this.jText.setText(path);
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
	
	public JFileChooser getFile() {
		return jFile;
	}
	
	public void setReadonly() {
		readonly = true;
		jText.setEditable(false);
	}
}
