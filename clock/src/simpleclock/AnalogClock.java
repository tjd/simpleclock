package simpleclock;

import java.awt.Color;

import processing.core.PFont;

public class AnalogClock extends MyPApplet {

	public Hand secondsHand;
	public Hand minutesHand;
	public Hand hoursHand;

//	public TickMark minuteTick;
//	public TickMark hourTick;

	public Face face;
	
	public SimpleTime time;

	public PFont font;

	public void setup() {
		size(400, 400);
		stroke(Color.BLUE);
		fill(Color.BLUE);
		smooth();

		// create the hands
		secondsHand = new Hand(this, 130, 1, Color.RED, false);
		minutesHand = new Hand(this, 110, 3, Color.BLUE, false);
		hoursHand = new Hand(this, 80, 3, Color.GREEN, false);

		face = new Face(this);

		// initialize the time
		time = new SimpleTime(this);

		// create and set the numbers font
		font = createFont("Arial", 20);
		textFont(font);
	}

	public void draw() {
		background(Color.WHITE);

		translate(width / 2, height / 2);

		time.updateToNow();
		face.draw();
		drawSecondsHand(time);
		drawMinutesHand(time);
		drawHoursHand(time);		
	}

	private void drawHoursHand(SimpleTime t) {
		float angle = (2 * PI / 12) * (t.h + t.m / 60f);
		hoursHand.setAngle(angle);
		hoursHand.draw();
	}

	private void drawMinutesHand(SimpleTime t) {
		float angle = (2 * PI / 60f) * (t.m + t.s / 60f);
		minutesHand.setAngle(angle);
		minutesHand.draw();
	}

	private void drawSecondsHand(SimpleTime t) {
		float angle = t.s * 2 * PI / 60f;
		secondsHand.setAngle(angle);
		secondsHand.draw();
	}

}