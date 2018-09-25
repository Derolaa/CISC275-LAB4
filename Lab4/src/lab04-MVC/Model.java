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
	
	int xLocation;
	int yLocation;
	int xIncr = 8;
	int yIncr = 2;
	boolean x_incr = true;
	boolean x_incr = true;
	
	public Orc() {
		xLocation = 0;
		yLocation = 0;
		x_inc = true;
		y_inc = true;
	}	
}
