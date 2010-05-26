package parameterClock;

import java.awt.Color;
import util.MyPApplet;

abstract public class WeightedPart extends BasicPart {
	int weight;

	public WeightedPart(MyPApplet app, Color color, int weight, boolean hidden) {
		super(app, color, hidden);
		assertTrue(weight > 0);
		this.weight = weight;
	}
	
	public WeightedPart(MyPApplet app, Color color, int weight) {
		this(app, color, weight, false);
	}

}
