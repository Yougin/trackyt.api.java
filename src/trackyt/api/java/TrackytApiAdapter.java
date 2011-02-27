package trackyt.api.java;

import java.util.List;

import trackyt.api.java.exceptions.NotAuthenticatedException;
import trackyt.api.java.models.ApiToken;
import trackyt.api.java.models.Task;

public interface TrackytApiAdapter {
	
    /** Authenticate user
    * @param User's Email
    * @param User's Password
    * @return ApiToken for authorized users/applications
    * @exception Throws NotAuthenticatedException for unsuccessful authentication
    */
	ApiToken authenticate(String email, String password) throws NotAuthenticatedException;
	
	
	/**
	 * Retrieval of all user's tasks
	 * @param API authentication token
	 * @return List of tasks
	 * @exception Throws Exception for unsuccessful result
	 */
	List<Task> getAllTasks(ApiToken token) throws Exception;
	
	
	/**
	 * Create new task
	 * @param API authentication token
	 * @param Task's description
	 * @return Newly created task instance
	 * @exception Throws Exception for unsuccessful result
	 */
	Task addTask(ApiToken token, String description) throws Exception;
	
	/**
	 * Delete task
	 * @param API authentication token
	 * @param Task's id
	 * @return id of deleted task
	 * @throws Exception
	 */
	int deleteTask(ApiToken token, int taskId) throws Exception;
	
	
	/**
	 * Start Task
	 * @param API authentication token
	 * @param taskId
	 * @return Started task instance
	 * @throws Exception
	 */
	Task startTask(ApiToken token, int taskId) throws Exception;
	
	/**
	 * Stop task
	 * @param API authentication token
	 * @param taskId
	 * @return Stopped task instance
	 * @throws Exception
	 */
	Task stopTask(ApiToken token, int taskId) throws Exception;
	
	/**
	 * Stop all tasks
	 * @param API authentication token
	 * @throws Exception
	 */
	void startAll(ApiToken token) throws Exception;
	 
	/**
	 * Stop all tasks
	 * @param API authentication token
	 * @throws Exception
	 */
	void stopAll(ApiToken token) throws Exception; 
	
}
