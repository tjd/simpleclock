package highlyOOPclock;

import java.awt.Color;

import util.MyPApplet;

public class LineSegment extends Part {
	protected int length;
	protected int weight;
	protected int height;
	protected float angle;

	public LineSegment(MyPApplet app, int length, int height, int weight,
			Color color) {
		super(app, color);
		this.length = length;
		this.height = height;
		this.weight = weight;
		this.angle = 0;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	protected void render() {
		// app.pushAll();
		app.strokeWeight(weight);
		app.stroke(color);
		app.rotate(angle);
		app.line(0, -height + length, 0, -height);
		// app.popAll();
	}

	public void draw(float angle) {
		setAngle(angle);
		render();
	}

}
