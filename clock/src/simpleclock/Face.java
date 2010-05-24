package simpleclock;

import java.awt.Color;

public class Face extends Sprite {

	// private TickMark minuteTick;
	private TickMark hourTick;

	private CenterPeg centerPeg;
	private OuterRim outerRim;
	private Numbers numbers;
	private TickMarkRing minuteTickMarks;
	private TickMarkRing hourTickMarks;

	// boolean hideMinuteTickMarks = false;
	// boolean hideHourTickMarks = false;

	public Face(MyPApplet app) {
		super(app);
		// minuteTick = new TickMark(app, 5, 150, 1, Color.BLACK);
		hourTick = new TickMark(app, 10, 150, 3, Color.BLACK);
		centerPeg = new CenterPeg(app, Color.BLACK, 3);
		outerRim = new OuterRim(app, Color.BLACK, 300, 4);
		numbers = new Numbers(app, Color.BLACK);
		minuteTickMarks = new TickMarkRing(app, Color.BLACK, 5, 150, 1, 60);
		hourTickMarks = new TickMarkRing(app, Color.BLACK, 10, 150, 3, 12);
		// hourTickMarks = new HourTickMarks(app, Color.BLACK);
	}

	public void render() {
		app.pushMatrix();

		outerRim.draw();

		minuteTickMarks.draw();
		hourTickMarks.draw();
		// // ticks for minutes
		// if (!hideMinuteTickMarks) {
		// for (int i = 0; i < 60; ++i) {
		// minuteTick.draw(i * 2 * PI / 60f);
		// }
		// }

		// // ticks for hours
		// if (!hideHourTickMarks) {
		// for (int i = 0; i < 12; ++i) {
		// hourTick.draw(i * 2 * PI / 12f);
		// }
		// }

		centerPeg.draw();
		numbers.draw();

		app.popMatrix();
	}

	// public void hideMinuteTickMarks() {
	// hideMinuteTickMarks = true;
	// }
	//
	// public void showMinuteTickMarks() {
	// hideMinuteTickMarks = false;
	// }

	// public void hideHourTickMarks() {
	// hideHourTickMarks = true;
	// }
	//
	// public void showHourTickMarks() {
	// hideHourTickMarks = false;
	// }

}
