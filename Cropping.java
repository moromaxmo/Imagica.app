package project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Cropping {
	
	BufferedImage cImage = null;
	int height;
	int width;
	public Cropping() {}
	
	public void crop(MyImage obj) throws IOException {
		BufferedImage oImage = ImageIO.read(new File(obj.path));
		
		Scanner input = new Scanner(System.in);
		System.out.println("Starting from the top left corner,");
		System.out.println("Enter the new width(Max = "+obj.image.getWidth()+"): ");
		width = input.nextInt();
		System.out.println("Enter the new height(Max = "+obj.image.getHeight()+"): ");
		height = input.nextInt();
		
		cImage = oImage.getSubimage(0, 0, width, height);
		
		iTransporter s = new iTransporter();
        s.save(obj, cImage);
        input.close();
	}
}
