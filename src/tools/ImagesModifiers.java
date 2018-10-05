package tools;

import java.awt.Image;
import javax.swing.ImageIcon;


public abstract class ImagesModifiers {
	
	public static ImageIcon getScaledImageIcon(ImageIcon image, int weight, int height) {
		Image bufferImage = image.getImage();
		Image bufferImageResize = bufferImage.getScaledInstance(weight, height, Image.SCALE_SMOOTH);
		ImageIcon newimg = new ImageIcon(bufferImageResize);
		return newimg;
	}
}
