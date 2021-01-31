package Proj1;

import org.junit.Assert;
import org.junit.Test;

public class TestStopWatch {

    /**
     * The following are simple random JUnit test cases... After talking with your
     * instructor, create many, many more that shows that your code
     * is functioning correctly.
     */

//Tests the length of startTime to make sure it is correct
    @Test(expected = IllegalArgumentException.class)
    public void testStartTimeLength() {
        StopWatch s = new StopWatch("4000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartTimeLength2() {
        StopWatch s = new StopWatch("400:400");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartTimeLength3() {
        StopWatch s = new StopWatch(":50:27:400");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartTimeLength4() {
        StopWatch s = new StopWatch(":27:400");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartTimeLength5() {
        StopWatch s = new StopWatch("50::400");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartTimeLength6() {
        StopWatch s = new StopWatch("50:27:");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartTimeLength7() {
        StopWatch s = new StopWatch(":27");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartTimeLength8() {
        StopWatch s7 = new StopWatch("50:");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartTimeLength9() {
        StopWatch s7 = new StopWatch("-12:27:400");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartTimeLength10() {
        StopWatch s7 = new StopWatch("12:-27:400");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartTimeLength11() {
        StopWatch s7 = new StopWatch("12:27:-400");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartTimeLength12() {
        StopWatch s7 = new StopWatch((StopWatch) null);
    }

    @Test
    public void testStartTimeLengthCorrect() {
        StopWatch s = new StopWatch("12:27:400");
        Assert.assertEquals(12, s.getMinutes());
        Assert.assertEquals(27, s.getSeconds());
        Assert.assertEquals(400, s.getMilliseconds());

        StopWatch s1 = new StopWatch("40");
        Assert.assertEquals(0, s1.getMinutes());
        Assert.assertEquals(0, s1.getSeconds());
        Assert.assertEquals(40, s1.getMilliseconds());

        StopWatch s2 = new StopWatch("5000:50:400");
        Assert.assertEquals(s2.getMinutes(), 5000);
        Assert.assertEquals(50, s2.getSeconds());
        Assert.assertEquals(400, s2.getMilliseconds());

        StopWatch s3 = new StopWatch("00:00:000");
        Assert.assertEquals(0, s3.getMinutes());
        Assert.assertEquals(0, s3.getSeconds());
        Assert.assertEquals(0, s3.getMilliseconds());

        StopWatch s4 = new StopWatch("");
        Assert.assertEquals(0, s4.getMinutes());
        Assert.assertEquals(0, s4.getSeconds());
        Assert.assertEquals(0, s4.getMilliseconds());
    }

//The next 3 tests check to see if public StopWatch(min, secs, mill) will detect a failure

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThreeParametersMinutes() {
        StopWatch s = new StopWatch(-1, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThreeParametersSeconds() {
        StopWatch s = new StopWatch(1, -1, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThreeParametersSeconds1() {
        StopWatch s1 = new StopWatch(1, 100, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThreeParametersMilliseconds() {
        StopWatch s = new StopWatch(1, 2, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThreeParametersMilliseconds1() {
        StopWatch s1 = new StopWatch(1, 2, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorTwoParametersMilliseconds() {
        StopWatch s1 = new StopWatch(2, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorTwoParametersMilliseconds1() {
        StopWatch s1 = new StopWatch(2, -500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorTwoParametersSeconds() {
        StopWatch s1 = new StopWatch(70, 200);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorTwoParameterSeconds1() {
        StopWatch s1 = new StopWatch(-2, 200);
    }

    @Test
    public void testConstructorTwoParameters() {
        StopWatch s = new StopWatch(2, 3);
        Assert.assertEquals(0, s.getMinutes());
        Assert.assertEquals(2, s.getSeconds());
        Assert.assertEquals(3, s.getMilliseconds());
    }
//The next 3 tests check to see if public StopWatch(min, secs, mill) will not produce a failure

    @Test
    public void testConstructorParametersSuccessMinutes() {
        StopWatch s = new StopWatch(1, 2, 3);
        Assert.assertEquals(1, s.getMinutes());
        Assert.assertEquals(2, s.getSeconds());
        Assert.assertEquals(3, s.getMilliseconds());

        StopWatch s1 = new StopWatch(0, 2, 3);
        Assert.assertEquals(0, s1.getMinutes());
        Assert.assertEquals(2, s1.getSeconds());
        Assert.assertEquals(3, s1.getMilliseconds());
    }

    @Test
    public void testConstructorParametersSuccessSeconds() {
        StopWatch s = new StopWatch(1, 0, 3);
        Assert.assertEquals(1, s.getMinutes());
        Assert.assertEquals(0, s.getSeconds());
        Assert.assertEquals(3, s.getMilliseconds());

        StopWatch s1 = new StopWatch(1, 59, 3);
        Assert.assertEquals(1, s1.getMinutes());
        Assert.assertEquals(59, s1.getSeconds());
        Assert.assertEquals(3, s1.getMilliseconds());
    }

    @Test
    public void testConstructorParametersSuccessMilliSeconds() {
        StopWatch s = new StopWatch(1, 2, 0);
        StopWatch s1 = new StopWatch(1, 2, 999);
    }

    @Test
    public void testConstructorNull() {
        StopWatch s = new StopWatch();
        Assert.assertEquals(0, s.getMinutes());
        Assert.assertEquals(0, s.getSeconds());
        Assert.assertEquals(0, s.getMilliseconds());
    }

    @Test
    public void testDefaultConstructor() {
        StopWatch s = new StopWatch();
        Assert.assertEquals(0, s.getMinutes());
        Assert.assertEquals(0, s.getSeconds());
        Assert.assertEquals(0, s.getMilliseconds());
    }

    @Test
    public void testConstructor3Parameters() {
        StopWatch s = new StopWatch(2, 3, 4);
        Assert.assertEquals(2, s.getMinutes());
        Assert.assertEquals(3, s.getSeconds());
        Assert.assertEquals(4, s.getMilliseconds());
    }

    @Test
    public void testConstructor() {
        StopWatch s = new StopWatch(5, 10, 300);
        Assert.assertEquals(5, s.getMinutes());
        Assert.assertEquals(10, s.getSeconds());
        Assert.assertEquals(300, s.getMilliseconds());

        StopWatch s1 = new StopWatch("20:10:8");
        Assert.assertEquals(20, s1.getMinutes());
        Assert.assertEquals(10, s1.getSeconds());
        Assert.assertEquals(8, s1.getMilliseconds());

        StopWatch s2 = new StopWatch("20:8");
        Assert.assertEquals(0, s2.getMinutes());
        Assert.assertEquals(20, s2.getSeconds());
        Assert.assertEquals(8, s2.getMilliseconds());

        StopWatch s3 = new StopWatch("8");
        Assert.assertEquals(0, s3.getMinutes());
        Assert.assertEquals(0, s3.getSeconds());
        Assert.assertEquals(8, s3.getMilliseconds());

    }

    // There can only be one test here
    // no more lines of code after "new StopWatch("-2");"
    @Test(expected = IllegalArgumentException.class)
    public void testNegSingleInput2() {
        new StopWatch(-2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegDouble1Input() {
        new StopWatch("-59:-23");

    }


    @Test(expected = IllegalArgumentException.class)
    public void testNegDouble2aInput() {
        new StopWatch("2:-2");

    }


    @Test(expected = IllegalArgumentException.class)
    public void testAlphaInput() {
        new StopWatch("a");
    }

    @Test
    public void testAddMethod() {
        StopWatch.setSuspend(false);
        StopWatch s1 = new StopWatch(5, 59, 300);
        s1.add(2000);
        Assert.assertEquals(s1.toString(), "6:01:300");

        s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(2, 2, 300);
        s1.add(s2);
        System.out.println(s1);
        Assert.assertEquals(s1.toString(), "8:01:600");

        for (int i = 0; i < 15000; i++)
            s1.inc();
        System.out.println(s1);
        Assert.assertEquals(s1.toString(), "8:16:600");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNeg() {
        StopWatch.setSuspend(false);
        StopWatch s1 = new StopWatch(5, 59, 300);
        s1.add(-2000);

    }

    @Test
    public void testSubMethod() {
        StopWatch.setSuspend(false);
        StopWatch s1 = new StopWatch(5, 59, 300);
        s1.sub(2000);
        Assert.assertEquals(s1.toString(), "5:57:300");

        s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(2, 2, 300);
        s1.sub(s2);
        System.out.println(s1);
        Assert.assertEquals(s1.toString(), "3:57:000");

        for (int i = 0; i < 15000; i++)
            s1.dec();
        System.out.println(s1);
        Assert.assertEquals(s1.toString(), "3:42:000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubWithNeg() {
        StopWatch.setSuspend(false);
        StopWatch s1 = new StopWatch(5, 59, 300);
        s1.sub(-2000);
    }

    @Test
    public void testAddNumWithSus() {
        StopWatch.setSuspend(true);
        StopWatch s = new StopWatch(5, 59, 300);
        s.add(500);
        Assert.assertEquals(s.toString(), "5:59:300");

    }

    @Test
    public void testSubNumWithSus() {
        StopWatch.setSuspend(true);
        StopWatch s = new StopWatch(5, 59, 300);
        s.sub(500);
        Assert.assertEquals(s.toString(), "5:59:300");

    }
    @Test
    public void testAddSWWithSus() {
        StopWatch.setSuspend(true);
        StopWatch s = new StopWatch(5, 59, 300);
        StopWatch s1 = new StopWatch(5, 59, 300);
        s.add(s1);
        Assert.assertEquals(s.toString(), "5:59:300");

    }

    @Test
    public void testSubSWWithSus() {
        StopWatch.setSuspend(true);
        StopWatch s = new StopWatch(5, 59, 300);
        StopWatch s1 = new StopWatch(5, 59, 300);
        s.sub(s1);
        Assert.assertEquals(s.toString(), "5:59:300");

    }

    @Test
    public void testIncWithSus() {
        StopWatch.setSuspend(true);
        StopWatch s = new StopWatch(5, 59, 300);
        s.inc();
        Assert.assertEquals(s.toString(), "5:59:300");

    }

    @Test
    public void testDecWithSus() {
        StopWatch.setSuspend(true);
        StopWatch s = new StopWatch(5, 59, 300);
        s.dec();
        Assert.assertEquals(s.toString(), "5:59:300");

    }


    @Test
    public void testEqual() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(6, 01, 200);
        StopWatch s3 = new StopWatch(5, 50, 200);
        StopWatch s4 = new StopWatch(5, 59, 300);

        Assert.assertNotEquals(s1, s2);
        Assert.assertEquals(s1, s4);

    }
    @Test
    public void testEqualObj() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(6, 01, 200);
        StopWatch s3 = new StopWatch(5, 50, 200);
        StopWatch s4 = new StopWatch(5, 59, 300);

        Assert.assertTrue(s1.equals(s4));
        Assert.assertFalse(s1.equals(s2));

    }

    @Test
    public void testCompareTo() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(6, 01, 200);
        StopWatch s3 = new StopWatch(5, 50, 200);
        StopWatch s4 = new StopWatch(5, 59, 300);

        Assert.assertTrue(s2.compareTo(s1) > 0);
        Assert.assertTrue(s3.compareTo(s1) < 0);
        Assert.assertEquals(0, s1.compareTo(s4));

    }

    @Test
    public void testLoadSave() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(5, 59, 300);

        s1.save("file1");
        s1 = new StopWatch();  // resets to zero

        s1.load("file1");
        Assert.assertEquals(s1, s2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveNull() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(5, 59, 300);

        s1.save(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoadNull() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(5, 59, 300);

        s1.save("file1");
        s1 = new StopWatch();  // resets to zero

        s1.load(null);
    }

    @Test
    public void testMutate() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(5, 59, 300);

        StopWatch.setSuspend(true);
        s1.add(1000);
        Assert.assertEquals(s1, s2);
        StopWatch.setSuspend(false);
    }

    @Test
    public void equalsTest() {
        StopWatch s1 = new StopWatch(5, 59, 300);
        StopWatch s2 = new StopWatch(5, 59, 300);

        Assert.assertEquals(s1, s2);
    }

    @Test
    public void testSuspendT() {
        StopWatch.setSuspend(true);
        Assert.assertEquals(StopWatch.isSuspended(), true);

    }

    @Test
    public void testSuspendF() {
        StopWatch.setSuspend(false);
        Assert.assertEquals(StopWatch.isSuspended(), false);

    }

    @Test
    public void testSetMin() {
        StopWatch s = new StopWatch(1, 2, 3);
        s.setMinutes(8);
        Assert.assertEquals(s.getMinutes(), 8);

    }

    @Test
    public void testSetSec() {
        StopWatch s = new StopWatch(1, 2, 3);
        s.setSeconds(8);
        Assert.assertEquals(s.getSeconds(), 8);

    }

    @Test
    public void testSetMilli() {
        StopWatch s = new StopWatch(1, 2, 3);
        s.setMilliseconds(8);
        Assert.assertEquals(s.getMilliseconds(), 8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetMinNeg() {
        StopWatch s = new StopWatch(1, 2, 3);
        s.setMinutes(-8);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetSecNeg() {
        StopWatch s = new StopWatch(1, 2, 3);
        s.setSeconds(-8);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetMilliNeg() {
        StopWatch s = new StopWatch(1, 2, 3);
        s.setMilliseconds(-8);

    }

}

