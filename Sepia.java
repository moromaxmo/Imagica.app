package project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sepia extends Filter{

	public Sepia() {}
	
	public void apply(MyImage image) throws IOException {
		BufferedImage fImage = null; 
        File f = null; 
        f = new File(image.getPath()); 
        fImage = ImageIO.read(f);
        int width = fImage.getWidth(); 
        int height = fImage.getHeight(); 
        
        for(int y = 0; y < height; y++) 
        { 
            for(int x = 0; x < width; x++) 
            { 
                int p = fImage.getRGB(x,y); 
                int a = (p>>24)&0xff; 
                
                int red = (p>>16)&0xff; 
                int green = (p>>8)&0xff; 
                int blue = p&0xff; 
                
                int newRed = (int)(0.393*red + 0.769*green + 0.189*blue); 
                int newGreen = (int)(0.349*red + 0.686*green + 0.168*blue); 
                int newBlue = (int)(0.272*red + 0.534*green + 0.131*blue); 
                
                if (newRed > 255) 
                    red = 255; 
                else
                    red = newRed; 
  
                if (newGreen > 255) 
                    green = 255; 
                else
                    green = newGreen; 
  
                if (newBlue > 255) 
                    blue = 255; 
                else
                    blue = newBlue; 
                
                p = (a<<24) | (red<<16) | (green<<8) | blue; 
                
                fImage.setRGB(x, y, p); 
            } 
        } 
      
         iTransporter s = new iTransporter();
         s.save(image, fImage);
           
	}
}
