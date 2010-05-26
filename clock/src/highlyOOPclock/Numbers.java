package highlyOOPclock;

import java.awt.Color;

import processing.core.PFont;
import util.MyPApplet;

public class Numbers extends Part {

	private PFont font;

	public Numbers(MyPApplet app, Color color) {
		super(app, color);
		font = app.createFont("Arial", 20);
		app.textFont(font);
	}

	protected void render() {
		// TODO: fix the position of the numbers
		// When the commented-out rotation line below is uncommented,
		// the orientation is okay, but position is off. Position each
		// number by hand?
		// draw numbers
		// app.pushAll();
		app.fill(color);
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
		// app.popAll();
	}

}
