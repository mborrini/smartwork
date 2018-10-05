package gui.core;


import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JFrame;

public class MainGui extends JFrame{
	
	// Set singleton
	private static final MainGui instance = new MainGui();
	
	private MainGui() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Layout();
	}
	
	public static MainGui getInstance() {
		return instance;
	}
	
	private void Layout() {
		setResizable(false);
	}
	
	public void Show() {
		pack();
		setVisible(true);
	}
	
	
}
