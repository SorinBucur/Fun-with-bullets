package ProcessingManagers;

/**
 * Time object
 */
public class TimeManager {
	private int h,m,s;

	// TODO => implement the body of the class (set class fields, make ways 
	// 			for other classes to work with a TimeManager object)
	
	public int getHour() {
		return h;
	}
	public void setHour(int h) {
		this.h = h;
	}
	public int getMinute() {
		return m;
	}
	public void setMinute(int m) {
		this.m = m;
	}
	public int getSecond() {
		return s;
	}
	public void setSecond(int s) {
		this.s = s;
	}
	
}