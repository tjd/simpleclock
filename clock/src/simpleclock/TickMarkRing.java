package simpleclock;

import java.awt.Color;

public class TickMarkRing extends Part {
	private int length;
	private int height;
	private int weight;
	private int numTicks;
	private TickMark tickMark;

	public TickMarkRing(MyPApplet app, Color color, int length, int height,
			int weight, int numTicks) {
		super(app, color);
		this.length = length;
		this.weight = weight;
		this.numTicks = numTicks;
		tickMark = new TickMark(app, length, height, weight, color);
	}

	protected void render() {
		for (int i = 0; i < numTicks; ++i) {
			tickMark.draw(i * 2 * PI / numTicks);
		}
	}

}
