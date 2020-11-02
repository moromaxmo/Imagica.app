package project;

import java.io.IOException;
import java.util.Scanner;

public class Coloring {
	
	int cType;
	public Coloring() {}
	
	public void choose(MyImage image) throws IOException {
		System.out.println("Which Color do you want to convert the image to?");
		System.out.println("1-Red.");
		System.out.println("2-Blue.");
		System.out.println("3-Green.");
		System.out.println("4-Black and White.");
		System.out.println("5-Invert Colors.");

		Scanner input = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			
			cType = input.nextInt();
			
			switch (cType) {
			case 1: 
				flag = false;
				RedColoring r = new RedColoring();
				r.apply(image);
				break;
			case 2: 
				flag = false;
				BlueColoring b = new BlueColoring();
				b.apply(image);
				break;
			case 3: 
				flag = false;
				GreenColoring g = new GreenColoring();
				g.apply(image);
				break;
			case 4: 
				flag = false;
				BlackandWhite bw = new BlackandWhite();
				bw.apply(image);
				break;
			case 5:
				flag = false;
				InvertColors in = new InvertColors();
				in.apply(image);
				break;
				default:
					System.out.println("Please enter a valid number");
			}
		}
		input.close();
	}
	
	public void apply(MyImage image) throws IOException {}
	
}
