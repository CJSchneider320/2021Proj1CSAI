package Proj1;

import org.junit.Assert;
import org.junit.Test;

public class TestStopWatch {

/**
 *
 * The following are simple random JUnit test cases... After talking with your
 * instructor, create many, many more that shows that your code
 * is functioning correctly.
 *
 */

//Tests the length of startTime to make sure it is correct

@Test
        public void testStartTimeLength2(){
        StopWatch s = new StopWatch("12:27:400");
        StopWatch s1 = new StopWatch("40");
        StopWatch s2 = new StopWatch("5000:27:400");
        StopWatch s3 = new StopWatch("00:00:000");
        StopWatch s4 = new StopWatch("");
    }

//The next 3 tests check to see if public StopWatch(min, secs, mill) will detect a failure

@Test (expected = IllegalArgumentException.class)
    public void testConstructorParametersMinutes() {
        StopWatch s = new StopWatch(-1,2,3);
    }

@Test (expected = IllegalArgumentException.class)
    public void testConstructorParametersSeconds() {
        StopWatch s = new StopWatch(1, -1, 3);
        StopWatch s1 = new StopWatch(1, 100, 2);
    }

@Test (expected = IllegalArgumentException.class)
    public void testConstructorParametersMilliseconds() {
        StopWatch s = new StopWatch(1,2,-1);
        StopWatch s1 = new StopWatch(1,2,1000);
    }

//The next 3 tests check to see if public StopWatch(min, secs, mill) will not produce a failure

@Test
    public void testConstructorParametersSuccessMinutes() {
        StopWatch s = new StopWatch(1, 2, 3);
        StopWatch s1 =  new StopWatch(0, 2, 3);
    }

@Test
    public void testConstructorParametersSuccessSeconds() {
        StopWatch s = new StopWatch(1, 0, 3);
        StopWatch s1 = new StopWatch(1, 59, 3);
    }

@Test
    public void testConstructorParametersSuccessMilliSeconds() {
        StopWatch s = new StopWatch(1, 2, 0);
        StopWatch s1 =  new StopWatch(1, 2, 999);
    }

@Test
    public void testConstructorNull(){
        StopWatch s = new StopWatch();
    }

	// default constructor test
	@Test
	public void testDefaultConstructor() {
		StopWatch s = new StopWatch();
		Assert.assertTrue(s.getMinutes() == 0);
        Assert.assertTrue(s.getSeconds() == 0);
        Assert.assertTrue(s.getMilliseconds() == 0);
	}

	@Test
	public void testConstructor3Parameters()
	{
		StopWatch s = new StopWatch(2,3,4);
        Assert.assertTrue(s.getMinutes() == 2);
        Assert.assertTrue(s.getSeconds() == 3);
        Assert.assertTrue(s.getMilliseconds() == 4);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3ParametersX()
	{
		StopWatch s = new StopWatch(2,-3,4);
		StopWatch s1 = new StopWatch(-2,3,4);
		StopWatch s2 = new StopWatch(2,3,-4);

	}

	@Test (expected = IllegalArgumentException.class)
	public void testConstructor3e2Parameters() {
		StopWatch s = new StopWatch(12,67,14);
	}

	@Test
	public void testConstructor() {
		StopWatch s = new StopWatch(5,10,300);
        Assert.assertEquals(s.toString(),"5:10:300");

		StopWatch s1 = new StopWatch("20:10:8");
        Assert.assertEquals(s1.toString(),"20:10:008");

		StopWatch s2 = new StopWatch("20:8");
        Assert.assertEquals(s2.toString(),"0:20:008");

		StopWatch s3 = new StopWatch("8");
        Assert.assertEquals(s3.toString(),"0:00:008");

	}

	// There can only be one test here
	// no more lines of code after "new StopWatch("-2");"
	@Test (expected = IllegalArgumentException.class)
	public void testNegSingleInput2() {
		new StopWatch(-2);

	}

	@Test (expected = IllegalArgumentException.class)
	public void testNegDouble1Input() {
		new StopWatch("-59:-23");

	}


	@Test (expected = IllegalArgumentException.class)
	public void testNegDouble2aInput() {
		new StopWatch("2:-2");

	}


	@Test (expected = IllegalArgumentException.class)
	public void testAlphaInput() {
		new StopWatch("a");
	}

	@Test
	public void testAddMethod () {
		StopWatch s1 = new StopWatch(5,59,300);
		s1.add(2000);
        Assert.assertEquals (s1.toString(),"6:01:300");

		s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(2,2,300);
		s1.add(s2);
		System.out.println (s1);
        Assert.assertEquals (s1.toString(),"8:01:600");

		for (int i = 0; i < 15000; i++)
			s1.inc();
		System.out.println (s1);
        Assert.assertEquals (s1.toString(),"8:16:600");
	}


	@Test
	public void testEqual () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(6,01,200);
		StopWatch s3 = new StopWatch(5,50,200);
		StopWatch s4 = new StopWatch(5,59,300);

        Assert.assertFalse(s1.equals(s2));
        Assert.assertTrue (s1.equals(s4));

        Assert.assertTrue (s2.compareTo(s1) > 0);
        Assert.assertTrue (s3.compareTo(s1) < 0);
        Assert.assertTrue (s1.compareTo(s4) == 0);

	}
	@Test
	public void testCompareTo () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(6,01,200);
		StopWatch s3 = new StopWatch(5,50,200);
		StopWatch s4 = new StopWatch(5,59,300);

        Assert.assertFalse(s1.equals(s2));
        Assert.assertTrue (s1.equals(s4));

        Assert.assertTrue (s2.compareTo(s1) > 0);
        Assert.assertTrue (s3.compareTo(s1) < 0);
        Assert.assertTrue (s1.compareTo(s4) == 0);

	}

	@Test
	public void testLoadSave () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(5,59,300);

		s1.save("file1");
		s1 = new StopWatch();  // resets to zero

		s1.load("file1");
        Assert.assertTrue (s1.equals(s2));
	}

	@Test
	public void testMutate () {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(5,59,300);

		StopWatch.setSuspend(true);
		s1.add(1000);
        Assert.assertTrue (s1.equals(s2));
		StopWatch.setSuspend(false);
		}

	@Test
	public void equalsTest() {
		StopWatch s1 = new StopWatch(5,59,300);
		StopWatch s2 = new StopWatch(5,59,300);

        Assert.assertEquals(s1, s2);
	}
}
