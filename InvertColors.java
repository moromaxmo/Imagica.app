package project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class InvertColors extends Coloring{

	public InvertColors() {}
	
	public void apply(MyImage image) throws IOException {
		BufferedImage inImage = null; 
        File f = null; 
        f = new File(image.getPath()); 
        inImage = ImageIO.read(f);
        int width = inImage.getWidth(); 
        int height = inImage.getHeight(); 
        
        for(int y = 0; y < height; y++) 
        { 
            for(int x = 0; x < width; x++) 
            { 
            	int p = inImage.getRGB(x,y); 
                int a = (p>>24)&0xff; 
                int r = (p>>16)&0xff; 
                int g = (p>>8)&0xff; 
                int b = p&0xff; 

                r = 255 - r; 
                g = 255 - g; 
                b = 255 - b; 

                p = (a<<24) | (r<<16) | (g<<8) | b; 
                inImage.setRGB(x, y, p);
            } 
        } 
      
         iTransporter s = new iTransporter();
         s.save(image, inImage);
           
	}
}
