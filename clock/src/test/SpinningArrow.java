package test;

import processing.core.PApplet;

public class SpinningArrow extends PApplet {

	public float angle;
	public float da; // rotation speed

	public void setup() {
		size(400, 400);
		angle = 0f;
		da = 0.025f;
		stroke(0, 0, 255);
		fill(0, 0, 255);
	}

	public void draw() {
		background(255);

		// Be careful: the order of the next two statement matters
		translate(width / 2, height / 2);
		rotate(angle); // rotations are in radians

		// draw the arrow
		line(0, -height / 4, 0, height / 4);
		triangle(-5, -height / 4, 5, -height / 4, 0, -height / 4 - 10);

		// update the arrow
		angle += da;
	}

}