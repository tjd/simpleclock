package parameterClock;

import java.awt.Color;

import util.MyPApplet;
import util.Tester;

public abstract class BasicPart extends Tester {

	protected MyPApplet app;
	protected Color lineColor;
	protected boolean hidden;

	public BasicPart(MyPApplet app) {
		this(app, Color.BLACK, false);
	}
	
	public BasicPart(MyPApplet app, Color color) {
		this(app, color, false);
	}
	
	public BasicPart(MyPApplet app, Color color, boolean hidden) {
		assertNotNull(app, color);
		this.app = app;
		this.lineColor = color;
		this.hidden = hidden;
	}

	public void draw() {
		if (!hidden) {
			app.pushAll();
			app.stroke(lineColor);
			render();
			app.popAll();
		}
	}

	public abstract void render();

}
