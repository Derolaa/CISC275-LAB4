/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/
import java.util.*;
import java.awt.*;

class Model {
	final static int xIncr = 8;
	final static int yIncr = 2;
	private static boolean moveEast = false;
	private static boolean moveWest = true;
	private static boolean moveNorth = false;
	private static boolean moveSouth = true;
	private static int x;
	private static int y;
	int xloc = 0;
	int yloc = 0;
	int imageWidth;
	int imageHeight;
	int width;
	int height;
	private boolean direct[] = {moveNorth, moveSouth, moveEast, moveWest};
	
	public Model(int width, int height, int imageWidth, int imageHeight) {
		this.width = width;
		this.height = height;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	public boolean[] getDirect() {
		// TODO Auto-generated method stub
		return direct;
	}
	
public static void moveOrc() {
	if (!moveEast && !moveWest && !moveNorth && !moveSouth) {
		System.out.println("Nothing is true, don't move!");
	} 
	else {
		if (moveEast) {
			x += xIncr;
		}
		else if (moveWest) {
			x -= xIncr;
		}
		if (moveSouth) {
			y += yIncr;
		}
		else if (moveNorth) {
			y -= yIncr;
		}
	}
}

public void updateLocationAndDirection() {
	System.out.println(x + " " + y + "  " + direct[0] + " " + direct[1] + " " + direct[2] + " " + direct[3]);
	moveOrc();
	}
}

