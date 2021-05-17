package project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GreenColoring extends Coloring{

	public GreenColoring() {}
	
	public void apply(MyImage image) throws IOException {
		BufferedImage gImage = null; 
        File f = null; 
        f = new File(image.getPath()); 
        gImage = ImageIO.read(f);
        int width = gImage.getWidth(); 
        int height = gImage.getHeight(); 
        
        for(int y = 0; y < height; y++) 
        { 
            for(int x = 0; x < width; x++) 
            { 
            	int p = gImage.getRGB(x,y);         	  
                int a = (p>>24)&0xff; 
                int g = (p>>8)&0xff; 
                p = (a<<24) | (0<<16) | (g<<8) | 0;  
                gImage.setRGB(x, y, p);
            } 
        } 
      
         iTransporter s = new iTransporter();
         s.save(image, gImage);
           
	}
}
