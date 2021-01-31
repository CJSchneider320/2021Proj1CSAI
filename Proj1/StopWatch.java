package Proj1;


import java.io.*;
import java.util.Scanner;

/****************************************************************
 ********   class description...
 *
 * THIS IS JUST STARTING CODE, MUCH HAS TO BE CHANGED.
 *
 * @author
 * @version
 */

public class StopWatch  {


	/**
	 * This holds minutes for our stopwatch
	 */
	private int minutes;


	private int seconds;
	private int milliseconds;

	private static boolean suspend = false;

	public StopWatch() {
		minutes = 0;
		seconds = 0;
		milliseconds = 0;
	}

	/******************************************************************
	 *
	 *  A constructor that accepts a string as a parameter with the
	 *  following format: "1:21:300"� where 1 indicates minutes, 21
	 *  indicates seconds,  and 300 indicates milliseconds.  OR
	 *  the format "15:200"� where the 15 indicates seconds, and
	 *  200 indicates milliseconds, OR the format “300” where
	 *  300 indicates milliseconds
	 *
	 * @param startTime is the input string the represents
	 * the starting time
	 * @throws IllegalArgumentException when the input string
	 * does not match the proper format (see description above)
	 */

	public StopWatch(String startTime) {
		if (startTime == null)
			throw new IllegalArgumentException();
		if (startTime == "") {
			this.setMinutes(0);
			this.setSeconds(0);
			this.setMilliseconds(0);
		}

		if (startTime.length() >= 8) {
			int colon = 0;
			startTime = startTime + ":";
			for (int inc = 0; inc < startTime.length(); inc = colon + 1) {
				colon = startTime.indexOf(":", inc);
				if (colon != -1) {
					if (this.minutes == 0) {
						this.minutes = Integer.valueOf(startTime.substring(inc, colon));
						if (minutes < 0)
							throw new IllegalArgumentException("constuctor with 3 params");
					}
					else if (this.seconds == 0) {
						this.seconds = Integer.valueOf(startTime.substring(inc, colon));
						if (seconds < 0 || seconds > 59)
							throw new IllegalArgumentException();
					}
					else {
						this.milliseconds = Integer.valueOf(startTime.substring(inc, colon));
						if (milliseconds < 0 || milliseconds > 999)
							throw new IllegalArgumentException();
					}
				}
			}
		}
		else if (startTime.length() == 6){
			int colon = 0;
			startTime = startTime + ":";
			for (int inc = 0; inc < startTime.length(); inc = colon + 1) {
				colon = startTime.indexOf(":", inc);
				if (colon != -1) {

					if (seconds == 0) {
						this.seconds = Integer.valueOf(startTime.substring(inc, colon));
						if (seconds < 0 || seconds > 59)
							throw new IllegalArgumentException();
					}
					else {
						this.milliseconds = Integer.valueOf(startTime.substring(inc, colon));
						if (milliseconds < 0 || milliseconds > 999)
							throw new IllegalArgumentException();
					}
				}
			}

		}
		else if (startTime.length() > 0){
			this.milliseconds = Integer.valueOf(startTime);
			if (milliseconds < 0 || milliseconds > 999)
				throw new IllegalArgumentException();
		}
		else if (startTime == "") {
			this.setMinutes(0);
			this.setSeconds(0);
			this.setMilliseconds(0);
		}
		else
			throw new IllegalArgumentException();

	}

