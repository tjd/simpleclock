package simpleclock;

import java.awt.Color;

//import processing.core.PApplet;

public class ClockHand {
	private MyPApplet app;
	private int length;
	private int weight;
	private Color color;
	private boolean hasArrow;
	private float angle;

	public ClockHand(MyPApplet app, int length, int weight, Color color,
			boolean hasArrow) {
		this.app = app;
		this.length = length;
		this.weight = weight;
		this.color = color;
		this.hasArrow = hasArrow;
		this.angle = 0;
	}

	public void draw() {
		app.pushAll();
		app.strokeWeight(weight);
		app.stroke(color);
		app.rotate(angle);
		app.line(0, 0, 0, -length);
		
		// TODO: fix the arrow
		if (hasArrow) {
			app.triangle(-5, length, 5, length, 0, 10);
			// triangle(-5, -height / 4, 5, -height / 4, 0, -height / 4 - 10);
		}
		app.popAll();
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

}
