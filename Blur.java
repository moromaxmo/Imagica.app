package project;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Blur extends Filter{
	public Blur() {}
	
	public void apply(MyImage image) throws IOException {
		float[] matrix = new float[100];
		for (int i = 0; i < 100; i++)
			matrix[i] = 1.0f/100.0f;
		
		BufferedImage blrImage = ImageIO.read(new File(image.path));
		Kernel kernel = new Kernel(10, 10, matrix);
		BufferedImageOp op = new ConvolveOp(kernel);
		blrImage = op.filter(blrImage, null);
		
		iTransporter s = new iTransporter();
	    s.save(image, blrImage);
	}
	
}
