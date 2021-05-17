package project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RedColoring extends Coloring{

	public RedColoring() {}
	
	public void apply(MyImage image) throws IOException {
		BufferedImage rImage = null; 
        File f = null; 
        f = new File(image.getPath()); 
        rImage = ImageIO.read(f);
        int width = rImage.getWidth(); 
        int height = rImage.getHeight(); 
        
        for(int y = 0; y < height; y++) 
        { 
            for(int x = 0; x < width; x++) 
            { 
            	int p = rImage.getRGB(x,y);    	  
                int a = (p>>24)&0xff; 
                int r = (p>>16)&0xff;  
                p = (a<<24) | (r<<16) | (0<<8) | 0;   
                rImage.setRGB(x, y, p);
            } 
        } 
      
         iTransporter s = new iTransporter();
         s.save(image, rImage);
           
	}
}
