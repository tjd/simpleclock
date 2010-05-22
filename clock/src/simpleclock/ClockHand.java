package simpleclock;

import java.awt.Color;

//import processing.core.PApplet;

public class ClockHand {
	private MyPApplet app;
	private int length;
	private int weight;
	private Color color;
	private boolean hasArrow;

	public ClockHand(MyPApplet app, int length, int weight, Color color,
			boolean hasArrow) {
		this.app = app;
		this.length = length;
		this.weight = weight;
		this.color = color;
		this.hasArrow = hasArrow;
	}

	public void draw() {
		app.pushStyle();
		app.strokeWeight(weight);
		app.stroke(color);
		app.line(0, 0, 0, length);
		if (hasArrow) {
			app.triangle(-5, length, 5, length, 0, 10);
			// triangle(-5, -height / 4, 5, -height / 4, 0, -height / 4 - 10);
		}
		app.popStyle();
	}

}
