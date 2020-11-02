package project;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Resizing {

	int height;
	int width;
	
	public Resizing() {	}
	
	public void resize(MyImage obj) throws IOException {
		BufferedImage reImage = ImageIO.read(new File(obj.path));
		
		Scanner input = new Scanner(System.in);
		System.out.println("Starting from the top left corner,");
		System.out.println("Enter the new width: ");
		width = input.nextInt();
		System.out.println("Enter the new height: ");
		height = input.nextInt();
		
		Image tmp = reImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        

		iTransporter s = new iTransporter();
        s.save(obj, resized);
        input.close();
	}
}
