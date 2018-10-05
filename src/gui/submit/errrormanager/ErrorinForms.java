package gui.submit.errrormanager;

public class ErrorinForms {
	
	private boolean hasError;
	private String errorMessage;
	
	public ErrorinForms(String Error) {
		if (Error.isEmpty()) {
			this.hasError = false;
			this.errorMessage = "No Error";
		}else {
			this.hasError = true;
			this.errorMessage = Error;
		}
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public boolean hasError() {
		return hasError;
	}
}
