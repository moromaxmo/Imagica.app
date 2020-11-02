package project;

import java.io.IOException;
import java.util.Scanner;

public class ImageManager {
	int order;
	MyImage image = new MyImage();
	
	public ImageManager(MyImage i){
		image.assign(i);
	}
	
	public void showMenu() throws IOException {
		System.out.println("Please choose an option: ");
		System.out.println("1-Apply a filter");
		System.out.println("2-Crop the image");
		System.out.println("3-Resize the image");
		System.out.println("4-Color the image");
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		
		while(flag) {
			
		order = input.nextInt();
		
			switch (order) {
			case 1:
				flag = false;
				Filter f = new Filter();
				f.choose(image);
				break;
			case 2:
				flag = false;
				Cropping c = new Cropping();
				c.crop(image);
				break;
			case 3:
				flag = false;
				Resizing r = new Resizing();
				r.resize(image);
				break;
			case 4:
				flag = false;
				Coloring clr = new Coloring();
				clr.choose(image);
				break;
				default:
					System.out.println("Please Enter a valid number");
			}
		}		
		input.close();
	}
	
}

