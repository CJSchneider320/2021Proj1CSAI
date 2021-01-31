package Proj1;


import java.io.*;
import java.util.Scanner;

/************************************************************************
 * The StopWatch.java class includes all of the methods that are needed
 * to run a stopwatch. This class can not be run, only the
 * StopWatchGUI.java class may be run.
 *
 *
 * @author Cameron Schneider, Alex Isbrecht
 * @version 1/31/21
 */

public class StopWatch  {


	/**
	 * This holds minutes for our stopwatch
	 */
	private int minutes;

	/**
	 * This holds seconds for our stopwatch
	 */
	private int seconds;

	/**
	 * This holds milliseconds for our stopwatch
	 */
	private int milliseconds;

	/**
	 * This holds true if the stopwatches are suspended and false if
	 * they are not
	 */
	private static boolean suspend = false;

	/******************************************************************
	 *
	 *Default constructor that sets the StopWatch to zero
	 *
	 */

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
	 *
	 */

	public StopWatch(String startTime) {
		if (startTime == null)
			throw new IllegalArgumentException();


		int colonCount = 0;
		for (int i = 0; i < startTime.length(); i++) {
			if(startTime.charAt(i) == ':')
				colonCount++;
		}
		if (colonCount == 2) {
			int colon;
			startTime = startTime + ":";
			for (int inc = 0; inc < startTime.length(); inc = colon + 1) {
				colon = startTime.indexOf(":", inc);
				if (colon != -1) {
					if (this.minutes == 0) {
						this.minutes = Integer.parseInt(startTime.substring(inc, colon));
						if (minutes < 0)
							throw new IllegalArgumentException("constructor with 3 params");
					}
					else if (this.seconds == 0) {
						this.seconds = Integer.parseInt(startTime.substring(inc, colon));
						if (seconds < 0 || seconds > 59)
							throw new IllegalArgumentException();
					}
					else {
						this.milliseconds = Integer.parseInt(startTime.substring(inc, colon));
						if (milliseconds < 0 || milliseconds > 999)
							throw new IllegalArgumentException();
					}
				}
			}
		}
		else if (colonCount == 1){
			int colon;
			startTime = startTime + ":";
			for (int inc = 0; inc < startTime.length(); inc = colon + 1) {
				colon = startTime.indexOf(":", inc);
				if (colon != -1) {

					if (seconds == 0) {
						this.seconds = Integer.parseInt(startTime.substring(inc, colon));
						if (seconds < 0 || seconds > 59)
							throw new IllegalArgumentException();
					}
					else {
						this.milliseconds = Integer.parseInt(startTime.substring(inc, colon));
						if (milliseconds < 0 || milliseconds > 999)
							throw new IllegalArgumentException();
					}
				}
			}

		}
		else if (colonCount == 0 && !startTime.equals("")){
			this.milliseconds = Integer.parseInt(startTime);
			if (milliseconds < 0 || milliseconds > 999)
				throw new IllegalArgumentException();
		}
		else if (startTime.equals("")) {
			this.setMinutes(0);
			this.setSeconds(0);
			this.setMilliseconds(0);
		}
		else
			throw new IllegalArgumentException();

	}

	/******************************************************************
	 *
 	 * A constructor that initializes the instance variables with the
	 * provided values
	 *
	 * @param minutes is the amount of minutes to be in the stopwatch
	 * @param seconds is the amount of seconds to be in the stopwatch
	 * @param milliseconds is the amount of milliseconds to be in
	 *                     the stopwatch
	 *
	 * @throws IllegalArgumentException when values are outside the
	 * possible range (all negatives, seconds greater than 59,
	 * milliseconds greater than 999)
	 *
	 */

