/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/

import java.util.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.File;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class View extends JPanel {
	BufferedImage[][] pics;
	private int xloc;
	private int yloc;
	private boolean north;
	private boolean south;
	private boolean east;
	private boolean west;
	private int picNum = 0;
	private int orcImageNum = 0;
	final int frameCount = 10;
	private final static int frameWidth = 500;
	private final static int frameHeight = 300;
	private final static int imageWidth = 165;
	private final static int imageHeight = 165;
	
	public int getImageHeight() {
		return imageHeight;
	}
	
	public int getImageWidth() {
		return imageWidth;
	}
	
	public static int getFrameWidth() {
		return frameWidth;
	}
	
	public static int getFrameHeight() {
		return frameHeight;
	}
	
	/*public static void animation() {
    	JFrame frame = new JFrame();
    	frame.getContentPane().add(new View());
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameWidth, frameHeight);
    	frame.setVisible(true);
    	for(int i = 0; i < 1000; i++){
    		frame.repaint();
    		try {
    			Thread.sleep(100);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }*/
	
	public View() {
		final BufferedImage[] imgs = {
				/*Images.ORC_FW_N.getImage(),
				Images.ORC_FW_NE.getImage(),
				Images.ORC_FW_NW.getImage(),
				Images.ORC_FW_S.getImage(),
				Images.ORC_FW_SE.getImage(),
				Images.ORC_FW_SW.getImage(),
				Images.ORC_FW_E.getImage(),
				Images.ORC_FW_W.getImage();*/
		}
		
		pics = new BufferedImage[8][frameCount];
		
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < frameCount; i++) {
				pics[j][i] = imgs[j].getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
			}
		}
	}
	
	public void update(int x, int y, boolean[] direct) {
		xloc = x;
		yloc = y;
		north = direct[0];
		south = direct[1];
		east = direct[2];
		west = direct[3];
	}
	
	public void paint(Graphics g) {
		picNum = (picNum + 1) % frameCount;
		/*if(xloc+xIncr+155>frameWidth){
    		if(yloc+imageHeight+yIncr>frameHeight)
    			g.drawImage(pics[7][picNum], moveWest, yloc, Color.gray, this);
    		else
    			g.drawImage(pics[4][picNum], xloc, moveSouth, Color.gray, this);
    	}
    	else if(yloc+imageHeight+yIncr>frameHeight){
    		if(xloc<-50)
    			g.drawImage(pics[1][picNum], xloc, moveNorth, Color.gray, this);
    		else
    			g.drawImage(pics[7][picNum], moveWest, yloc, Color.gray, this);
    	}
    	else if(xloc<-50)
    		if(yloc<-30)
    			g.drawImage(pics[0][picNum], moveEast, yloc, Color.gray, this);
    		else
    			g.drawImage(pics[1][picNum], xloc, moveNorth, Color.gray, this);
    	else
        	g.drawImage(pics[0][picNum], moveEast, yloc, Color.gray, this);*/
		if (north) {
			orcImageNum = 0;
		}
		if (south) {
			orcImageNum = 1;
		}
		if (east) {
			orcImageNum = 2;
		}
		if (west) {
			orcImageNum = 3;
		}
		if (north && east) {
			orcImageNum = 4;
		}
		if (north && west) {
			orcImageNum = 5;
		}
		if (south && east) {
			orcImageNum = 6;
		}
		if (south && west) {
			orcImageNum = 7;
		}
		g.drawImage(pics[orcImageNum][picNum], xloc, yloc, Color.gray, this);
	}
	
	public enum Images {
		
		private BufferedImage img;
		
		Images(String dir) {
			img = createImage(dir);
		}
		
		public BufferedImage getImage() {
			return img;
		}
	}
	private static BufferedImage createImage(String dir) {
		//final File imgFile = new File(dir);
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File("images/orc/orc_forward_"+dir+".png"));
			return bufferedImage;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

