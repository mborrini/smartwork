package gui.form;

import javax.swing.JLabel;

public interface InterfaceFields <T, E> {
	
	String _getName();
	JLabel getLabel();
	T getInput();
	void setReadonly();
	void setDefault(E object);
	
}
