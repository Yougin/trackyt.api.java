import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdapterTests {
	
	private String mEmail; 
	private String mPassword; 
	
	AdapterTests() {
		mEmail = TestsConfig.mEmail;
		mPassword = TestsConfig.mPassword;
	}
	
	@Before
	public void runBeforeEachTest() {
		
	}
	
	@After
	public void runAfterEachTest() {
		
	}
	
	@Test
	public void Authenticate_AuthenicationSuccess_ReturnApiToken() {
	
	}
	
	@Test
	public void Authenticate_AuthenticationFailed_ExceptionThrown() {
		
	}
	
	@Test
	public void GetAllTasks_Success_ReturnsUserTasks() {
		
	}
	
	@Test
	public void GetAllTasks_WithWrongApiToken_ExceptionThrown() {
		
	}
	
	@Test
	public void CreateTask_Success_ReturnsNewTask() {
		
	}
	
	@Test
	public void CreateTask_Fail_ExceptionThrown() {
		
	}
	
	@Test
	public void DeleteTask_Success_ReturnsDeletedTaskId() {
		
	}
	
	@Test
	public void DeleteTask_Fail_WrongApiToken_ExceptionThrown() {
		
	}
	
	@Test
	public void DeleteTask_Fail_WrongTaskId_ExceptionThrown() {
		
	}
	
	@Test
	public void StartTask_Success_ReturnStartedTask() {
		
	}
	
	@Test
	public void StartTask_Fail_WrongApiToken_ExceptionThrown() {
		
	}
	
	@Test
	public void StartTask_Fail_WrongTaskId_ExceptionThrown() {
		
	}
	
	@Test
	public void StopTask_Success_ReturnStartedTask() {
		
	}
	
	@Test
	public void StopTask_Fail_WrongApiToken_ExceptionThrown() {
		
	}
	
	@Test
	public void StopTask_Fail_WrongTaskId_ExceptionThrown() {
		
	}
	
	@Test
	public void StartAll_Success_ReturnNothing() {
		
	}
	
	@Test
	public void StopAll_Success_ReturnNothing() {
		
	}

}
