package project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BlackandWhite extends Coloring{

	public BlackandWhite() {}
	
	public void apply(MyImage image) throws IOException {
		BufferedImage bwImage = null; 
        File f = null; 
        f = new File(image.getPath()); 
        bwImage = ImageIO.read(f);
        int width = bwImage.getWidth(); 
        int height = bwImage.getHeight(); 
        
        for(int y = 0; y < height; y++) 
        { 
            for(int x = 0; x < width; x++) 
            { 
            	int p = bwImage.getRGB(x,y); 
            	
                int a = (p>>24)&0xff; 
                int r = (p>>16)&0xff; 
                int g = (p>>8)&0xff; 
                int b = p&0xff;   
                int avg = (r+g+b)/3; 
                p = (a<<24) | (avg<<16) | (avg<<8) | avg; 
  
                bwImage.setRGB(x, y, p);
            } 
        } 
      
         iTransporter s = new iTransporter();
         s.save(image, bwImage);
           
	}
}
