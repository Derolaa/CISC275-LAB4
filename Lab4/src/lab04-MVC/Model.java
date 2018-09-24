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

class Model {
	private static int worldW;
	private static int worldH;
	private static int characterW;
	private static int characterH;
	
	private static int x = worldW / 2;
	private static int y = worldH / 2;
	
	private final static int xIncr = 8;
	private final static int yIncr = 2;
	
	private static boolean moveNorth = false;
	private static boolean moveSouth = true;
	private static boolean moveEast = false;
	private static boolean moveWest = true;
	private boolean move[] = {moveNorth, moveSouth, moveEast, moveWest};
	
	public Model(int width, int height, int imageWidth, int imageHeight) {
		worldW = width;
		worldH = height;
		characterW = imageWidth;
		characterH = imageHeight;
	}
	
	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}
	
	public boolean[] getMove() {
		return move;
	}
	
	public void updateLocDir() {
		System.out.println(x + " " + y + " " + move[0] + " " + move[1] + " " + move[2] + " " + move[3]);
		handleOrc();
		moveOrc();
	}
	
	public static void moveOrc() {
		if (!moveEast && !moveWest && !moveNorth && !moveSouth) {
			System.out.println("Don't move");
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
	
	public static void handleOrc() {
		if (x < 0) {
			System.out.println("West wall");
			moveEast = true;
			moveWest = false;
		}
		if ( x > worldW + characterW) {
			System.out.println("East wall");
			moveWest = true;
			moveEast = false;
		}
		if ( y < 0) {
			System.out.println("North wall");
				moveSouth = true;
				moveNorth = false;
		}
		if (y > worldH + characterH) {
			System.out.println("South wall");
				moveNorth = true;
				moveSouth = false;
		}
	}
}
