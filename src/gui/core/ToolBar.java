package gui.core;

import tools.ImagesModifiers;
import manager.GUIManager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;



public class ToolBar extends JPanel implements ActionListener{
	
	//public JToolBar toolBar;
	private ButtonGroup menuRadio;
	private GUIManager manager;
	
	private static final ToolBar instance = new ToolBar();
	
	public static ToolBar getInstance() {
		return instance;
	}
	
	// Use SingleTon for ToolBar
	private ToolBar() {		
		super(new BorderLayout());
		
		// Adding Button for Tools
		addbuttons();
		
		setOpaque(true);
	}
	
	private void addbuttons() {
		
		menuRadio = new ButtonGroup();
		
		// Configuration Button
		ImageIcon confLogo = new ImageIcon("src/data/img/conf.png");
		confLogo = ImagesModifiers.getScaledImageIcon(confLogo, 50, 50);
		
		JRadioButton confButton = new JRadioButton("Configurazione");
		confButton.setActionCommand("Configurazione");
		confButton.addActionListener(this);
		
		// Other Example Button
		JRadioButton exampleButton = new JRadioButton("Example");
		
		menuRadio.add(confButton);
		menuRadio.add(exampleButton);
		
		JPanel radioPanel = new JPanel(new GridLayout(0,1));
		radioPanel.add(confButton);
		radioPanel.add(exampleButton);
		
		radioPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Menu"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)
				));
		
		add(radioPanel, BorderLayout.PAGE_START);
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Configurazione":
			this.manager = GUIManager.getInstance();
			this.manager.configLayout();
		}
	}
}
