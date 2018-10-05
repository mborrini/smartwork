package gui.submit.errrormanager;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class CheckErrorBase implements CheckErrorInterface{

	private ArrayList<ErrorinForms>errors = new ArrayList<ErrorinForms>();
	private boolean hasError;
	
	public ArrayList<ErrorinForms> getErrors(){
		return errors;
	}
	
	public boolean hasError() {
		boolean res = false;
		for (ErrorinForms e: errors) {
			if (e.hasError()) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	protected void errorBuilder(HashMap<String, String>inputs) {
		for (HashMap.Entry<String,String>entry: inputs.entrySet()) {
			if (entry.getValue().isEmpty()) {
				String message = "compilare " + entry.getKey();
				ErrorinForms error = new ErrorinForms(message);
				errors.add(error);
			}
		}
	}
	
	protected void errorBuilderFile(HashMap<String, File>inputs) {
		for (HashMap.Entry<String, File>entry: inputs.entrySet()) {
			String message = new String("");
			if (entry.getValue() == null) {
				message = "compilare il File " + entry.getKey();
			}else if(!(entry.getValue().exists() && entry.getValue().isFile())) {
				message = "il File " + entry.getKey() + " inserito, non esiste; o non non e' supportato per questa operazione";
			}
			ErrorinForms error = new ErrorinForms(message);
			errors.add(error);
		}
	}
	
}
