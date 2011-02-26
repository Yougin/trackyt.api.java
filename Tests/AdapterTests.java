import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import trackyt.api.java.TrackytApiAdapter;
import trackyt.api.java.TrackytApiAdapterFactory;
import trackyt.api.java.exceptions.NotAuthenticatedException;
import trackyt.api.java.models.ApiToken;
import trackyt.api.java.models.Task;

public class AdapterTests {

	private String mEmail;
	private String mPassword;
	TrackytApiAdapter adapter;
	ApiToken apiToken;

	public AdapterTests() {
		mEmail = TestsConfig.mEmail;
		mPassword = TestsConfig.mPassword;
		adapter = TrackytApiAdapterFactory.createV11Adapter();
	}
	

	@Before
	public void runBeforeEachTest() {
		try {
			this.apiToken = adapter.authenticate(mEmail, mPassword);
		} catch (NotAuthenticatedException e) {
			fail("@Before failed");
		}
	}
	

	@Test
	public void Authenticate_AuthenicationSuccess_ReturnApiToken() {
		apiToken = null;

		try {
			apiToken = adapter.authenticate(mEmail, mPassword);
		} catch (NotAuthenticatedException e) {
			fail("Exception during authentication");
		}

		assertNotNull("apiToken is null", apiToken);
	}

	
	@Test
	public void Authenticate_AuthenticationFailed_ExceptionThrown() {
		try {
			adapter.authenticate("noSuchNumber", "noSuchZone");
			fail("No exception thrown");
		} catch (NotAuthenticatedException e) {
			// Means test passed, no need to process
		}
	}

	
	@Test
	public void GetAllTasks_Success_ReturnsUserTasks() {
		List<Task> tasksList = new ArrayList<Task>();

		try {
			tasksList = adapter.getAllTasks(apiToken);
		} catch (Exception e) {
			fail("getAllTasks failed because of HttpException");
		}

		assertNotNull("tasksList is null", tasksList);
	}

	
	@Test
	public void GetAllTasks_WithWrongApiToken_ExceptionThrown() {
		List<Task> tasksList = new ArrayList<Task>();

		try {
			tasksList = adapter.getAllTasks(new ApiToken("654654654"));
			fail("No exception thrown");
		} catch (Exception e) {
			// Means test passed, no need to process
		}
	}

	
	@Test
	public void CreateTask_Success_ReturnsNewTask() {
		Task task = null;

		try {
			task = adapter.addTask(apiToken, "New Task");
		} catch (Exception e) {
			fail("Failed on AddTask()");
		}

		assertNotNull("task is null", task);
	}

	
	@Test
	public void CreateTask_Fail_ExceptionThrown() {
		try {
			adapter.addTask(new ApiToken("654654654"), "New Task");
			fail("No exception thrown");
		} catch (Exception e) {
			// Means test passed, no need to process
		}
	}

	
	@Test
	public void DeleteTask_Success_ReturnsDeletedTaskId() {
		Task task = null;
		int idOfDeletedTask = 111111;

		try {
			task = adapter.addTask(apiToken, "To be deleted");
		} catch (Exception e) {
			fail("Exception on add operation");
		}

		if (task != null) {
			try {
				idOfDeletedTask = adapter.deleteTask(apiToken, task.getId());
			} catch (Exception e) {
				fail("exception on delete operation");
			}
		} else {
			fail("Test preparation part failed");
		}

		assertEquals(task.getId(), idOfDeletedTask);
	}

	
	@Test
	public void DeleteTask_Fail_WrongApiToken_ExceptionThrown() {
		try {
			adapter.addTask(new ApiToken("654654654"), "Task's description");
			fail("No exception thrown");
		} catch (Exception e) {
			// Means test passed, no need to process
		}
	}

	
	@Test
	public void DeleteTask_Fail_WrongTaskId_ExceptionThrown() {
		Task task;

		try {
			task = adapter.addTask(apiToken, "Task's description");
		} catch (Exception e) {
			fail("Exception on add operation");
		}

		try {
			adapter.deleteTask(apiToken, 33421);
			fail("No exception thrown");
		} catch (Exception e) {
			// Means test passed, no need to process
		}
	}

	
	@Test
	public void StartTask_Success_ReturnStartedTask() {
		Task taskToStart = null;
		Task startedTask = null;

		try {
			taskToStart = adapter.addTask(apiToken, "Task to start");
		} catch (Exception e) {
			fail("Failed on add task operation");
		}

		if (taskToStart != null) {
			try {
				startedTask = adapter.startTask(apiToken, taskToStart.getId());
			} catch (Exception e) {
				fail("Failed on startTask()");
			}
		}

		assertNotNull("Started task is null", startedTask);
		assertEquals(taskToStart.getId(), startedTask.getId());
	}

	
	@Test
	public void StartTask_Fail_WrongApiToken_ExceptionThrown() {
		Task task = null;

		try {
			task = adapter.addTask(apiToken, "Task to start");
		} catch (Exception e) {
			fail("Failed to add task operation");
		}

		if (task != null) {
			try {
				adapter.startTask(new ApiToken("654654654"), task.getId());
				fail("No exception thrown");
			} catch (Exception e) {
				// Means test passed, no need to process
			}
		} else {
			fail("task is null");
		}
	}

	
	@Test
	public void StartTask_Fail_WrongTaskId_ExceptionThrown() {
		Task task = null;

		try {
			task = adapter.addTask(apiToken, "Task to start");
		} catch (Exception e) {
			fail("Failed to add task operation");
		}

		try {
			adapter.startTask(apiToken, 123456);
			fail("No exception thrown");
		} catch (Exception e) {
			// Means test passed, no need to process
		}
	}

	
	@Test
	public void StopTask_Success_ReturnStartedTask() {
		Task taskToStop = null;
		Task stoppedTask = null;

		try {
			taskToStop = adapter.addTask(apiToken, "Task to stop");
		} catch (Exception e) {
			fail("Failed on add task operation");
		}

		try {
			adapter.startTask(apiToken, taskToStop.getId());
		} catch (Exception e) {
			fail("Failed on start task operation");
		}

		try {
			stoppedTask = adapter.stopTask(apiToken, taskToStop.getId());
		} catch (Exception e) {
			fail("Failed on stopTask()");
		}

		assertNotNull("stoppedTask is null", stoppedTask);
		assertEquals(taskToStop.getId(), stoppedTask.getId());
	}

	
	@Test
	public void StopTask_Fail_WrongApiToken_ExceptionThrown() {
		Task taskToStop = null;

		try {
			taskToStop = adapter.addTask(apiToken, "Task to stop");
		} catch (Exception e) {
			fail("Failed on add task operation");
		}

		try {
			adapter.startTask(apiToken, taskToStop.getId());
		} catch (Exception e) {
			fail("Failed on start task operation");
		}

		try {
			adapter.stopTask(new ApiToken("654654654"), taskToStop.getId());
			fail("No exception thrown");
		} catch (Exception e) {
			// Means test passed, no need to process
		}
	}

	
	@Test
	public void StopTask_Fail_WrongTaskId_ExceptionThrown() {
		Task taskToStop = null;

		try {
			taskToStop = adapter.addTask(apiToken, "Task to stop");
		} catch (Exception e) {
			fail("Failed on add task operation");
		}

		try {
			adapter.startTask(apiToken, taskToStop.getId());
		} catch (Exception e) {
			fail("Failed on start task operation");
		}

		try {
			adapter.stopTask(apiToken, 123456);
			fail("No exception thrown");
		} catch (Exception e) {
			// Means test passed, no need to process
		}

	}

	
	@Test
	public void StartAll_Success_ReturnNothing() {
		try {
			adapter.startAll(apiToken);
		} catch (Exception e) {
			fail("startAll() failed");
		}
	}

	
	@Test
	public void StopAll_Success_ReturnNothing() {
		try {
			adapter.stopAll(apiToken);
		} catch (Exception e) {
			fail("stopAll() failed");
		}
	}
}
