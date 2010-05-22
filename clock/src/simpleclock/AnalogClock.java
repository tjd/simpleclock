package simpleclock;

import processing.core.PFont;

public class AnalogClock extends MyPApplet {

	// second hand moves 1/60th of the way around the clock each tick
	public final float TICK_AMOUNT = 2 * PI / 60f;

	public float angleOfSecHand;
	public float angleOfMinHand;
	public float angleOfHourHand;

	public PFont font;

	public void setup() {
		size(400, 400);
		stroke(0, 0, 255);
		fill(0, 0, 255);
		smooth();

		font = createFont("Arial", 20);
		textFont(font);
	}

	public void draw() {
		background(255);

		translate(width / 2, height / 2);

		drawSecondsHand();
		drawMinutesHand();
		drawHoursHand();

		drawClockFace();
	}

	private void drawClockFace() {
		pushMatrix();
		noFill();
		stroke(128);
		ellipse(0, 0, 300, 300);
		fill(0);
		ellipse(0, 0, 3, 3);

		// ticks for seconds/minutes
		strokeWeight(1);
		for (int i = 0; i < 60; ++i) {
			pushMatrix();
			rotate(i * 2 * PI / 60);
			line(0, -150, 0, -145);
			popMatrix();
		}

		// ticks for hours
		strokeWeight(3);
		for (int i = 0; i < 12; ++i) {
			pushMatrix();
			rotate(i * 2 * PI / 12);
			line(0, -150, 0, -140);
			popMatrix();
		}

		// TODO: fix the position of the numbers
		// When the commented-out rotation line below is uncommented,
		// the orientation is okay, but position is off. Position each
		// number by hand?
		// numbers
		fill(0);
		for (int i = 0; i < 12; ++i) {
			pushMatrix();
			rotate(i * 2 * PI / 12 + 2 * PI / 12);
			String num = "" + (i + 1);
			translate(-textWidth(num) / 2, -120);
			pushMatrix();
			//rotate(-i * 2 * PI / 12 - 2 * PI / 12);
			text(num, 0, 0);
			popMatrix();
			popMatrix();
		}
		popMatrix();
	}

	private void drawHoursHand() {
		int h = hour();
		if (h >= 12) {
			h -= 12;
		}
		angleOfHourHand = (2 * PI / 12) * (h + minute() / 60f);

		pushMatrix();
		fill(0, 255, 0);
		stroke(0, 255, 0);
		strokeWeight(3);

		rotate(angleOfHourHand);

		// draw the arrow
		line(0, -height / 6, 0, 30);
		triangle(-5, -height / 6, 5, -height / 6, 0, -height / 6 - 10);
		popMatrix();
	}

	private void drawMinutesHand() {
		angleOfMinHand = (2 * PI / 60f) * (minute() + second() / 60f);

		pushMatrix();
		fill(0, 0, 255);
		stroke(0, 0, 255);
		strokeWeight(3);

		rotate(angleOfMinHand);

		// draw the arrow
		line(0, -height / 4, 0, 40);
		triangle(-5, -height / 4, 5, -height / 4, 0, -height / 4 - 10);
		popMatrix();
	}

	private void drawSecondsHand() {
		angleOfSecHand = second() * 2 * PI / 60;

		pushMatrix();
		// fill(0, 0, 255);
		stroke(255, 0, 0);
		strokeWeight(1);

		rotate(angleOfSecHand);

		// draw the hand
		line(0, -height / 3, 0, 10);
		// triangle(-5, -height / 4, 5, -height / 4, 0, -height / 4 - 10);
		popMatrix();
	}

}