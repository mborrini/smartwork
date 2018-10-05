package gui.core;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JPanel;

public class RootPanel extends JPanel{

	private static final RootPanel instance = new RootPanel();
	private JPanel westPanel;
	private JPanel eastPanel;
	
	//Implements Singleton
	public static RootPanel getInstance() {
		return instance;
	}
	
	public void setwestPanel(JPanel westPanel) {
		this.westPanel = westPanel;
		add(westPanel, BorderLayout.NORTH);
	}
	
	public void seteastPanel(JPanel eastPanel) {
		this.eastPanel = eastPanel;
		add(eastPanel, BorderLayout.SOUTH);
	}
	
	private RootPanel() {
		super(new BorderLayout());
		setOpaque(true);
		setBackground(Color.gray);
	}
	
}
