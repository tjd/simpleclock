package highlyOOPclock;

import java.awt.Color;

import mypapplet.MyPApplet;

public class OuterRim extends Part {
	private int diam;
	private int weight;

	public OuterRim(MyPApplet app, int diam) {
		this(app, Color.BLACK, diam, 3);
	}

	public OuterRim(MyPApplet app, Color color, int diam, int weight) {
		super(app, color);
		this.diam = diam;
		this.weight = weight;
	}

	protected void render() {
		app.noFill();
		app.stroke(color);
		app.strokeWeight(weight);
		app.circle(diam);
	}

}
