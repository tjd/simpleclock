package parameterClock;

import java.awt.Color;
import mypapplet.MyPApplet;
import processing.core.PFont;

public class AnalogClock extends MyPApplet {

	private static final int SCREEN_HEIGHT = 400;
	private static final int SCREEN_WIDTH = 400;
	private static final Color BACKGROUND_COLOR = Color.WHITE;

	private static final String NUMBER_FONT_NAME = "Arial";
	private static final int NUMBER_FONT_SIZE = 20;
	private static final Color NUMBER_COLOR = Color.BLACK;

	private static final int HOUR_TICK_WEIGHT = 3;
	private static final int MINUTE_TICK_WEIGHT = 1;

	private static final Color CLOCK_EDGE_COLOR = Color.GRAY;

	private static final Color CENTER_PEG_COLOR = Color.GRAY;
	private static final int CENTER_PEG_WEIGHT = 3;

	private static final Color HOUR_HAND_ARROW_COLOR = Color.GREEN;
	private static final Color HOUR_HAND_COLOR = Color.GREEN;
	private static final int HOUR_HAND_WEIGHT = 3;

	private static final Color MINUTE_HAND_ARROW_COLOR = Color.BLUE;
	private static final Color MINUTE_HAND_COLOR = Color.BLUE;
	private static final int MINUTE_HAND_WEIGHT = 3;
	
	private static final Color SECOND_HAND_ARROW_COLOR = Color.RED;
	private static final Color SECOND_HAND_COLOR = Color.RED;
	private static final int SECOND_HAND_WEIGHT = 1;

	public float angleOfSecHand;
	public float angleOfMinHand;
	public float angleOfHourHand;

	public PFont font;

	public void setup() {
		size(SCREEN_WIDTH, SCREEN_HEIGHT);
		stroke(0, 0, 255);
		fill(0, 0, 255);
		smooth();

		font = createFont(NUMBER_FONT_NAME, NUMBER_FONT_SIZE);
		textFont(font);
	}

	public void draw() {
		background(BACKGROUND_COLOR);

		translate(width / 2, height / 2);

		drawSecondsHand();
		drawMinutesHand();
		drawHoursHand();

		drawClockFace();
	}

	private void drawClockFace() {
		pushMatrix();
		noFill();
		stroke(CLOCK_EDGE_COLOR);
		circle(300);

		// center peg
		fill(CENTER_PEG_COLOR);
		circle(CENTER_PEG_WEIGHT);

		// ticks for minutes
		strokeWeight(MINUTE_TICK_WEIGHT);
		for (int i = 0; i < 60; ++i) {
			pushMatrix();
			rotate(i * 2 * PI / 60);
			line(0, -150, 0, -145);
			popMatrix();
		}

		// ticks for hours
		strokeWeight(HOUR_TICK_WEIGHT);
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
		fill(NUMBER_COLOR);
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
		angleOfHourHand = (2 * PI / 12) * (h + minute() / 60f);

		pushMatrix();
		fill(HOUR_HAND_ARROW_COLOR);
		stroke(HOUR_HAND_COLOR);
		strokeWeight(HOUR_HAND_WEIGHT);

		rotate(angleOfHourHand);

		// draw the arrow
		line(0, -height / 6, 0, 30);
		triangle(-5, -height / 6, 5, -height / 6, 0, -height / 6 - 10);
		popMatrix();
	}

	private void drawMinutesHand() {
		angleOfMinHand = (2 * PI / 60f) * (minute() + second() / 60f);

		pushMatrix();
		fill(MINUTE_HAND_ARROW_COLOR);
		stroke(MINUTE_HAND_COLOR);
		strokeWeight(MINUTE_HAND_WEIGHT);

		rotate(angleOfMinHand);

		// draw the arrow
		line(0, -height / 4, 0, 40);
		triangle(-5, -height / 4, 5, -height / 4, 0, -height / 4 - 10);
		popMatrix();
	}

	private void drawSecondsHand() {
		angleOfSecHand = second() * 2 * PI / 60;

		pushMatrix();
		fill(SECOND_HAND_ARROW_COLOR);
		stroke(SECOND_HAND_COLOR);
		strokeWeight(SECOND_HAND_WEIGHT);

		rotate(angleOfSecHand);

		// draw the hand
		line(0, -height / 3, 0, 10);
		// triangle(-5, -height / 4, 5, -height / 4, 0, -height / 4 - 10);
		popMatrix();
	}

}