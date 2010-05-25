package highlyOOPclock;

import java.awt.Color;

abstract public class Part extends Tester {
	public static final float PI = MyPApplet.PI;
	protected MyPApplet app;
	protected Color color;
	private boolean hidden;

	public Part(MyPApplet app) {
		this(app, Color.BLACK, false);
	}

	public Part(MyPApplet app, Color color) {
		this(app, color, false);
	}

	public Part(MyPApplet app, Color color, boolean hidden) {
		this.app = app;
		this.color = color;
		this.hidden = hidden;
	}

	// draw() is called by client classes
	// render() is implemented by extending classes
	protected abstract void render();

	final public void draw() {
		if (!isHidden()) {
			app.pushAll();
			render();
			app.popAll();
		}
	}

	public void hide() {
		hidden = true;
	}

	public void show() {
		hidden = false;
	}

	public boolean isHidden() {
		return hidden;
	}

	public boolean isShowing() {
		return !isHidden();
	}

}
