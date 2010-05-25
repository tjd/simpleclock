package simpleclock;

import java.awt.Color;

/*
 * Represents one hand of a clock. Optionally, an arrow can be drawn on
 * the end of the hand.
 * 
 */

public class Hand extends LineSegment {
//	private int length;
//	private int weight;
	private boolean hasArrow;
//	private float angle;

	// private boolean hidden;

	public Hand(MyPApplet app, int length, int weight, Color color,
			boolean hasArrow) {
		super(app, length, 0, weight, color);
//		this.length = length;
//		this.weight = weight;
		this.hasArrow = hasArrow;
//		this.angle = 0;
	}

	public void render() {
		super.render();
//		app.pushAll();
//		app.strokeWeight(weight);
//		app.stroke(color);
//		app.rotate(angle);
//		app.line(0, 0, 0, -length);

		// TODO: fix the arrow
		if (hasArrow) {
			app.triangle(-5, length, 5, length, 0, 10);
			// triangle(-5, -height / 4, 5, -height / 4, 0, -height / 4 -
			// 10);
		}
//		app.popAll();
	}
//
//	public void setAngle(float angle) {
//		this.angle = angle;
//	}

}
