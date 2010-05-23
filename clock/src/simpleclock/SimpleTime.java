package simpleclock;

public class SimpleTime {
	private MyPApplet app;
	public int s, m, h;

	public SimpleTime(MyPApplet app) {
		updateToNow();
	}

	public SimpleTime(MyPApplet app, int h, int m, int s) {
		setTime(h, m, s);
	}

	public SimpleTime(MyPApplet app, SimpleTime t) {
		setTime(t.s, t.m, t.h);
	}

	public void updateToNow() {
		setTime(app.hour(), app.minute(), app.second());
	}
	
	public void setTime(int h, int m, int s) {
		this.s = s;
		this.m = m;
		this.h = h;
		if (h >= 12) 
			h -= 12;
		
	}
}
