package simpleclock;

import java.awt.Color;

import processing.core.PApplet;

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
}
