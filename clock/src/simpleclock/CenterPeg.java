package simpleclock;

import java.awt.Color;

public class CenterPeg extends Sprite {

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
