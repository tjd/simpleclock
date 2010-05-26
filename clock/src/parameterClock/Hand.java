package parameterClock;

import java.awt.Color;

import util.MyPApplet;

abstract public class Hand extends WeightedPart {
	Color fillColor;

	public Hand(MyPApplet app, Color lineColor, int weight, Color fillColor) {
		super(app, lineColor, weight);
		this.fillColor = fillColor;
	}
	
	public void draw() {
		if (!hidden) {
			app.pushAll();
			app.stroke(lineColor);
			app.strokeWeight(weight);
			app.fill(fillColor);
			render();
			app.popAll();
		}
	}

}
