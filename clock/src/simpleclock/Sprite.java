package simpleclock;

import java.awt.Color;

abstract public class Sprite extends Tester {
	protected MyPApplet app;
	protected Color color;
	private boolean hidden;

	public Sprite(MyPApplet app) {
		this(app, Color.BLACK, false);
	}

	public Sprite(MyPApplet app, Color color) {
		this(app, color, false);
	}

	public Sprite(MyPApplet app, Color color, boolean hidden) {
		this.app = app;
		this.color = color;
		this.hidden = hidden;
	}

	protected abstract void render();

	final public void draw() {
		if (!isHidden()) {
			render();
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
