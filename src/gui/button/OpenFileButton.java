package gui.button;

import javax.swing.AbstractButton;

import gui.button.BaseButton;

public class OpenFileButton extends BaseButton{
	
	public OpenFileButton() {
		super("Scegli...", "openFile");
		layoutButton();
	}
	
	private void layoutButton() {
		setVerticalTextPosition(AbstractButton.CENTER);
		setHorizontalTextPosition(AbstractButton.CENTER);
	}
}
