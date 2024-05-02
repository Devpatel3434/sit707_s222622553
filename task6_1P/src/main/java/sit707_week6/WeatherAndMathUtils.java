package sit707_week6;

public class WeatherAndMathUtils {
	
	public static final double DANGEROUS_WINDSPEED = 70.0;
	public static final double DANGEROUS_RAINFALL = 6.0;
	public static final double CONCERNING_WINDSPEED = 45.0;
	public static final double CONCERNING_RAINFALL = 4.0;


	public static String weatherAdvice(double windSpeed, double precipitation) {
		if (windSpeed < 0 || precipitation < 0) {
			// Optional: Keep this condition uncovered for P task.
			throw new IllegalArgumentException();
		}

		String advice = "ALL CLEAR";

		if (windSpeed > DANGEROUS_WINDSPEED || precipitation > DANGEROUS_RAINFALL
				|| (windSpeed > CONCERNING_WINDSPEED && precipitation > CONCERNING_RAINFALL)) {
			advice = "CANCEL";
		} else if (windSpeed > CONCERNING_WINDSPEED || precipitation > CONCERNING_RAINFALL) {
			advice = "WARN";
		}

		return advice;
	}


	public static boolean isEven(int a) {
		if (a % 2 == 0) {
			return true;
		}
		return false;
	}
	


	public static boolean isPrime(int n) {
		if (n == 1) {
			return true;
		}
		// Test if n is divisible by any other number down to 2.
		for (int i = 2; i < n; i++) {
			if (isEven(n)) {
				return false;
			}
		}
		// Number is prime
		return true;
	}
	
	
////////////////////////  Part - B       //////////////////////////////////   
	
	
	public static int sumWithConditionalLoop(int[] numbers, int threshold) {
        int sum = 0;
        for (int num : numbers) {
            if (num > threshold) {
                sum += num;
            }
        }

        return sum;
    }

    public static int productWithConditionalLoopAndStatement(int[] numbers, int threshold) {
        int product = 1;
        for (int num : numbers) {
            if (num > threshold) {
                if (num % 2 == 0) {
                    product *= num;
                }
            }
        }

        return product;
    }
	
}
