/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JPanel {
	BufferedImage[][] pics;
	private int xloc = 0;
	private int yloc = 0;
	int xIncr;
	int yIncr;
	private boolean north;
	private boolean south;
	private boolean east;
	private boolean west;
	private static int picNum = 0;
	private static int frameNum = 0;
	final int frameCount = 10;
	public Controller controller;
	int loc = 0;
    private final static int frameW = 500;
	private final static int frameH = 300;
	private final static int imageWidth = 165;
	private final static int imageHeight = 165;
	
	public static JFrame frame;

	public int getImageHeight() {
		return imageHeight;
	}
	
	public int getImageWidth() {
		return imageWidth;
	}
	
	public int getHeight() {
		return frameH;
	}
	
	public int getWidth() {
		return frameW;
	}
	
	
	public void update(int x1, int y1, int newLoc) {
		// TODO Auto-generated method stub
        frame = new JFrame();
    	frame.getContentPane().add(this);
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(frameW, frameH);
    	frame.setVisible(true);
    	
    	xloc = x1;
    	yloc = y1;
    	loc  = newLoc;
    	frame.repaint();
    	try {
   			Thread.sleep(100);
   		} catch (InterruptedException e) {
   			e.printStackTrace();
   		}
	}

	public View() {		
		pics = new BufferedImage[8][frameCount];
		
		for (int j = 0; j < 8; j++) {
			BufferedImage image = createImage(j);
			pics[j] = new BufferedImage[frameCount];
			for (int i = 0; i < frameCount; i++) {
				pics[j][i] = image.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
			}
		}
	}
	
	public void paint(Graphics g) {
		picNum = (picNum + 1) % frameCount;
		g.drawImage(pics[loc][picNum], xloc += xIncr, yloc += yIncr, Color.gray, this);
	}
	BufferedImage createImage(int j) {
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File("pics/orc_forward_"+j+".png));"));
			return bufferedImage;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
}