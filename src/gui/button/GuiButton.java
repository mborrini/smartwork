package gui.button;

import javax.swing.AbstractButton;

import gui.button.BaseButton;

public class GuiButton extends BaseButton{
	
	public GuiButton(String name, String action) {
		super(name,action);
		layoutButton();
	}
	
	private void layoutButton() {
		setVerticalTextPosition(AbstractButton.CENTER);
		setHorizontalTextPosition(AbstractButton.CENTER);
	}
}
