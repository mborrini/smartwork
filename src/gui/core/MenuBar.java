package gui.core;

import tools.ImagesModifiers;
import manager.GUIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;


public class MenuBar extends JMenuBar implements ActionListener{

	private JMenu confMenu, submenu;
	private JRadioButtonMenuItem rbMenuItem;
	
	public MenuBar(String option) {
		
		// Creating JMenus
		this.confMenu = new JMenu("Opzioni");
		
		if (option == "configurazione") {
			setConfMenuItems();
		}
		setGeneralLayout();
		
		// Adding SubMenu to MenuBar
		add(confMenu);
		
	}
	
	private void setConfMenuItems() {
		// Get Save Image
		ImageIcon savedisk = new ImageIcon("src/data/img/disksave.png");
		savedisk = ImagesModifiers.getScaledImageIcon(savedisk,20,20);
		
		// Get JMenuItem Save, Exit
		JMenuItem menuItemSave = new JMenuItem("Crea Database",savedisk);
		JMenuItem menuItemExit = new JMenuItem("Esci");
		JMenuItem menuItemDumpFileSelection = new JMenuItem("Scegli il file di dump");
		
		// Set Password Visible CheckBoxes
		JCheckBoxMenuItem pswVisible = new JCheckBoxMenuItem("Mostra Password");
		
		// Set actions Command to JMenuItem
		menuItemExit.setActionCommand("Exit");
		menuItemSave.setActionCommand("createdatabase");
		menuItemDumpFileSelection.setActionCommand("dump_file");
		
		// Add listener to JMenuItem
		menuItemExit.addActionListener(this);
		menuItemDumpFileSelection.addActionListener(this);
		
		// Add JMenuItems to Configuration Menu
		this.confMenu.add(menuItemSave);
		this.confMenu.addSeparator();
		this.confMenu.add(menuItemDumpFileSelection);
		this.confMenu.add(pswVisible);
		this.confMenu.addSeparator();
		this.confMenu.add(menuItemExit);
		
	}
	
	private void setGeneralLayout() {
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Exit":
				MainGui frame = MainGui.getInstance();
				frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
				break;
			case "createdatabase":
				break;
			case "dump_file":
				GUIManager manager = GUIManager.getInstance();
				manager.openSelectDumpFile();
				break;
		}
	}
}