	public StopWatch(int minutes, int seconds, int milliseconds) {
		if (minutes < 0)
			throw new IllegalArgumentException("constuctor with 3 params");

		if (seconds < 0 || seconds > 59)
			throw new IllegalArgumentException();

		if (milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException();

		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;

	}

	public StopWatch(StopWatch stopWatch) {
		if (stopWatch == null)
			throw new IllegalArgumentException();

		this.minutes = stopWatch.minutes;
		this.seconds = stopWatch.seconds;
		this.milliseconds = stopWatch.milliseconds;
	}

	public StopWatch(int seconds, int milliseconds) {
		if (seconds < 0 || seconds > 59)
			throw new IllegalArgumentException();

		if (milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException();

		this.seconds = seconds;
		this.milliseconds = milliseconds;
	}


	public StopWatch(int milliseconds) {
		if (milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException();

		this.milliseconds = milliseconds;
	}

	public static boolean equals(StopWatch stopWatch1, StopWatch stopWatch2) {
		if(stopWatch1.getMinutes() == stopWatch2.getMinutes())
			if(stopWatch1.getSeconds() == stopWatch2.getSeconds())
				if(stopWatch1.getMilliseconds() == stopWatch2.getMilliseconds())
					return true;

			return false;
	}

	public boolean equals(Object object) {
		if (object != null) {
			if (object instanceof StopWatch) {
				StopWatch temp = (StopWatch) object;
				if (StopWatch.equals(this, temp))
					return true;
			}
		}
	return false;
	}

	public int compareTo(StopWatch other) {
		if (other == null)
			throw new IllegalArgumentException();

		if(this.getMinutes() >= other.getMinutes())
			return 1;
		else if(this.getMinutes() <= other.getMinutes())
			return -1;
		else if(this.getMinutes() == other.getMinutes())
			if(this.getSeconds() >= other.getSeconds())
				return 1;
		    else if(this.getSeconds() <= other.getSeconds())
			    return -1;
			else if(this.getSeconds() == other.getSeconds())
				if(this.getMilliseconds() >= other.getMilliseconds())
					return 1;
				else if(this.getMilliseconds() <= other.getMilliseconds())
					return -1;
				else if(this.getMilliseconds() == other.getMilliseconds())
					return 0;

	return 0;
	}

	private static int convertToMilli (StopWatch stopWatch) {
		if (stopWatch == null)
			throw new IllegalArgumentException();

		int currMilli = 0;
		currMilli += stopWatch.getMinutes() * 60000;
		currMilli += stopWatch.getSeconds() * 1000;
		currMilli += stopWatch.getMilliseconds();
		return currMilli;

	}

	private void convertToStopWatch (int tempMilliseconds) {
		minutes = tempMilliseconds / 60000;
		tempMilliseconds %= 60000;

		seconds = tempMilliseconds / 1000;
		tempMilliseconds %= 1000;
		milliseconds = tempMilliseconds;
	}

	public void add(int milliseconds) {
		if (!suspend) {
			for (int i = 0; i < milliseconds; i++) {
				this.inc();
			}
		}
	}

	public void sub(int milliseconds) {
		if (!suspend) {
			for (int i = 0; i < milliseconds; i++) {
				this.dec();
			}
		}

	}

	public void add(StopWatch stopWatch) {
		int tempMilli1 = convertToMilli(stopWatch);
		int tempMilli2 = convertToMilli(this);
		tempMilli1 += tempMilli2;
		this.convertToStopWatch(tempMilli1);
	}

	public void sub(StopWatch stopWatch) {
		int tempMilli1 = convertToMilli(stopWatch);
		int tempMilli2 = convertToMilli(this);
		tempMilli1 -= tempMilli2;
		if (tempMilli1 < 0)
			throw new IllegalArgumentException();
		else
			this.convertToStopWatch(tempMilli1);
	}

	public void inc() {
		int tempMilli = this.getMilliseconds();
		tempMilli += 1;
		if (tempMilli >= 1000) {
			int tempSec = this.getSeconds();
			tempSec += 1;
			tempMilli = 0;
			this.setMilliseconds(tempMilli);
			if (tempSec >= 60) {
				int tempMin = this.getMinutes();
				tempMin += 1;
				tempSec = 0;
				this.setSeconds(tempSec);
				this.setMinutes(tempMin);
			}
			else
				this.setSeconds(tempSec);
		}
		else
			this.setMilliseconds(tempMilli);


	}

	public void dec() {
		if(this.getMilliseconds() == 0) {
			if(this.getSeconds() == 0) {
				if(this.getMinutes() == 0) {
					throw new IllegalArgumentException();
				}
				else {
					int tempMin = this.getMinutes();
					tempMin -= 1;
					this.setMinutes(tempMin);
					this.setSeconds(59);
					this.setMilliseconds(999);
				}
			}
			else {
				int tempSec = this.getSeconds();
				tempSec -= 1;
				this.setSeconds(tempSec);
				this.setMilliseconds(999);

			}
		}
		else {
			int tempMilli = this.getMilliseconds();
			tempMilli -= 1;
			this.setMilliseconds(tempMilli);
		}
	}

	public String toString() {
		int tempMin = this.getMinutes();
		int tempSec = this.getSeconds();
		int tempMilli = this.getMilliseconds();

		String tempWatch = tempMin + ":";
		tempWatch += String.format("%01d", tempSec) + ":";
		tempWatch += String.format("%02d",tempMilli);

		return tempWatch; // place holder

	}

	public void save(String filename) {
		if (filename == null)
			throw new IllegalArgumentException();

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));

			//TO DO: finish - write fields to file

			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public void load(String filename)  {
		if (filename == null)
			throw new IllegalArgumentException();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename));

			//TO DO: read fields into instance variables

		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException();
		}

	}

	public static void setSuspend(boolean suspend) {
		//TO DO: finish logic
	}

	public static boolean isSuspended() {
		//TO DO: finish logic
		return false; // place holder
	}

	public int getMinutes() {
		return this.minutes;

	}

	public void setMinutes(int minutes) {
		if (minutes < 0)
			throw new IllegalArgumentException();
		else
			this.minutes = minutes;
	}

	public int getSeconds() {
		return this.seconds;

	}

	public void setSeconds(int seconds) {
		if (seconds < 0 || seconds > 59)
			throw new IllegalArgumentException();
		else
			this.seconds = seconds;
	}

	public int getMilliseconds() {
		return this.milliseconds;

	}

	public void setMilliseconds(int milliseconds) {
		if (milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException();
		else
			this.milliseconds = milliseconds;
	}

}