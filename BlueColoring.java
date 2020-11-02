package project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BlueColoring extends Coloring{

	public BlueColoring() {}
	
	public void apply(MyImage image) throws IOException {
		BufferedImage bImage = null; 
        File f = null; 
        f = new File(image.getPath()); 
        bImage = ImageIO.read(f);
        int width = bImage.getWidth(); 
        int height = bImage.getHeight(); 
        
        for(int y = 0; y < height; y++) 
        { 
            for(int x = 0; x < width; x++) 
            { 
            	int p = bImage.getRGB(x,y);         	  
                int a = (p>>24)&0xff; 
                int b = p&0xff; 
                p = (a<<24) | (0<<16) | (0<<8) | b;  
                bImage.setRGB(x, y, p);
            } 
        } 
      
         iTransporter s = new iTransporter();
         s.save(image, bImage);
           
	}
}
