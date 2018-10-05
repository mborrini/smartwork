package gui.form;

import gui.form.FormFields;
import gui.form.InterfaceFields;

import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class BooleanFields extends FormFields implements InterfaceFields<JCheckBox, Boolean>{
	
	private static final String _name = "boolean.fields";
	private JCheckBox jCheck;
	
	public BooleanFields(String name) {
		super(name);
		jCheck = new JCheckBox();
	}

	public String _getName() {
		return _name;
	}
	
	public boolean getCheck() {
		return (jCheck.isSelected()) ? true : false;
	}
	
	public JLabel getLabel() {
		return labelField;
	}
	
	public JCheckBox getInput() {
		return jCheck;
	}
	
	public void setReadonly() {
		jCheck.setFocusable(false);
	}
	
	public void setDefault(Boolean res) {
		jCheck.setSelected(res.booleanValue());
	}
	
	public boolean _getRes() {
		boolean res = false;
		if (jCheck.isSelected()) {
			res = true;
		}
		return res;
	}
}
