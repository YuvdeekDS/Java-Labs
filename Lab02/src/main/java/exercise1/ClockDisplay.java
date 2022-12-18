package exercise1;

import java.text.DecimalFormat;

/**
 * Class representing attributes and behaviour of a clock.
 * 
 * @author Stella Kazamia
 */
public class ClockDisplay {

	/** Represents the hours (0 to 23). */
	private NumberInfo hours;

	/** Represents the minutes (0 to 59). */
	private NumberInfo minutes;

	/** Represent the which format to use  default 12 hours*/
	
	private boolean is12Hour;
	
	/**
	 * Constructor allowing the hour/minute display.
	 * 
	 */
	public ClockDisplay() {
		super();
		this.hours = new NumberInfo(24);
		this.minutes = new NumberInfo(60);
		this.is12Hour = true; // 12 hours
	}

	public ClockDisplay(boolean is12Hour) {
		super();
		this.hours = new NumberInfo(24);
		this.minutes = new NumberInfo(60);
		this.is12Hour = is12Hour;
	}

	/**
	 * Method to tick the time on by one minute, taking into account the roll over
	 * in hours.
	 */
	public void timeTick() {
		this.minutes.increment();

		if (this.minutes.getValue() == 0) {
			this.hours.increment();
		}
	}

	
	private String getMeridiem()
    {       
		return this.hours.getValue()/12 == 0? "am" :"pm"; 
    }
	/**
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// Return the correct representation.
		DecimalFormat style = new DecimalFormat("00");
		StringBuffer buffer = new StringBuffer();
        
		if(this.is12Hour) {
			int hours = this.hours.getValue();
			hours = hours>12 ? hours -12 : hours;
			buffer.append(hours); // No formatting needed
			buffer.append(":");
			buffer.append(style.format(this.minutes.getValue())+getMeridiem());
		}
		else {
			buffer.append(style.format(this.hours.getValue())); // No formatting needed
			buffer.append(":");
			buffer.append(style.format(this.minutes.getValue()));
		}

		// Alternative - without using StringBuffer
		// return ( style.format(this.hours.getValue()) + ":" +
		// style.format(this.minutes.getValue()) );
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		ClockDisplay clock12 = new ClockDisplay(true);
		ClockDisplay clock24 = new ClockDisplay(false);
		for (int i = 0; i < 200; i++) {
			clock12.timeTick();
		}
		for (int i = 0; i < 821; i++) {
			clock24.timeTick();
		}
		System.out.println( clock12.toString());
		//System.out.println(clock24.toString());
	}
}
