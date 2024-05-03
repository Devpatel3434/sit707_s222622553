//package sit707_week7.sample;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import sit707_week7.sample.EmailSender;
//import sit707_week7.sample.StudentReader;
//import sit707_week7.sample.StudentRepository;
//
///**
// * Tests StudentReader.
// * @author Ahsan Habib
// */
//public class StudentReaderTest {
//
//	@Test
//	public void testFindStudent() {
//		Student sampleStudent = new Student();
//		sampleStudent.setFirstName("Ahsan");
//		sampleStudent.setLastName("Habib");
//
//		StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
//		Mockito.when(studentRepository.findByID(1L)).thenReturn(sampleStudent);
//
//		StudentReader studentReader = new StudentReader();
//		studentReader.setStudentReposiroty(studentRepository);
//
//		String fullName = studentReader.findFullName(1L);
//		Assert.assertEquals("Ahsan Habib", fullName);
//	}
//	
//	
//	@Test
//	public void testStudentRepoSave() {
//		Student sampleStudent = new Student();
//		sampleStudent.setFirstName("Ahsan");
//		sampleStudent.setLastName("Habib");
//		
//		StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
//		Mockito.when(studentRepository.save(sampleStudent)).thenReturn(2L);
//		
//		StudentReader studentReader = new StudentReader();
//		studentReader.setStudentReposiroty(studentRepository);
//		
//		//Mockito.verify(studentRepository).save(sampleStudent);
//		Long savedID = studentReader.createNew(sampleStudent);
//		Assert.assertEquals(Long.valueOf(2), savedID);
//	}
//	
//	
//	@Test
//	public void testEmailSend() {
//		Student sampleStudent = new Student();
//		sampleStudent.setFirstName("Ahsan");
//		sampleStudent.setLastName("Habib");
//		
//		// EmailSender emailSender = new EmailSender();
//		EmailSender emailSender = Mockito.mock(EmailSender.class);
//		
//		StudentReader studentReader = new StudentReader();
//		studentReader.setEmailSender(emailSender);
//		studentReader.notifyStudent(sampleStudent);
//		
//		// Test if emailSender.sendEmail is called once.
//		//
//		Mockito.verify(emailSender).sendEmail(sampleStudent);		
//	}
//	
//
//	@Test
//	public void testEmailNoSend() {
//		Student sampleStudent = new Student();
//		sampleStudent.setFirstName("Ahsan");
//		sampleStudent.setLastName("Habib");
//		
//		/*
//		 * Real emailSender
//		 */
//		//EmailSender emailSender = new EmailSender();
//		
//		/*
//		 * Mocked emailSender
//		 */
//		EmailSender emailSender = Mockito.mock(EmailSender.class);
//		
//		StudentReader studentReader = new StudentReader();
//		studentReader.setEmailSender(emailSender);
//		/*
//		 * notifyStudent is commented, so emailSender.sendEmail never invoked in studentReader
//		 */
//		//studentReader.notifyStudent(sampleStudent);
//		
//		/*
//		 * Test if emailSender.sendEmail is never called.
//		 */
//		Mockito.verify(emailSender, Mockito.times(0)).sendEmail(sampleStudent);
//	}
//}
package sit707_week7.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import sit707_week7.sample.EmailSender;
import sit707_week7.sample.StudentReader;
import sit707_week7.sample.StudentRepository;

/**
 * Tests StudentReader.
 * @author Ahsan Habib
 */
public class StudentReaderTest {

	@Test
	public void testFindStudent() {
		Student sampleStudent = new Student();
		sampleStudent.setFirstName("Ahsan");
		sampleStudent.setLastName("Habib");

		StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
		Mockito.when(studentRepository.findByID(1L)).thenReturn(sampleStudent);

		StudentReader studentReader = new StudentReader();
		studentReader.setStudentReposiroty(studentRepository);

		String fullName = studentReader.findFullName(1L);
		Assert.assertEquals("Ahsan Habib", fullName);

		// Test scenario where student is not found
		
	}
	
	
	@Test
	public void testStudentRepoSave() {
		Student sampleStudent = new Student();
		sampleStudent.setFirstName("Ahsan");
		sampleStudent.setLastName("Habib");
		
		StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
		Mockito.when(studentRepository.save(sampleStudent)).thenReturn(2L);
		
		StudentReader studentReader = new StudentReader();
		studentReader.setStudentReposiroty(studentRepository);
		
		Long savedID = studentReader.createNew(sampleStudent);
		Assert.assertEquals(Long.valueOf(2), savedID);
		
		// Verify that save method is called on studentRepository
		Mockito.verify(studentRepository).save(sampleStudent);
	}
	
	
	@Test
	public void testEmailSend() {
		Student sampleStudent = new Student();
		sampleStudent.setFirstName("Ahsan");
		sampleStudent.setLastName("Habib");
		
		EmailSender emailSender = Mockito.mock(EmailSender.class);
		
		StudentReader studentReader = new StudentReader();
		studentReader.setEmailSender(emailSender);
		studentReader.notifyStudent(sampleStudent);
		
		// Verify that sendEmail method is called on emailSender
		Mockito.verify(emailSender).sendEmail(sampleStudent);		
	}
	

	@Test
	public void testEmailNoSend() {
		Student sampleStudent = new Student();
		sampleStudent.setFirstName("Ahsan");
		sampleStudent.setLastName("Habib");
		
		EmailSender emailSender = Mockito.mock(EmailSender.class);
		
		StudentReader studentReader = new StudentReader();
		studentReader.setEmailSender(emailSender);
		
		// Verify that sendEmail method is never called on emailSender
		Mockito.verify(emailSender, Mockito.times(0)).sendEmail(sampleStudent);
	}
	
	@Test
	public void testDefaultConstructor() {
	    Student student = new Student();
	    assertNull(student.getFirstName());
	    assertNull(student.getLastName());
	    
	}

	@Test
	public void testGetSetFirstName() {
	    Student student = new Student();
	    student.setFirstName("Ahsan");
	    assertEquals("Ahsan", student.getFirstName());
	}

	@Test
	public void testGetSetLastName() {
	    Student student = new Student();
	    student.setLastName("Habib");
	    assertEquals("Habib", student.getLastName());
	}

	@Test
	public void testGetSetID() {
	    Student student = new Student();
	    student.setId(1L);
	    //assertEquals(Long.valueOf(1), student.getId());
	    assertEquals(1L, student.getId());
	}
	
	@Test
	public void testGetSetEmail() {
	    Student student = new Student();
	    student.setEmail("test@example.com");
	    assertEquals("test@example.com", student.getEmail());
	}
}