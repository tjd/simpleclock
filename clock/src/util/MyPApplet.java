package util;

import java.awt.Color;

import processing.core.PApplet;

/*
 * Has a few helper methods to PApplet. For instance, methods are added to accept Java Color
 * objects.
 * 
 */

public class MyPApplet extends PApplet {

	public void stroke(Color c) {
		stroke(c.getRed(), c.getGreen(), c.getBlue());
	}

	public void background(Color c) {
		background(c.getRed(), c.getGreen(), c.getBlue());
	}

	public void fill(Color c) {
		fill(c.getRed(), c.getGreen(), c.getBlue());
	}

	public void ellipse(float width, float height) {
		ellipse(0, 0, width, height);
	}

	public void circle(float x, float y, float diam) {
		ellipse(x, y, diam, diam);
	}

	public void circle(float diam) {
		circle(0, 0, diam);
	}

	public void pushAll() {
		pushMatrix();
		pushStyle();
	}

	public void popAll() {
		popStyle();
		popMatrix();
	}
}
