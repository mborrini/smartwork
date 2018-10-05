package manager;

import gui.core.MainGui;
import gui.core.MenuBarGui;
import gui.application.CreateDataBaseGui;
import gui.core.RootPanel;

import java.awt.event.WindowEvent;

import javax.swing.SwingUtilities;

public class GUIManager{
	
	private MainGui mainGui;
	private MenuBarGui menuBar;
	private RootPanel rootPanel;
	private CreateDataBaseGui createDBGui;
	
	private static final GUIManager instance = new GUIManager(MainGui.getInstance());
	
	public static GUIManager getInstance() {
		return instance;
	}
	
	private GUIManager(MainGui mainGui) {
		this.mainGui = mainGui;
		addRootPanel();
		addWestBar();
	}
	
	private void addRootPanel() {
		this.rootPanel = RootPanel.getInstance();
		mainGui.add(rootPanel);
	}
	
	private void addWestBar() {
		this.menuBar = MenuBarGui.getInstance();
		rootPanel.setwestPanel(menuBar);
	}

	public void ShowFrame() {
		mainGui.Show();
	}
	
	public void createDBLayout() {
		this.createDBGui = CreateDataBaseGui.getInstance();
		rootPanel.seteastPanel(createDBGui);
		mainGui.Show();
	}
	
	public void closeAll() {
		mainGui.dispatchEvent(new WindowEvent(mainGui, WindowEvent.WINDOW_CLOSING));
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUIManager manager = GUIManager.getInstance();
				manager.mainGui.Show();
			}
		});
	}
}
