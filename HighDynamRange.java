package project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HighDynamRange extends Filter{

	
	public HighDynamRange() {}
	
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
                
                int newRed = (int)(0.850*red + red/2); 
                int newGreen = (int)(0.850*green + green/2); 
                int newBlue = (int)(0.850*blue + blue/2); 
                
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

