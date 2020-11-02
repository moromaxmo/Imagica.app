package project;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sharpening extends Filter{

	public Sharpening() {}
	
	public void apply(MyImage image) throws IOException {
		
		BufferedImage shImage = ImageIO.read(new File(image.path));
		Kernel kernel = new Kernel(3, 3, new float[] { -1, -1, -1, -1, 9, -1, -1,-1, -1 });
		BufferedImageOp op = new ConvolveOp(kernel);
		shImage = op.filter(shImage, null);
		
		iTransporter s = new iTransporter();
	    s.save(image, shImage);
	}
	
	
}
