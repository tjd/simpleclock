package simpleclock;

import java.awt.Color;

import processing.core.PFont;

public class AnalogClock extends MyPApplet {

	// second hand moves 1/60th of the way around the clock each tick
	public final float TICK_AMOUNT = 2 * PI / 60f;

	// public float angleOfSecHand;
	// public float angleOfMinHand;
	// public float angleOfHourHand;

	public ClockHand secondsHand;
	public ClockHand minutesHand;
	public ClockHand hoursHand;

	public PFont font;

	public void setup() {
		size(400, 400);
		stroke(0, 0, 255);
		fill(0, 0, 255);
		smooth();

		// create the hands
		secondsHand = new ClockHand(this, 130, 1, Color.RED, false);
		minutesHand = new ClockHand(this, 110, 3, Color.BLUE, false);
		hoursHand = new ClockHand(this, 80, 3, Color.GREEN, false);

		// create the numbers font
		font = createFont("Arial", 20);
		textFont(font);
	}

	public void draw() {
		background(Color.WHITE);

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
		fill(Color.BLACK);
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
		fill(Color.BLACK);
		for (int i = 0; i < 12; ++i) {
			pushMatrix();
			rotate(i * 2 * PI / 12 + 2 * PI / 12);
			String num = "" + (i + 1);
			translate(-textWidth(num) / 2, -120);
			pushMatrix();
			// rotate(-i * 2 * PI / 12 - 2 * PI / 12);
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
		float angle = (2 * PI / 12) * (h + minute() / 60f);
		hoursHand.setAngle(angle);
		hoursHand.draw();
	}

	private void drawMinutesHand() {
		float angle = (2 * PI / 60f) * (minute() + second() / 60f);
		minutesHand.setAngle(angle);
		minutesHand.draw();
	}

	private void drawSecondsHand() {
		float angle = second() * 2 * PI / 60;
		secondsHand.setAngle(angle);
		secondsHand.draw();
	}

}