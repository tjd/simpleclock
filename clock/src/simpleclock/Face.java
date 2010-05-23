package simpleclock;

import java.awt.Color;

public class Face extends Sprite {
	private static final float PI = MyPApplet.PI;
	private TickMark minuteTick;
	private TickMark hourTick;

	private CenterPeg centerPeg;
	private OuterRim outerRim;

	boolean hideMinuteTickMarks = false;
	boolean hideHourTickMarks = false;
	boolean hideNumbers = false;

	public Face(MyPApplet app) {
		super(app);
		minuteTick = new TickMark(app, 5, 150, 1, Color.BLACK);
		hourTick = new TickMark(app, 10, 150, 3, Color.BLACK);
		centerPeg = new CenterPeg(app, Color.BLACK, 3);
		outerRim = new OuterRim(app, Color.BLACK, 300, 4);
	}

	public void render() {
		app.pushMatrix();

		outerRim.draw();

		// ticks for minutes
		if (!hideMinuteTickMarks) {
			for (int i = 0; i < 60; ++i) {
				minuteTick.draw(i * 2 * PI / 60f);
			}
		}

		// ticks for hours
		if (!hideHourTickMarks) {
			for (int i = 0; i < 12; ++i) {
				hourTick.draw(i * 2 * PI / 12f);
			}
		}

		// center peg goes on top of the hands to hold them on
		centerPeg.draw();

		// TODO: fix the position of the numbers
		// When the commented-out rotation line below is uncommented,
		// the orientation is okay, but position is off. Position each
		// number by hand?
		// draw numbers
		if (!hideNumbers) {
			app.fill(Color.BLACK);
			for (int i = 0; i < 12; ++i) {
				app.pushMatrix();
				app.rotate((i + 1) * 2 * PI / 12f);
				String num = "" + (i + 1);
				app.translate(-app.textWidth(num) / 2, -120);
				app.pushMatrix();
				// rotate(-i * 2 * PI / 12 - 2 * PI / 12);
				app.text(num, 0, 0);
				app.popMatrix();
				app.popMatrix();
			}
		}
		app.popMatrix();
	}

	public void hideMinuteTickMarks() {
		hideMinuteTickMarks = true;
	}

	public void showMinuteTickMarks() {
		hideMinuteTickMarks = false;
	}

	public void hideHourTickMarks() {
		hideHourTickMarks = true;
	}

	public void showHourTickMarks() {
		hideHourTickMarks = false;
	}

	public void hideNumbers() {
		hideNumbers = true;
	}

	public void showNumbers() {
		hideNumbers = false;
	}

}
