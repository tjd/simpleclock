package test;

import processing.core.PApplet;
import processing.core.PFont;

public class DigitalClock extends PApplet {
	PFont font;

	public void setup() {
		size(200, 200);
		font = createFont("Arial", 32);
		textFont(font);
	}

	public void draw() {
		background(255);
		fill(0);
		int s = second(); // from 0 to 59
		int m = minute(); // from 0 to 59
		int h = hour(); // from 0 to 23
		// String time = String.format("%d:%02d:%02d", h, m, s);
		// Date now = new Date();
		// String time = String.format("%tI:%tM:%tS %Tp", now, now, now, now);

		// for each minutes and seconds, add a leading 0 if necessary
		String sec;
		if (s < 10) {
			sec = "0" + s;
		} else {
			sec = "" + s;
		}

		String min;
		if (m < 10) {
			min = "0" + m;
		} else {
			min = "" + m;
		}

		// is it morning?
		String ampm;
		if (h <= 12) {
			ampm = "am";
		} else {
			ampm = "pm";
		}

		// in 12hr format, there is no leading 0 for hours
		String hour;
		if (h > 12) {
			hour = "" + (h - 12);
		} else {
			hour = "" + h;
		}

		// create the time string
		String time = hour + ":" + min + ":" + sec + " " + ampm;

		// display it in the middle of the screen
		text(time, width / 2 - textWidth(time) / 2, height / 2);
	}
}
