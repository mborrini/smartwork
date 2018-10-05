package process;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;

import gui.application.CreateDataBaseGui;

public abstract class NewProcessExecute {

	protected ArrayList<String>command = new ArrayList<String>();
	protected int errCode;
	protected String output;
	
	protected void _execute() throws IOException, InterruptedException{
		if (this.command.isEmpty()) {
			return;
		}
		ProcessBuilder pb = new ProcessBuilder();
		pb.command(command);
		Process process = pb.start();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//		String line;
//		while ((line = reader.readLine()) != null)
//		    System.out.println("tasklist: " + line);
		System.out.println("Iniziato");
		errCode = process.waitFor();
		System.out.println("Finito");
		output = output(process.getInputStream());
	}
	
	private String output(InputStream inputStream) throws IOException{
		StringBuilder sb = new StringBuilder();
		CreateDataBaseGui dbGui = CreateDataBaseGui.getInstance();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while((line = br.readLine()) != null) {
				dbGui.setMessage(line);
				sb.append(line + System.getProperty("line.separator")); 
			}
			
		}finally {
			br.close();
		}
		return sb.toString();
	}
}
