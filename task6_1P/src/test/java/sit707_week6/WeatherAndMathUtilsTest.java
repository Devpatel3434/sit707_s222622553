package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s222622553";
		Assert.assertNotNull("Student ID is ", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "DEV PATEL";
		Assert.assertNotNull("Student name is ", studentName);
	}

    
    @Test
    public void testEvenWithEven() {
        int evenNumber = 6;
        Assert.assertTrue(WeatherAndMathUtils.isEven(evenNumber));
    }
    
    @Test
    public void testPrimeWithPrime() { 
        int primeNumber = 7;
        Assert.assertTrue(WeatherAndMathUtils.isPrime(primeNumber));
    }

    @Test
    public void testIsPrimeWithNonPrime() {
       int nonPrimeNumber = 6;
       Assert.assertFalse(WeatherAndMathUtils.isPrime(nonPrimeNumber));
   }
    @Test
    public void testIsPrimeWithOne() {
        int one = 1;
        Assert.assertTrue(WeatherAndMathUtils.isPrime(one));
    }

    
    @Test
    public void testWeatherAdviceAllClear() {
        // Test with wind speed and precipitation below concerning levels
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(30.0, 3.0));
    }

    @Test
    public void testWeatherAdviceWarn() {
        // Test with wind speed above concerning level but precipitation below concerning level
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 2.0));
    }
    
    @Test
    public void testWeatherAdviceWarn1() {
        // Test with wind speed below concerning level and precipitation above concerning level
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(40.0, 5.0));
    }

    @Test
    public void testWeatherAdviceCancel() {
        // Test with wind speed and precipitation above dangerous levels
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(80.0, 8.0));
    }
  
    @Test
    public void testWeatherAdviceCancel1() {
        // Test with wind speed and precipitation above concerning level
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(50.0, 5.0));
    }
    
    @Test
    public void testWeatherAdviceCancel2() {
        // Test with wind speed and precipitation above concerning level
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(60.0, 5.0));
    }
    @Test
    public void testWeatherAdviceCancel3() {
        // Test with wind speed below concerning level and precipitation above dangerous level
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(30.0, 7.0));
    }

    

////////////////////////   Part - B       //////////////////////////////////   
    
    @Test
    public void testSumWithConditionalLoop() {
        int[] numbers = {1, 2, 3, 4, 5};
        int threshold = 2;
        Assert.assertEquals(12, WeatherAndMathUtils.sumWithConditionalLoop(numbers, threshold));
    }

    @Test
    public void testProductWithConditionalLoopAndStatement() {
        int[] numbers = {1, 2, 3, 4, 5};
        int threshold = 2;
        Assert.assertEquals(4, WeatherAndMathUtils.productWithConditionalLoopAndStatement(numbers, threshold));
    }

    
}
