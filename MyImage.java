package project;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyImage {

	String path;
	BufferedImage image;
	int width;
	int height;
	
	public MyImage() {}
	
	public MyImage(String p, BufferedImage i, int w, int h) {
		path = p;
		image = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_ARGB);
		width = w;
		height = h;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public BufferedImage getImage() {
		return this.image;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setPath(String p) {
		path = p;
	}
	
	public void setImage(BufferedImage i) {
		image = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_ARGB);
	}
	
	public void setImage(MyImage i) {
		image = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_ARGB);
	}
	
	public void setImage(File infile) throws IOException {
		image = ImageIO.read(infile);
		width = image.getWidth();
        height = image.getHeight();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}
	
	public void setWidth(int w) {
		width = w;
	}
	
	public void setHeight(int h) {
		height = h;
	}
	
	public void assign(MyImage i) {
		this.setHeight(i.getHeight());
		this.setImage(i.copyImage(i.getImage()));
		this.setPath(i.getPath());
		this.setWidth(i.getWidth());
	}
	
	public  BufferedImage copyImage(BufferedImage i){
	    BufferedImage b = new BufferedImage(i.getWidth(), i.getHeight(), i.getType());
	    Graphics g = b.getGraphics();
	    g.drawImage(i, 0, 0, null);
	    return b;
	}
}



