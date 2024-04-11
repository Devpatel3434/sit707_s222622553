package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author DEV PATEL
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s222622553";
		System.out.println("Student ID: " + studentId);
		Assert.assertNotNull("Student ID is", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "DEV PATEL";
		System.out.println("Student Name: " + studentName);
		Assert.assertNotNull("Student name is", studentName);
	}
	
	// MAX boundary

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	// MIN Boundary
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		// Code here
		DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("January1ShouldIncrementToJanuary2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		// Code here
		DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("january1ShouldDecrementToDecember31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
	}
	// February leap year 
	@Test
	public void testFebruary29ShouldIncrementToMarch1() {
	    
	    DateUtil date = new DateUtil(29, 2, 2024);
	    System.out.println("February29ShouldIncrementToMarch1 (leap year) > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMarch1ShouldDecrementToFebruary29() {
	    
	    DateUtil date = new DateUtil(1, 3, 2024);
	    System.out.println("March1ShouldDecrementToFebruary29 (leap year) > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	}
	
	/*
	 * Orange table test cases
	 */

	@Test
	public void test1B() {
	    DateUtil date = new DateUtil(1, 6, 1994);
	    System.out.println("Test 1B: " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void test2B() {
	    DateUtil date = new DateUtil(2, 6, 1994);
	    System.out.println("Test 2B: " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(3, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void test3B() {
	    DateUtil date = new DateUtil(15, 6, 1994);
	    System.out.println("Test 3B: " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void test4B() {
	    DateUtil date = new DateUtil(30, 6, 1994);
	    System.out.println("Test 4B: " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void test5B() {
	    DateUtil date = new DateUtil(31, 6, 1994);
	    System.out.println("Test 5B: " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void test6B() {
	    DateUtil date = new DateUtil(15, 1, 1994);
	    System.out.println("Test 6B: " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	}

	@Test
	public void test7B() {
	    DateUtil date = new DateUtil(15, 2, 1994);
	    System.out.println("Test 7B: " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void test8B() {
	    DateUtil date = new DateUtil(15, 11, 1994);
	    System.out.println("Test 8B: " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(11, date.getMonth());
	}

	@Test
	public void test9B() {
	    DateUtil date = new DateUtil(15, 12, 1994);
	    System.out.println("Test 9B: " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void test10B() {
	    DateUtil date = new DateUtil(15, 6, 1700);
	    System.out.println("Test 10B: " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void test11B() {
	    DateUtil date = new DateUtil(15, 6, 1701);
	    System.out.println("Test 11B: " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void test12B() {
	    DateUtil date = new DateUtil(15, 6, 2023);
	    System.out.println("Test 12B: " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void test13B() {
	    DateUtil date = new DateUtil(15, 6, 2024);
	    System.out.println("Test 13B: " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(16, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	
	
	/*
	 * Write tests for rest months of year 2024.
	 */
	
	
	// MAX boundary
	

	@Test
	public void testMaxMarch31ShouldIncrementToApril1() {
	    DateUtil date = new DateUtil(31, 3, 2024);
	    System.out.println("MaxMarch31ShouldIncrementToApril1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testMaxMarch31ShouldDecrementToMarch30() {
	    DateUtil date = new DateUtil(31, 3, 2024);
	    System.out.println("MaxMarch31ShouldDecrementToMarch30 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(30, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMaxApril30ShouldIncrementToMay1() {
	    DateUtil date = new DateUtil(30, 4, 2024);
	    System.out.println("MaxApril30ShouldIncrementToMay1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMaxApril30ShouldDecrementToApril29() {
	    DateUtil date = new DateUtil(30, 4, 2024);
	    System.out.println("MaxApril30ShouldDecrementToApril29 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(4, date.getMonth());
	}


	@Test
	public void testMaxMay31ShouldIncrementToJune1() {
	    DateUtil date = new DateUtil(31, 5, 2024);
	    System.out.println("MaxMay31ShouldIncrementToJune1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testMaxMay31ShouldDecrementToMay30() {
	    DateUtil date = new DateUtil(31, 5, 2024);
	    System.out.println("MaxMay31ShouldDecrementToMay30 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(30, date.getDay());
	    Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMaxJune30ShouldIncrementToJuly1() {
	    DateUtil date = new DateUtil(30, 6, 2024);
	    System.out.println("MaxJune30ShouldIncrementToJuly1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testMaxJune30ShouldDecrementToJune29() {
	    DateUtil date = new DateUtil(30, 6, 2024);
	    System.out.println("MaxJune30ShouldDecrementToJune29 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testMaxJuly31ShouldIncrementToAugust1() {
	    DateUtil date = new DateUtil(31, 7, 2024);
	    System.out.println("MaxJuly31ShouldIncrementToAugust1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(8, date.getMonth());
	}

	@Test
	public void testMaxJuly31ShouldDecrementToJuly30() {
	    DateUtil date = new DateUtil(31, 7, 2024);
	    System.out.println("MaxJuly31ShouldDecrementToJuly30 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(30, date.getDay());
	    Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testMaxAugust31ShouldIncrementToSeptember1() {
	    DateUtil date = new DateUtil(31, 8, 2024);
	    System.out.println("MaxAugust31ShouldIncrementToSeptember1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(9, date.getMonth());
	}

	@Test
	public void testMaxAugust31ShouldDecrementToAugust30() {
	    DateUtil date = new DateUtil(31, 8, 2024);
	    System.out.println("MaxAugust31ShouldDecrementToAugust30 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(30, date.getDay());
	    Assert.assertEquals(8, date.getMonth());
	}

	@Test
	public void testMaxSeptember30ShouldIncrementToOctober1() {
	    DateUtil date = new DateUtil(30, 9, 2024);
	    System.out.println("MaxSeptember30ShouldIncrementToOctober1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testMaxSeptember30ShouldDecrementToSeptember29() {
	    DateUtil date = new DateUtil(30, 9, 2024);
	    System.out.println("MaxSeptember30ShouldDecrementToSeptember29 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(9, date.getMonth());
	}

	@Test
	public void testMaxOctober31ShouldIncrementToNovember1() {
	    DateUtil date = new DateUtil(31, 10, 2024);
	    System.out.println("MaxOctober31ShouldIncrementToNovember1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(11, date.getMonth());
	}

	@Test
	public void testMaxOctober31ShouldDecrementToOctober30() {
	    DateUtil date = new DateUtil(31, 10, 2024);
	    System.out.println("MaxOctober31ShouldDecrementToOctober30 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(30, date.getDay());
	    Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testMaxNovember30ShouldIncrementToDecember1() {
	    DateUtil date = new DateUtil(30, 11, 2024);
	    System.out.println("MaxNovember30ShouldIncrementToDecember1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testMaxNovember30ShouldDecrementToNovember29() {
	    DateUtil date = new DateUtil(30, 11, 2024);
	    System.out.println("MaxNovember30ShouldDecrementToNovember29 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(11, date.getMonth());
	}

	@Test
	public void testMaxDecember31ShouldIncrementToJanuary1NextYear() {
	    DateUtil date = new DateUtil(31, 12, 2024);
	    System.out.println("MaxDecember31ShouldIncrementToJanuary1NextYear > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(2025, date.getYear());
	}

	@Test
	public void testMaxDecember31ShouldDecrementToDecember30() {
	    DateUtil date = new DateUtil(31, 12, 2024);
	    System.out.println("MaxDecember31ShouldDecrementToDecember30 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(30, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	}

	
	
	
	
	// MIN boundary
	
	@Test
	public void testMinMarch1ShouldIncrementToMarch2() {
	    DateUtil date = new DateUtil(1, 3, 2024);
	    System.out.println("MinMarch1ShouldIncrementToMarch2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMinMarch1ShouldDecrementToFebruary29() {
	    DateUtil date = new DateUtil(1, 3, 2024);
	    System.out.println("MinMarch1ShouldDecrementToFebruary29 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testMinApril1ShouldIncrementToApril2() {
	    DateUtil date = new DateUtil(1, 4, 2024);
	    System.out.println("MinApril1ShouldIncrementToApril2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testMinApril1ShouldDecrementToMarch31() {
	    DateUtil date = new DateUtil(1, 4, 2024);
	    System.out.println("MinApril1ShouldDecrementToMarch31 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMinMay1ShouldIncrementToMay2() {
	    DateUtil date = new DateUtil(1, 5, 2024);
	    System.out.println("MinMay1ShouldIncrementToMay2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMinMay1ShouldDecrementToApril30() {
	    DateUtil date = new DateUtil(1, 5, 2024);
	    System.out.println("MinMay1ShouldDecrementToApril30 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(30, date.getDay());
	    Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testMinJune1ShouldIncrementToJune2() {
	    DateUtil date = new DateUtil(1, 6, 2024);
	    System.out.println("MinJune1ShouldIncrementToJune2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testMinJune1ShouldDecrementToMay31() {
	    DateUtil date = new DateUtil(1, 6, 2024);
	    System.out.println("MinJune1ShouldDecrementToMay31 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMinJuly1ShouldIncrementToJuly2() {
	    DateUtil date = new DateUtil(1, 7, 2024);
	    System.out.println("MinJuly1ShouldIncrementToJuly2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testMinJuly1ShouldDecrementToJune30() {
	    DateUtil date = new DateUtil(1, 7, 2024);
	    System.out.println("MinJuly1ShouldDecrementToJune30 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(30, date.getDay());
	    Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testMinAugust1ShouldIncrementToAugust2() {
	    DateUtil date = new DateUtil(1, 8, 2024);
	    System.out.println("MinAugust1ShouldIncrementToAugust2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(8, date.getMonth());
	}

	@Test
	public void testMinAugust1ShouldDecrementToJuly31() {
	    DateUtil date = new DateUtil(1, 8, 2024);
	    System.out.println("MinAugust1ShouldDecrementToJuly31 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testMinSeptember1ShouldIncrementToSeptember2() {
	    DateUtil date = new DateUtil(1, 9, 2024);
	    System.out.println("MinSeptember1ShouldIncrementToSeptember2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(9, date.getMonth());
	}

	@Test
	public void testMinSeptember1ShouldDecrementToAugust31() {
	    DateUtil date = new DateUtil(1, 9, 2024);
	    System.out.println("MinSeptember1ShouldDecrementToAugust31 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(8, date.getMonth());
	}

	@Test
	public void testMinOctober1ShouldIncrementToOctober2() {
	    DateUtil date = new DateUtil(1, 10, 2024);
	    System.out.println("MinOctober1ShouldIncrementToOctober2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testMinOctober1ShouldDecrementToSeptember30() {
	    DateUtil date = new DateUtil(1, 10, 2024);
	    System.out.println("MinOctober1ShouldDecrementToSeptember30 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(30, date.getDay());
	    Assert.assertEquals(9, date.getMonth());
	}

	@Test
	public void testMinNovember1ShouldIncrementToNovember2() {
	    DateUtil date = new DateUtil(1, 11, 2024);
	    System.out.println("MinNovember1ShouldIncrementToNovember2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(11, date.getMonth());
	}

	@Test
	public void testMinNovember1ShouldDecrementToOctober31() {
	    DateUtil date = new DateUtil(1, 11, 2024);
	    System.out.println("MinNovember1ShouldDecrementToOctober31 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(31, date.getDay());
	    Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testMinDecember1ShouldIncrementToDecember2() {
	    DateUtil date = new DateUtil(1, 12, 2024);
	    System.out.println("MinDecember1ShouldIncrementToDecember2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testMinDecember1ShouldDecrementToNovember30() {
	    DateUtil date = new DateUtil(1, 12, 2024);
	    System.out.println("MinDecember1ShouldDecrementToNovember30 > " + date);
	    date.decrement();
	    System.out.println(date);
	    Assert.assertEquals(30, date.getDay());
	    Assert.assertEquals(11, date.getMonth());
	}

}