	public StopWatch(int minutes, int seconds, int milliseconds) {
		if (minutes < 0)
			throw new IllegalArgumentException("constructor with 3 params");

		if (seconds < 0 || seconds > 59)
			throw new IllegalArgumentException();

		if (milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException();

		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;

	}

	/******************************************************************
	 *
	 * A constructor that will set the initialize the instance
	 * variables to be the same as the instance variables from another
	 * stopwatch
	 *
	 * @param stopWatch is the stopwatch that will have its instance
	 *                  variables copied over to the new stopwatch
	 *
	 * @throws IllegalArgumentException if the stopwatch passed in
	 * equals null
	 *
	 */

	public StopWatch(StopWatch stopWatch) {
		if (stopWatch == null)
			throw new IllegalArgumentException();

		this.minutes = stopWatch.minutes;
		this.seconds = stopWatch.seconds;
		this.milliseconds = stopWatch.milliseconds;
	}

	/******************************************************************
	 *
	 * A constructor that initializes the instance variables with the
	 * provided values
	 *
	 * @param seconds is the amount of seconds to be in the stopwatch
	 * @param milliseconds is the amount of milliseconds to be in
	 *                     the stopwatch
	 *
	 * @throws IllegalArgumentException when values are outside the
	 * possible range (all negatives, seconds greater than 59,
	 * milliseconds greater than 999)
	 *
	 */

	public StopWatch(int seconds, int milliseconds) {
		if (seconds < 0 || seconds > 59)
			throw new IllegalArgumentException();

		if (milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException();

		this.seconds = seconds;
		this.milliseconds = milliseconds;
	}

	/******************************************************************
	 *
	 * A constructor that initializes the instance variables with the
	 * provided value
	 *
	 * @param milliseconds is the amount of milliseconds to be in
	 *                     the stopwatch
	 *
	 * @throws IllegalArgumentException when values are outside the
	 * possible range (all negatives, milliseconds greater than
	 * 999)
	 *
	 */

	public StopWatch(int milliseconds) {
		if (milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException();

		this.milliseconds = milliseconds;
	}

	/******************************************************************
	 *
	 * A static method that returns true if StopWatch object stopwatch1
	 * is exactly the same as StopWatch object stopWatch2.
	 *
	 * @param stopWatch1 is one of the two stopwatches that are used to
	 *                   check equality
	 * @param stopWatch2 is the other stopwatch that is used to check
	 *                   equality
	 *
	 * @throws IllegalArgumentException if one or both of the
	 * stopwatches is null
	 *
	 */

	public static boolean equals(StopWatch stopWatch1, StopWatch stopWatch2) {
		if (stopWatch1 == null || stopWatch2 == null)
			throw new IllegalArgumentException();
		if(stopWatch1.getMinutes() == stopWatch2.getMinutes())
			if(stopWatch1.getSeconds() == stopWatch2.getSeconds())
				if(stopWatch1.getMilliseconds() == stopWatch2.getMilliseconds())
					return true;

			return false;
	}

	/******************************************************************
	 * A method that returns true if “this” StopWatch object is exactly
	 * the same (minutes, seconds, milliseconds) as the other StopWatch
	 * object
	 *
	 * @param object is the object whose equality is checked with the
	 *               main StopWatch
	 *
	 */

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

	/******************************************************************
	 *
	 * A method that returns 1 if “this” StopWatch object is greater
	 * than the other StopWatch object; returns -1 if the “this”
	 * StopWatch object is less than the other StopWatch; returns 0 if
	 * the “this” StopWatch object is equal to the other StopWatch
	 * object
	 *
	 * @param other the StopWatch that is being compared to the main
	 *              StopWatch
	 *
	 * @throws IllegalArgumentException if other is equal to null
	 *
	 */

	public int compareTo(StopWatch other) {
		if (other == null)
			throw new IllegalArgumentException();

		if(this.getMinutes() > other.getMinutes())
			return 1;
		else if(this.getMinutes() < other.getMinutes())
			return -1;
		else if(this.getMinutes() == other.getMinutes())
			if(this.getSeconds() > other.getSeconds())
				return 1;
		    else if(this.getSeconds() < other.getSeconds())
			    return -1;
			else if(this.getSeconds() == other.getSeconds())
				if(this.getMilliseconds() > other.getMilliseconds())
					return 1;
				else if(this.getMilliseconds() < other.getMilliseconds())
					return -1;
				else if(this.getMilliseconds() == other.getMilliseconds())
					return 0;

	return 0;
	}

	/******************************************************************
	 *
	 * A method that takes the minutes, seconds, and milliseconds of a
	 * StopWatch and converts these values into milliseconds, and then
	 * returns it
	 *
	 * @param stopWatch is the StopWatch that is being converted to
	 *                  milliseconds
	 *
	 * @throws IllegalArgumentException if stopWatch is equal to null
	 *
	 */

	private static int convertToMilli (StopWatch stopWatch) {
		if (stopWatch == null)
			throw new IllegalArgumentException();

		int currMilli = 0;
		currMilli += stopWatch.getMinutes() * 60000;
		currMilli += stopWatch.getSeconds() * 1000;
		currMilli += stopWatch.getMilliseconds();
		return currMilli;

	}

	/******************************************************************
	 *
	 * A method that takes a millisecond value from a StopWatch and
	 * puts it back into minutes, seconds, and milliseconds
	 *
	 * @param tempMilliseconds is the amount of milliseconds that are
	 *                         being converted to the rest of the
	 *                         values
	 *
	 * @throws IllegalArgumentException when the amount of milliseconds
	 * passed in is negative
	 *
	 */

	private void convertToStopWatch (int tempMilliseconds) {
		if (tempMilliseconds < 0)
			throw new IllegalArgumentException();
		minutes = tempMilliseconds / 60000;
		tempMilliseconds %= 60000;

		seconds = tempMilliseconds / 1000;
		tempMilliseconds %= 1000;
		milliseconds = tempMilliseconds;
	}

	/******************************************************************
	 *
	 * A method that adds the number of milliseconds to “this”
	 * StopWatch object.
	 *
	 * @param milliseconds is the amount of milliseconds to be added to
	 *                     the StopWatch
	 *
	 * @throws IllegalArgumentException if the amount of milliseconds
	 * passed in is negative
	 *
	 */

	public void add(int milliseconds) {
		if (!suspend) {
			if (milliseconds < 0)
				throw new IllegalArgumentException();
			for (int i = 0; i < milliseconds; i++) {
				this.inc();
			}
		}
	}

	/******************************************************************
	 *
	 * A method that subtracts the number of milliseconds to “this”
	 * StopWatch object.
	 *
	 * @param milliseconds is the amount of milliseconds to be
	 *                     subtracted from the StopWatch
	 *
	 * @throws IllegalArgumentException if the amount of milliseconds
	 * passed in is negative
	 */

	public void sub(int milliseconds) {
		if (!suspend) {
			if (milliseconds < 0)
				throw new IllegalArgumentException();
			for (int i = 0; i < milliseconds; i++) {
				this.dec();
			}
		}

	}

	/******************************************************************
	 *
	 * A method that adds StopWatch other to the “this” StopWatch
	 *
	 * @param stopWatch is the StopWatch that is being added to the
	 *                  main StopWatch
	 *
	 * @throws IllegalArgumentException if the StopWatch passed in is
	 * equal to null
	 *
	 */

	public void add(StopWatch stopWatch) {
		if(!suspend) {
			if (stopWatch == null)
				throw new IllegalArgumentException();
			int tempMilli1 = convertToMilli(stopWatch);
			int tempMilli2 = convertToMilli(this);
			tempMilli1 += tempMilli2;
			this.convertToStopWatch(tempMilli1);
		}
	}

	/******************************************************************
	 *
	 * A method that subtracts StopWatch other from the “this”
	 * StopWatch
	 *
	 * @param stopWatch is the StopWatch that is being subtracted to
	 *                  the main StopWatch
	 *
     * @throws IllegalArgumentException if the StopWatch passed in is
	 * equal to null
	 */

	public void sub(StopWatch stopWatch) {
		if(!suspend) {
			if (stopWatch == null)
				throw new IllegalArgumentException();
			int tempMilli1 = convertToMilli(stopWatch);
			int tempMilli2 = convertToMilli(this);
			tempMilli1 -= tempMilli2;
			if (tempMilli1 < 0)
				throw new IllegalArgumentException();
			else
				this.convertToStopWatch(tempMilli1);
		}
	}

	/******************************************************************
	 *
	 * A method that increments the “this” StopWatch by 1 millisecond.
	 * Will not run if the suspend is true
	 *
	 */

	public void inc() {
		if (!suspend) {
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
				} else
					this.setSeconds(tempSec);
			} else
				this.setMilliseconds(tempMilli);

		}
	}

	/******************************************************************
	 *
	 * A method that decrements the “this” StopWatch by 1 millisecond.
	 * Will not run if the suspend is true
	 *
	 */

	public void dec() {
		if (!suspend) {
			if (this.getMilliseconds() == 0) {
				if (this.getSeconds() == 0) {
					if (this.getMinutes() == 0) {
						throw new IllegalArgumentException();
					} else {
						int tempMin = this.getMinutes();
						tempMin -= 1;
						this.setMinutes(tempMin);
						this.setSeconds(59);
						this.setMilliseconds(999);
					}
				} else {
					int tempSec = this.getSeconds();
					tempSec -= 1;
					this.setSeconds(tempSec);
					this.setMilliseconds(999);

				}
			} else {
				int tempMilli = this.getMilliseconds();
				tempMilli -= 1;
				this.setMilliseconds(tempMilli);
			}
		}
	}

	/******************************************************************
	 *
	 * Method that returns a string that represents a StopWatch with
	 * the following format:  “1:06:010”.  Display the minutes as is;
	 * if seconds < 10 then display with a leading “0”, and always
	 * display milliseconds with 3 digits.
	 *
	 */

	public String toString() {
		int tempMin = this.getMinutes();
		int tempSec = this.getSeconds();
		int tempMilli = this.getMilliseconds();

		String tempWatch = tempMin + ":";
		tempWatch += String.format("%02d", tempSec) + ":";
		tempWatch += String.format("%03d",tempMilli);

		return tempWatch; // place holder

	}

	/******************************************************************
	 *
	 * A method that saves the “this” StopWatch to a file.
	 *
	 * @param filename is the name of the file being written to
	 *
	 * @throws IllegalArgumentException when the filename passed in is
	 * equal to null
	 */

	public void save(String filename) {
		if (filename == null)
			throw new IllegalArgumentException();

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename + ".txt")));

			out.println(this.getMinutes() + " " + this.getSeconds() + " " + this.getMilliseconds());

			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/******************************************************************
	 *
	 * A method that loads the “this” StopWatch to a file.
	 *
	 * @param filename is the name of the file being written to
	 *
	 * @throws IllegalArgumentException when the filename passed in is
	 * equal to null
	 *
	 */

	public void load(String filename)  {
		if (filename == null)
			throw new IllegalArgumentException();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename + ".txt"));
			this.minutes = scanner.nextInt();
			this.seconds = scanner.nextInt();
			this.milliseconds = scanner.nextInt();


		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException();
		}

	}

	/******************************************************************
	 * A method that turns on/off all StopWatch objects from mutating
	 *
	 * @param sus is the desired suspension status (true/false)
	 *
	 */

	public static void setSuspend(boolean sus) {
		suspend = sus;
	}

	/******************************************************************
	 *
	 *  A method that returns the suspension status
	 *
	 */

	public static boolean isSuspended() {
		if (suspend = true)
			return true;

		return false;
	}

	/******************************************************************
	 *
	 * A method that returns the amount of minutes in a StopWatch
	 *
	 */

	public int getMinutes() {
		return this.minutes;

	}

	/******************************************************************
	 *
	 * A method that sets the number of minutes to a StopWatch
	 *
	 * @param minutes is the amount of minutes to be set to
	 *
	 * @throws IllegalArgumentException when the amount of minutes is
	 * negative
	 *
	 */

	public void setMinutes(int minutes) {
		if (minutes < 0)
			throw new IllegalArgumentException();
		else
			this.minutes = minutes;
	}

	/******************************************************************
	 *
	 * A method that returns the amount of seconds in a StopWatch
	 *
	 */

	public int getSeconds() {
		return this.seconds;

	}

	/******************************************************************
	 *
	 * A method that sets the number of seconds to a StopWatch
	 *
	 * @param seconds is the amount of seconds to be set to
	 *
	 * @throws IllegalArgumentException when the amount of seconds is
	 * negative
	 *
	 */

	public void setSeconds(int seconds) {
		if (seconds < 0 || seconds > 59)
			throw new IllegalArgumentException();
		else
			this.seconds = seconds;
	}

	/******************************************************************
	 *
	 * A method that returns the amount of milliseconds in a StopWatch
	 *
	 */

	public int getMilliseconds() {
		return this.milliseconds;

	}

	/******************************************************************
	 *
	 * A method that sets the number of milliseconds to a StopWatch
	 *
	 * @param milliseconds is the amount of milliseconds to be set to
	 *
	 * @throws IllegalArgumentException when the amount of milliseconds
	 * is negative
	 *
	 */

	public void setMilliseconds(int milliseconds) {
		if (milliseconds < 0 || milliseconds > 999)
			throw new IllegalArgumentException();
		else
			this.milliseconds = milliseconds;
	}

}