package gui.button;


import javax.swing.ImageIcon;
import javax.swing.AbstractButton;
import gui.button.BaseButton;

public class MenuButton extends BaseButton{

	public MenuButton(String buttonName, String action ,ImageIcon image) {
		super(buttonName,action,image);
		layoutButtonBottom();
	}
	
	public MenuButton(String buttonName, String action) {
		super(buttonName,action);
		layoutButton();
	}
	
	private void layoutButton() {
		setVerticalTextPosition(AbstractButton.CENTER);
		setHorizontalTextPosition(AbstractButton.CENTER);
	}
	
	private void layoutButtonBottom() {
		setVerticalTextPosition(AbstractButton.BOTTOM);
		setHorizontalTextPosition(AbstractButton.CENTER);
	}
	
}
