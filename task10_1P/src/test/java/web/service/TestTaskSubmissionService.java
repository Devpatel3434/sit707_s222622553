package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

import web.TaskSubmissionService;

public class TestTaskSubmissionService {
	
	@Test
    public void testSubmitTask() {
        TaskSubmissionService TaskSubmissionService = new TaskSubmissionService();
        boolean result = TaskSubmissionService.submitTask("S222622553", "Task34");
        assertTrue(result);
    }
    
 //
}
