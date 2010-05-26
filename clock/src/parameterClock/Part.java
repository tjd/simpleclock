package parameterClock;

import java.awt.Color;
import util.MyPApplet;
import util.Tester;

abstract public class Part extends Tester {
	private MyPApplet app;
	Color color;
	boolean hidden;
	int weight;

	public Part(MyPApplet app, Color color, int weight) {
		assertNotNull(app, color);
		assertTrue(weight > 0);
		this.app = app;
		this.color = color;
		this.weight = weight;
		this.hidden = false;
	}

	final public void draw() {
		if (!hidden) {
			app.pushAll();
			app.strokeWeight(weight);
			app.stroke(color);
			render();
			app.popAll();
		}
	}

	abstract public void render();

}
