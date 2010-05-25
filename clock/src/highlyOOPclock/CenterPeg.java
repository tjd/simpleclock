package highlyOOPclock;

import java.awt.Color;

import mypapplet.MyPApplet;

public class CenterPeg extends Part {

	private int diam;

	public CenterPeg(MyPApplet app, int diam) {
		this(app, Color.BLACK, diam);
	}

	public CenterPeg(MyPApplet app, Color color, int diam) {
		super(app, color);
		this.diam = diam;
	}

	protected void render() {
		app.fill(color);
		app.circle(diam);
	}

}
