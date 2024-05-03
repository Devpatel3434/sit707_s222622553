//package sit707_week7;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//public class BodyTemperatureMonitorTest {
//
//	@Test
//	public void testStudentIdentity() {
//		String studentId = "s222622553";
//		Assert.assertNotNull("Student ID is ", studentId);
//	}
//
//	@Test
//	public void testStudentName() {
//		String studentName = "DEV PATEL";
//		Assert.assertNotNull("Student name is ", studentName);
//	}
//	
//	@Test
//	public void testReadTemperatureNegative() {
//		Assert.assertTrue("Not tested", false);
//	}
//	
//	@Test
//	public void testReadTemperatureZero() {
//		Assert.assertTrue("Not tested", false);
//	}
//	
//	@Test
//	public void testReadTemperatureNormal() {
//		Assert.assertTrue("Not tested", false);
//	}
//
//	@Test
//	public void testReadTemperatureAbnormallyHigh() {
//		Assert.assertTrue("Not tested", false);
//	}
//
//	
//	@Test
//	public void testReportTemperatureReadingToCloud() {
//		 Mock reportTemperatureReadingToCloud() calls cloudService.sendTemperatureToCloud()
//		
//		Assert.assertTrue("Not tested", false);
//	}
//	
//	
//	
//	@Test
//	public void testInquireBodyStatusNormalNotification() {
//		Assert.assertTrue("Not tested", false);
//	}
//	
//	
//	@Test
//	public void testInquireBodyStatusAbnormalNotification() {
//		Assert.assertTrue("Not tested", false);
//	}
//}
package sit707_week7;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
public class BodyTemperatureMonitorTest {
	
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
    public void testReadTemperatureNegative() {
        // Create a mock TemperatureSensor
        TemperatureSensor temperatureSensor = mock(TemperatureSensor.class);
        // Stub the mock to return a negative temperature reading
        when(temperatureSensor.readTemperatureValue()).thenReturn(-7.0);

        // Create an instance of BodyTemperatureMonitor with the mocked TemperatureSensor
        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(temperatureSensor, null, null);

        // Test the behavior when reading a negative temperature
        double temperature = monitor.readTemperature();
        Assert.assertEquals("Temperature should be negative", -7.0, temperature, 0.01);
    }

    @Test
    public void testReadTemperatureZero() {
        TemperatureSensor temperatureSensor = mock(TemperatureSensor.class);
       
        when(temperatureSensor.readTemperatureValue()).thenReturn(0.0);

        
        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(temperatureSensor, null, null);

        // Test the behavior when reading zero temperature
        double temperature = monitor.readTemperature();
        Assert.assertEquals("Temperature should be zero", 0.0, temperature, 0.01);
    }

    @Test
    public void testReadTemperatureNormal() {
        
        TemperatureSensor temperatureSensor = mock(TemperatureSensor.class);
        // Stub the mock to return a normal temperature reading 
        when(temperatureSensor.readTemperatureValue()).thenReturn(34.5);

    
        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(temperatureSensor, null, null);

        // Test the behavior when reading normal temperature
        double temperature = monitor.readTemperature();
        Assert.assertEquals("Temperature should be normal", 34.5, temperature, 0.01);
    }

    @Test
    public void testReadTemperatureAbnormallyHigh() {
        
        TemperatureSensor temperatureSensor = mock(TemperatureSensor.class);
        // Stub the mock to return an abnormally high temperature reading
        when(temperatureSensor.readTemperatureValue()).thenReturn(60.0);

        
        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(temperatureSensor, null, null);

        // Test the behavior when reading abnormally high temperature
        double temperature = monitor.readTemperature();
        Assert.assertEquals("Temperature should be abnormally high", 60.0, temperature, 0.01);
    }

    @Test
    public void testReportTemperatureReadingToCloud() {
        // Create a mock CloudService
        CloudService cloudService = mock(CloudService.class);

        // Create an instance of BodyTemperatureMonitor with the mocked CloudService
        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(null, cloudService, null);

        // Call the method under test
        monitor.reportTemperatureReadingToCloud(new TemperatureReading());

        // Verify that sendTemperatureToCloud method is called once
        //verify(cloudService).sendTemperatureToCloud(new TemperatureReading());
        //verify(cloudService).sendTemperatureToCloud(anyDouble());
        verify(cloudService).sendTemperatureToCloud(any(TemperatureReading.class));
    }


	@Test
    public void testInquireBodyStatusNormalNotification() {
		
		
        // Create a mock CloudService
        CloudService cloudService = mock(CloudService.class);
        // Stub the mock to return "NORMAL" status
        when(cloudService.queryCustomerBodyStatus(null)).thenReturn("NORMAL");

        // Create a mock NotificationSender
        NotificationSender notificationSender = mock(NotificationSender.class);

        // Create an instance of BodyTemperatureMonitor with the mocked CloudService and NotificationSender
        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(null, cloudService, notificationSender);

        // Call the method under test
        monitor.inquireBodyStatus();

        // Verify that sendEmailNotification method is called once with fixedCustomer
        verify(notificationSender).sendEmailNotification(monitor.getFixedCustomer(), "Thumbs Up!");
        //verify(notificationSender).sendEmailNotification(any(Customer.class), "Thumbs Up!");
    }

    @Test
    public void testInquireBodyStatusAbnormalNotification() {
        
        CloudService cloudService = mock(CloudService.class);
        // Stub the mock to return "ABNORMAL" status
        when(cloudService.queryCustomerBodyStatus(null)).thenReturn("ABNORMAL");

        
        NotificationSender notificationSender = mock(NotificationSender.class);

        
        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(null, cloudService, notificationSender);

        
        monitor.inquireBodyStatus();

        // Verify that sendEmailNotification method is called once with familyDoctor
        verify(notificationSender).sendEmailNotification(monitor.getFamilyDoctor(), "Emergency!");
    }
    

}
