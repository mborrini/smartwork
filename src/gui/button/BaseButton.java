package gui.button;


import javax.swing.JButton;
import javax.swing.ImageIcon;

import tools.ImagesModifiers;

public abstract class BaseButton extends JButton{
	
	private static final long serialVersionUID = 35L;
	private static final String _name = "base.button";
	private static final int defaultImageSize = 30;
	private ImageIcon image = null;
	private String buttonName;
	private String action;
	
	public BaseButton(String buttonName, String action ,ImageIcon image) {
		super(buttonName, ImagesModifiers.getScaledImageIcon(image, defaultImageSize, defaultImageSize));
		this.buttonName = buttonName;
		this.image = image;
		this.action = action;
		setActionCommand(action);
	}
	
	public BaseButton(String buttonName, String action) {
		super(buttonName);
		this.buttonName = buttonName;
		this.action = action;
		setActionCommand(action);
	}
	
	public static String _getName() {
		return _name;
	}
	
}
