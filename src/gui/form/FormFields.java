package gui.form;

import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JLabel;

public abstract class FormFields {

	public JLabel labelField;
	private final static AtomicInteger count= new AtomicInteger(0);
	public final int fieldID;
	protected final int defaultSize = 20;
	protected boolean readonly = false;
	
	
	public FormFields(String labelField) {
		this.labelField = new JLabel(labelField);
		this.fieldID = count.incrementAndGet();
	}
}
