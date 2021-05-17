package project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class iTransporter {

	Scanner input = new Scanner(System.in);

	public iTransporter() {	}
	
	public void save(MyImage mImage, BufferedImage bImage) throws IOException {
		System.out.println("How do you want to save the image?");
		System.out.println("1-Overwite the original image");
		System.out.println("2-Make a new image");
		int s = input.nextInt();
		File outputfile = null;
		switch (s) {
		case 1:
			outputfile = new File(mImage.getPath()); 
	        ImageIO.write(bImage, "png", outputfile); 
	        System.out.println("Image saved succesfully!");
	        break;
	        default:
			System.out.println("Enter the image name:");
			String name = input.next();
			String nPath = mImage.getPath().substring(0, (mImage.getPath().lastIndexOf('\\'))+1) + name + ".png";
			outputfile = new File(nPath); 
	        ImageIO.write(bImage, "png", outputfile); 
	        System.out.println("Image saved succesfully!");
	        break;	
		}
	}
}



