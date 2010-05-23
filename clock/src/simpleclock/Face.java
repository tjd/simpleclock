package simpleclock;

import java.awt.Color;

public class Face {
	private MyPApplet app;
	private static final float PI = MyPApplet.PI;
	private TickMark minuteTick;
	private TickMark hourTick;

	public Face(MyPApplet app) {
		this.app = app;
		minuteTick = new TickMark(app, 5, 150, 1, Color.BLACK);
		hourTick = new TickMark(app, 10, 150, 3, Color.BLACK);
	}

	public void draw() {
		app.pushMatrix();
		app.noFill();
		app.stroke(128);
		app.strokeWeight(3);
		app.circle(300);
		app.fill(Color.BLACK);
		app.circle(3);

		// ticks for seconds/minutes
		for (int i = 0; i < 60; ++i) {
			minuteTick.draw(i * 2 * PI / 60f);
		}

		// ticks for hours
		for (int i = 0; i < 12; ++i) {
			hourTick.draw(i * 2 * PI / 12f);
		}

		// TODO: fix the position of the numbers
		// When the commented-out rotation line below is uncommented,
		// the orientation is okay, but position is off. Position each
		// number by hand?
		// draw numbers
		app.fill(Color.BLACK);
		for (int i = 0; i < 12; ++i) {
			app.pushMatrix();
			app.rotate((i + 1) * 2 * PI / 12f);
			String num = "" + (i + 1);
			app.translate(-app.textWidth(num) / 2, -120);
			app.pushMatrix();
			// rotate(-i * 2 * PI / 12 - 2 * PI / 12);
			app.text(num, 0, 0);
			app.popMatrix();
			app.popMatrix();
		}
		app.popMatrix();
	}
}
