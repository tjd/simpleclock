package highlyOOPclock;

import java.awt.Color;

import util.MyPApplet;

/*
 * A TickMark is the small line segment around the edge of clock face.
 * 
 */

public class TickMark extends LineSegment {

	// private MyPApplet app;
	// private int length;
	// private int weight;
	// private int height;
	// private Color color;

	public TickMark(MyPApplet app, int length, int height, int weight,
			Color color) {
		super(app, length, height, weight, color);
		// this.app = app;
		// this.length = length;
		// this.weight = weight;
		// this.height = height;
		// this.color = color;
	}
	//
	// public void draw() {
	// draw(0);
	// }
	//
	// public void draw(float angle) {
	// app.pushAll();
	// app.strokeWeight(weight);
	// app.stroke(color);
	// app.rotate(angle);
	// app.line(0, -height + length, 0, -height);
	// app.popAll();
	// }

}
