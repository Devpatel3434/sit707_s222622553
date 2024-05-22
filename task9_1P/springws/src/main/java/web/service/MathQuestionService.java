//package web.service;
//
//public class MathQuestionService {
//
//	/**
//	 * Calculate Q1 result.
//	 * @param number1
//	 * @param number2
//	 * @return
//	 */
//	public static double q1Addition(String number1, String number2) {
//		double result = Double.valueOf(number1) + Double.valueOf(number2);
//		return result;
//	}
//	
//	/**
//	 * Calculate Q2 result.
//	 * @param number1
//	 * @param number2
//	 * @return
//	 */
//	public static double q2Subtraction(String number1, String number2) {
//		double result = Double.valueOf(number1) - Double.valueOf(number2);
//		return result;
//	}
//}

package web.service;

public class MathQuestionService {

    /**
     * Calculate Q1 result.
     * @param number1
     * @param number2
     * @return
     */
    public static Double q1Addition(String number1, String number2) {
        try {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            return num1 + num2;
        } catch (NumberFormatException e) {
            return null; // Return null for invalid inputs
        }
    }
    
    /**
     * Calculate Q2 result.
     * @param number1
     * @param number2
     * @return
     */
    public static Double q2Subtraction(String number1, String number2) {
        try {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            return num1 - num2;
        } catch (NumberFormatException e) {
            return null; // Return null for invalid inputs
        }
    }
}
