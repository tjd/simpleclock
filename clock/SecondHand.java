package cmpt125.clock;

import processing.core.PApplet;

public class SecondHand extends PApplet {

	// moves 1/60th of the way around the clock each tick
	public final float TICK_AMOUNT = PI / 60f;

	public float angle; // current orientation of the hand

	public int seconds;

	public void setup() {
		size(400, 400);
		angle = 0f;

		seconds = -1;

		stroke(0, 0, 255);
		fill(0, 0, 255);
	}

	public void draw() {
		background(255);

		// Be careful: the order of the next two statement matters
		translate(width / 2, height / 2);
		rotate(angle); // rotations are in radians
		
		int s = second();
		if (s != seconds) {
			angle += TICK_AMOUNT;
			seconds = s;
		}		

		// draw the arrow
		line(0, -height / 4, 0, height / 4);
		triangle(-5, -height / 4, 5, -height / 4, 0, -height / 4 - 10);

	}

}