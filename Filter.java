package project;

import java.io.IOException;
import java.util.Scanner;

public class Filter {
	int fType;
	
	public Filter() {}
	
	public Filter(MyImage i) {	}
	
	public void choose(MyImage image) throws IOException {
		System.out.println("Which filter do you want to apply?");
		System.out.println("1-Sepia.");
		System.out.println("2-Blur.");
		System.out.println("3-HDR.");
		System.out.println("4-Sharpening.");
		
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			
			fType = input.nextInt();
			
			switch (fType) {
			case 1: 
				flag = false;
				Sepia s = new Sepia();
				s.apply(image);
				break;
			case 2: 
				flag = false;
				Blur b = new Blur();
				b.apply(image);
				break;
			case 3: 
				flag = false;
				HighDynamRange h = new HighDynamRange();
				h.apply(image);
				break;
			case 4: 
				flag = false;
				Sharpening sh = new Sharpening();
				sh.apply(image);
				break;
				default:
					System.out.println("Please enter a valid number");
			}
		}
		
		input.close();
	}
	
	public void apply(MyImage image) throws IOException {}
}
