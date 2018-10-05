package gui.core;

import gui.core.MenuBar;
import gui.form.FormFields;

import java.io.File;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.IntStream;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;

public class ConfigurationGui extends JPanel {
	
	private String[] fields = {"Nome Utente: ", "Password: ", "Nome Database: ", "File .dump di Backup: "};
	private String[] defaults = {"openerp", "postgres", "", ""};
	private JFileChooser fileChooser;
	private HashMap<String, FormFields> columns = new HashMap<String,FormFields>();
	
	private static final ConfigurationGui instance = new ConfigurationGui();
	
	public static ConfigurationGui getInstance() {
		return instance;
	}
	private ConfigurationGui() {
		super();
		fields();
		Layout();
		buttons();
		setOpaque(true);
	}
	
	private void fields() {
//		for (String s:fields) {
//			FormFields fs;
//			switch(s) {
//			case "Password: ":
//				fs = new FormFields(s,1);
//				break;
//			default:
//				fs = new FormFields(s);
//				break;
//			}
//			columns.put(s,fs);
//		}
	}
	
	private void Layout() {
//		ArrayList<JLabel> labels = getLabels();
//		ArrayList<JTextField> textFields = getText();
//		
		GridBagLayout gridbag = new GridBagLayout();
		JPanel listItem = new JPanel();
		listItem.setLayout(gridbag);
		
		// Add Labels to text
		GridBagConstraints textlabelconstr = new GridBagConstraints();
		textlabelconstr.anchor = GridBagConstraints.EAST;
		
		ArrayList<FormFields> sortedFields = sortColumns();
//		
		Iterator<FormFields> itSortedFields = sortedFields.iterator();
//		Iterator<JTextField>itFields = textFields.iterator(); 
		while(itSortedFields.hasNext()) {
			
			FormFields fs = itSortedFields.next();
			// Set Labels
			textlabelconstr.gridwidth = GridBagConstraints.RELATIVE;
			textlabelconstr.fill = GridBagConstraints.NONE;
			textlabelconstr.weightx = 0.0;
			listItem.add(fs.labelField, textlabelconstr);
			
			// Set Texts Fields
			textlabelconstr.gridwidth = GridBagConstraints.REMAINDER;
			textlabelconstr.fill = GridBagConstraints.HORIZONTAL;
			textlabelconstr.weightx = 1.0;
			
			
			switch (fs.labelField.getText()) {
			case "Password: ":
				listItem.add(fs.passwordField, textlabelconstr);
				break;
			default:
				listItem.add(fs.textField, textlabelconstr);
			}	
		}
		
		
		
//		for (HashMap.Entry<String, FormFields> entry: columns.entrySet()) {
//			
//			String key = entry.getKey();
//			FormFields value = entry.getValue();
//			System.out.println(key);
//			// Set Labels
//			textlabelconstr.gridwidth = GridBagConstraints.RELATIVE;
//			textlabelconstr.fill = GridBagConstraints.NONE;
//			textlabelconstr.weightx = 0.0;
//			listItem.add(value.labelField, textlabelconstr);
//			
//			// Set Texts Fields
//			textlabelconstr.gridwidth = GridBagConstraints.REMAINDER;
//			textlabelconstr.fill = GridBagConstraints.HORIZONTAL;
//			textlabelconstr.weightx = 1.0;
//			switch (key) {
//			case "Password: ":
//				listItem.add(value.passwordField, textlabelconstr);
//				break;
//			default:
//				listItem.add(value.textField, textlabelconstr);
//				break;
//			}
//		}
		
		// Adding File Chooser Field
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		listItem.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Data Base Info"), 
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		
		add(listItem, BorderLayout.PAGE_START);
		
	}
	
//	private ArrayList<JLabel> getLabels(){
//		ArrayList<JLabel>labels = new ArrayList<JLabel>();
//		for (String s:fields) {
//			labels.add(new JLabel(s));
//		}
//		return labels;
//	}
//	
//	private ArrayList<JTextField> getText(){
//		ArrayList<JTextField> textFields = new ArrayList<JTextField>();
//		IntStream.range(0, fields.length).forEach(
//				n->{textFields.add(new JTextField(20));}
//				);
//		return textFields;
//	}
	
	private void buttons() {
		MenuBar menu = new MenuBar("configurazione");
		add(menu);
	}
	
	private ArrayList<FormFields> sortColumns() {
		ArrayList<FormFields> sortedFields = new ArrayList<FormFields>(columns.values());
		Collections.sort(sortedFields, new Comparator<FormFields>() {
			public int compare(FormFields f1, FormFields f2) {
				return f1.fieldID - f2.fieldID;
			}
		});
		return sortedFields;
	}
	
	public void openSelectDumpFile() {
		
		int returnValue = fileChooser.showOpenDialog(ConfigurationGui.this);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			FormFields fs = columns.get("File .dump di Backup: ");
			fs.textField.setText(file.getPath());
			System.out.println("Nome del FIle selezionato: " + file.getPath());
		}
	}
	
}
