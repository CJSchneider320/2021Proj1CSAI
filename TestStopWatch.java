package Proj1;

public class TestStopWatch {

/**
 *
 * The following are simple random JUnit test cases... After talking with your
 * instructor, create many, many more that shows that your code
 * is functioning correctly.
 *
 */

//	// default constructor test
//	@Test
//	public void testDefaultConstructor() {
//		StopWatch s = new StopWatch();
//		assertTrue(s.getMinutes() == 0);
//		assertTrue(s.getSeconds() == 0);
//		assertTrue(s.getMilliseconds() == 0);
//	}
//
//	@Test
//	public void testConstructor3Parameters()
//	{
//		StopWatch s = new StopWatch(2,3,4);
//		assertTrue(s.getMinutes() == 2);
//		assertTrue(s.getSeconds() == 3);
//		assertTrue(s.getMilliseconds() == 4);
//	}
//
//	@Test (expected = IllegalArgumentException.class)
//	public void testConstructor3ParametersX()
//	{
//		StopWatch s = new StopWatch(2,-3,4);
//		StopWatch s1 = new StopWatch(-2,3,4);
//		StopWatch s2 = new StopWatch(2,3,-4);
//
//	}
//
//	@Test (expected = IllegalArgumentException.class)
//	public void testConstructor3e2Parameters() {
//		StopWatch s = new StopWatch(12,67,14);
//	}
//
//	@Test
//	public void testConstructor() {
//		StopWatch s = new StopWatch(5,10,300);
//		assertEquals(s.toString(),"5:10:300");
//
//		s = new StopWatch("20:10:8");
//		assertEquals(s.toString(),"20:10:008");
//
//		s = new StopWatch("20:8");
//		assertEquals(s.toString(),"0:20:008");
//
//		s = new StopWatch("8");
//		assertEquals(s.toString(),"0:00:008");
//
//	}
//
//	// There can only be one test here
//	// no more lines of code after "new StopWatch("-2");"
//	@Test (expected = IllegalArgumentException.class)
//	public void testNegSingleInput2() {
//		new StopWatch(-2);
//
//	}
//
//	@Test (expected = IllegalArgumentException.class)
//	public void testNegDouble1Input() {
//		new StopWatch("-59:-23");
//
//	}
//
//
//	@Test (expected = IllegalArgumentException.class)
//	public void testNegDouble2aInput() {
//		new StopWatch("2:-2");
//
//	}
//
//
//	@Test (expected = IllegalArgumentException.class)
//	public void testAlphaInput() {
//		new StopWatch("a");
//	}
//
//	@Test
//	public void testAddMethod () {
//		StopWatch s1 = new StopWatch(5,59,300);
//		s1.add(2000);
//		assertEquals (s1.toString(),"6:01:300");
//
//		s1 = new StopWatch(5,59,300);
//		StopWatch s2 = new StopWatch(2,2,300);
//		s1.add(s2);
//		System.out.println (s1);
//		assertEquals (s1.toString(),"8:01:600");
//
//		for (int i = 0; i < 15000; i++)
//			s1.inc();
//		System.out.println (s1);
//		assertEquals (s1.toString(),"8:16:600");
//	}
//
//
//	@Test
//	public void testEqual () {
//		StopWatch s1 = new StopWatch(5,59,300);
//		StopWatch s2 = new StopWatch(6,01,200);
//		StopWatch s3 = new StopWatch(5,50,200);
//		StopWatch s4 = new StopWatch(5,59,300);
//
//		assertFalse(s1.equals(s2));
//		assertTrue (s1.equals(s4));
//
//		assertTrue (s2.compareTo(s1) > 0);
//		assertTrue (s3.compareTo(s1) < 0);
//		assertTrue (s1.compareTo(s4) == 0);
//
//	}
//	@Test
//	public void testCompareTo () {
//		StopWatch s1 = new StopWatch(5,59,300);
//		StopWatch s2 = new StopWatch(6,01,200);
//		StopWatch s3 = new StopWatch(5,50,200);
//		StopWatch s4 = new StopWatch(5,59,300);
//
//		assertFalse(s1.equals(s2));
//		assertTrue (s1.equals(s4));
//
//		assertTrue (s2.compareTo(s1) > 0);
//		assertTrue (s3.compareTo(s1) < 0);
//		assertTrue (s1.compareTo(s4) == 0);
//
//	}
//
//	@Test
//	public void testLoadSave () {
//		StopWatch s1 = new StopWatch(5,59,300);
//		StopWatch s2 = new StopWatch(5,59,300);
//
//		s1.save("file1");
//		s1 = new StopWatch();  // resets to zero
//
//		s1.load("file1");
//		assertTrue (s1.equals(s2));
//	}
//
//	@Test
//	public void testMutate () {
//		StopWatch s1 = new StopWatch(5,59,300);
//		StopWatch s2 = new StopWatch(5,59,300);
//
//		StopWatch.setSuspend(true);
//		s1.add(1000);
//		assertTrue (s1.equals(s2));
//		StopWatch.setSuspend(false);
//		}
//
//	@Test
//	public void equalsTest() {
//		StopWatch s1 = new StopWatch(5,59,300);
//		StopWatch s2 = new StopWatch(5,59,300);
//
//		assertEquals(s1, s2);
//	}
}
