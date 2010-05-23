package simpleclock;

import java.awt.Color;

import processing.core.PFont;

public class AnalogClock extends MyPApplet {

	// second hand moves 1/60th of the way around the clock each tick
	public final float TICK_AMOUNT = 2 * PI / 60f;

	public ClockHand secondsHand;
	public ClockHand minutesHand;
	public ClockHand hoursHand;

	public Tick minuteTick;
	public Tick hourTick;

	public PFont font;

	public void setup() {
		size(400, 400);
		stroke(Color.BLUE);
		fill(Color.BLUE);
		smooth();

		// create the hands
		secondsHand = new ClockHand(this, 130, 1, Color.RED, false);
		minutesHand = new ClockHand(this, 110, 3, Color.BLUE, false);
		hoursHand = new ClockHand(this, 80, 3, Color.GREEN, false);

		// create the tick marks
		minuteTick = new Tick(this, 5, 150, 1, Color.BLACK);
		hourTick = new Tick(this, 10, 150, 3, Color.BLACK);

		// create the numbers font
		font = createFont("Arial", 20);
		textFont(font);
	}

	public void draw() {
		background(Color.WHITE);

		translate(width / 2, height / 2);

		int s = second();
		int m = minute();
		int h = hour();
		drawSecondsHand(s);
		drawMinutesHand(m, s);
		drawHoursHand(h);

		drawClockFace();
	}

	private void drawClockFace() {
		pushMatrix();
		noFill();
		stroke(128);
		strokeWeight(3);
		circle(300);
		fill(Color.BLACK);
		circle(3);

		// ticks for seconds/minutes
		for (int i = 0; i < 60; ++i) {
			minuteTick.draw(i * 2 * PI / 60);
		}

		// ticks for hours
		for (int i = 0; i < 12; ++i) {
			hourTick.draw(i * 2 * PI / 12);
		}

		// TODO: fix the position of the numbers
		// When the commented-out rotation line below is uncommented,
		// the orientation is okay, but position is off. Position each
		// number by hand?
		// draw numbers
		fill(Color.BLACK);
		for (int i = 0; i < 12; ++i) {
			pushMatrix();
			rotate((i + 1) * 2 * PI / 12);
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

	private void drawHoursHand(int h) {
		if (h >= 12) {
			h -= 12;
		}
		float angle = (2 * PI / 12) * (h + minute() / 60f);
		hoursHand.setAngle(angle);
		hoursHand.draw();
	}

	private void drawMinutesHand(int m, int s) {
		float angle = (2 * PI / 60f) * (m + s / 60f);
		minutesHand.setAngle(angle);
		minutesHand.draw();
	}

	private void drawSecondsHand(int s) {
		float angle = s * 2 * PI / 60;
		secondsHand.setAngle(angle);
		secondsHand.draw();
	}

}