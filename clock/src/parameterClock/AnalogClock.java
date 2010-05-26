package parameterClock;

import java.awt.Color;
import processing.core.PFont;
import util.MyPApplet;

public class AnalogClock extends MyPApplet {

	private static final int SCREEN_HEIGHT = 400;
	private static final int SCREEN_WIDTH = 400;
	private static final int X = SCREEN_WIDTH / 2;
	private static final int Y = SCREEN_HEIGHT / 2;
	private static final Color BACKGROUND_COLOR = Color.WHITE;

	public PFont font;
	private static final String NUMBER_FONT_NAME = "Arial";
	private static final int NUMBER_FONT_SIZE = 20;

	// center peg is centered at (0, 0)
	WeightedPart centerPeg = new WeightedPart(this, Color.BLACK, 4) {
		int diam = 3;

		public void render() {
			app.fill(lineColor);
			circle(diam);
		}
	};

	// outer rim is centered at (0, 0)
	WeightedPart outerRim = new WeightedPart(this, Color.GRAY, 3) {
		int diam = 300;

		public void render() {
			app.noFill();
			circle(diam);
		}
	};

	// minute ticks centered at (0, 0)
	WeightedPart minuteTicks = new WeightedPart(this, Color.GRAY, 1) {
		public void render() {
			for (int i = 0; i < 60; ++i) {
				pushMatrix();
				rotate(i * 2 * PI / 60);
				line(0, -150, 0, -145);
				popMatrix();
			}
		}
	};

	// hour ticks centered at (0, 0)
	WeightedPart hourTicks = new WeightedPart(this, Color.GRAY, 3) {
		public void render() {
			for (int i = 0; i < 12; ++i) {
				pushMatrix();
				rotate(i * 2 * PI / 12);
				line(0, -150, 0, -140);
				popMatrix();
			}
		}
	};

	// numbers centered at (0, 0)
	BasicPart numbers = new BasicPart(this) {
		public void render() {
			app.fill(Color.BLACK);
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
		}
	};

	Hand hourHand = new Hand(this, Color.GREEN, 3, Color.GREEN) {
		public void render() {
			int h = hour();
			if (h >= 12) {
				h -= 12;
			}
			float angleOfHourHand = (2 * PI / 12) * (h + minute() / 60f);

			rotate(angleOfHourHand);

			// draw the arrow
			line(0, -height / 6, 0, 30);
			triangle(-5, -height / 6, 5, -height / 6, 0, -height / 6 - 10);
		}

	};

	Hand minuteHand = new Hand(this, Color.BLUE, 3, Color.BLUE) {
		public void render() {
			float angleOfMinHand = (2 * PI / 60f) * (minute() + second() / 60f);
			
			rotate(angleOfMinHand);

			// draw the arrow
			line(0, -height / 4, 0, 40);
			triangle(-5, -height / 4, 5, -height / 4, 0, -height / 4 - 10);
		}

	};

	WeightedPart secondHand = new WeightedPart(this, Color.RED, 1) {
		public void render() {
			float angleOfSecHand = second() * 2 * PI / 60;

			rotate(angleOfSecHand);

			// draw the hand
			line(0, -height / 3, 0, 10);
			// triangle(-5, -height / 4, 5, -height / 4, 0, -height / 4 - 10);
		}

	};

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
		translate(X, Y);

		outerRim.draw();
		minuteTicks.draw();
		hourTicks.draw();
		// TODO: fix the position of the numbers
		// When the commented-out rotation line below is uncommented,
		// the orientation is okay, but position is off. Position each
		// number by hand?
		numbers.draw();
		
		secondHand.draw();
		minuteHand.draw();
		hourHand.draw();
		
		centerPeg.draw();
	}

}