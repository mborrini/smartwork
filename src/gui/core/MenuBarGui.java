package gui.core;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import gui.button.MenuButton;
import manager.GUIManager;

public class MenuBarGui extends JPanel implements ActionListener{

	// Implements SIngleton
		private static final MenuBarGui instance = new MenuBarGui();
		
		public static MenuBarGui getInstance() {
			return instance;
		}
		
		// Buttons
		private MenuButton createDB;
		private MenuButton exitGUI;
		
		private MenuBarGui() {
			setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
			buttonLayout();
			jpanelLayout();
			setOpaque(true);
		}
		
		private void buttonLayout() {
			
			// Create DataBase
			ImageIcon dbImage = new ImageIcon("src/data/img/database.png");
			createDB = new MenuButton("Crea DataBase", "createdb", dbImage);
			createDB.setAlignmentX(CENTER_ALIGNMENT);
			createDB.addActionListener(this);
			add(createDB);
			
			// Exit Function
			ImageIcon exitImage = new ImageIcon("src/data/img/exit.png");
			exitGUI = new MenuButton("Esci", "exitGUI", exitImage);
			exitGUI.addActionListener(this);
			exitGUI.setAlignmentY(CENTER_ALIGNMENT);
			add(exitGUI);
		}
		
		private void jpanelLayout() {
			setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder("Menu"),
					BorderFactory.createEmptyBorder(5, 5, 5, 5)
				));
		}
		
		public void actionPerformed(ActionEvent action) {
			GUIManager manager;
			switch (action.getActionCommand()) {
			case "createdb":
				manager = GUIManager.getInstance();
				manager.createDBLayout();
				break;
			case "exitGUI":
				manager = GUIManager.getInstance();
				manager.closeAll();
				break;
			default:
				System.out.println("Azione pulsante non contemplata");
				break;
			}
		}
	
}
