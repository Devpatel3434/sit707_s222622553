package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class WeatherControllerTest {
    private static WeatherController wController;

    @BeforeClass
    public static void setUp() {
        wController = WeatherController.getInstance();
    }

    @AfterClass
    public static void tearDown() {
        wController.close();
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "s222622553";
        Assert.assertNotNull("Student ID is", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Dev Patel";
        Assert.assertNotNull("Student name is", studentName);
    }
    

    private double[] getAllTemperatures(WeatherController wController) {
        int nHours = wController.getTotalHours();
        double[] temperatures = new double[nHours];
        for (int i = 0; i < nHours; i++) {
            temperatures[i] = wController.getTemperatureForHour(i + 1);
        }
        return temperatures;
    }
    
    
    
    
    
    private double findMinimumTemperature(double[] temperatures) {
        double minTemperature = Arrays.stream(temperatures).min().orElse(Double.MAX_VALUE);
        return minTemperature;
    }
    
    @Test
    public void testTemperatureMin() {
        System.out.println("--- Executing testTemperatureMin ---");
        // Arrange
        double[] temperatures = getAllTemperatures(wController);
         

        // Act
        double minTemperature = findMinimumTemperature(temperatures);
        System.out.println("Temperature min: " + minTemperature);

        // Assert
        Assert.assertEquals("Minimum temperature is incorrect", wController.getTemperatureMinFromCache(), minTemperature, 0.001);
    }
    
    
    
    
    
    
    private double findMaximumTemperature(double[] temperatures) {
        double maxTemperature = Arrays.stream(temperatures).max().orElse(Double.MIN_VALUE);
        return maxTemperature;
    }
    
    @Test
    public void testTemperatureMax() {
        System.out.println("--- Executing testTemperatureMax ---");
        // Arrange
        double[] temperatures = getAllTemperatures(wController);
         

        // Act
        double maxTemperature = findMaximumTemperature(temperatures);
        System.out.println("Temperature max: " + maxTemperature);

        // Assert
        Assert.assertEquals("Maximum temperature is incorrect", wController.getTemperatureMaxFromCache(), maxTemperature, 0.001);
    }

    
    
    
    
    
    private double calculateAverageTemperature(double[] temperatures) {
        double sumTemp = Arrays.stream(temperatures).sum();
        double averageTemperature = sumTemp / temperatures.length;
        return averageTemperature;
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("--- Executing testTemperatureAverage ---");
        // Arrange
        double[] temperatures = getAllTemperatures(wController);
         
        // Act
        double averageTemperature = calculateAverageTemperature(temperatures);
        System.out.println("Temperature avg: " + averageTemperature);

        // Assert
        Assert.assertEquals("Average temperature is incorrect", wController.getTemperatureAverageFromCache(), averageTemperature, 0.001);
    }
    

}
