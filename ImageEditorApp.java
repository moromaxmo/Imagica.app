package project;

import java.util.Scanner;
import java.io.File; 
import java.io.IOException;

public class ImageEditorApp {
	
	public static void main(String[] args) throws IOException {
		ImageEditorApp app = new ImageEditorApp();
		app.run();
	}
	
	MyImage obj = new MyImage();
	
	public ImageEditorApp(){}
	
	 void run() throws IOException{
		System.out.println("Welcome to the Image Editing App!");
		System.out.println("Please insert an image path:");
		
		Scanner input = new Scanner(System.in);
		obj.setPath(input.nextLine());
		
		File inputfile = new File(obj.getPath());
		obj.setImage(inputfile);
		
		obj.setHeight(obj.getImage().getHeight());
		obj.setWidth(obj.getImage().getWidth());
		obj.setImage(obj.getImage());
		
		ImageManager iM = new ImageManager(obj);
		iM.showMenu();
		input.close();
	 }
}




