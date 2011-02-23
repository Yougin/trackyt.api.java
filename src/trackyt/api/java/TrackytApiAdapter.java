package trackyt.api.java;

import java.util.List;

import org.apache.http.HttpException;

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
	ApiToken Authenticate(String email, String password) throws NotAuthenticatedException;
	
	
	/**
	 * Retrieval of all user's tasks
	 * @param API authentication token
	 * @return List of tasks
	 * @exception Throws HttpException for unsuccessful result
	 */
	List<Task> GetAllTasks(ApiToken token) throws HttpException;
	
	
	/**
	 * Create new task
	 * @param API authentication token
	 * @param Task's description
	 * @return Newly created task instance
	 * @exception Throws HttpException for unsuccessful result
	 */
	Task AddTask(ApiToken token, String description) throws HttpException;
	
	/**
	 * Delete task
	 * @param API authentication token
	 * @param Task's id
	 * @return id of deleted task
	 * @throws HttpException
	 */
	int DeleteTask(ApiToken apiToken, int taskId) throws HttpException;
	
	
	/**
	 * Start Task
	 * @param API authentication token
	 * @param taskId
	 * @return Started task instance
	 * @throws HttpException
	 */
	Task StartTask(ApiToken apiToken, int taskId) throws HttpException;
	
	/**
	 * Stop task
	 * @param API authentication token
	 * @param taskId
	 * @return Stopped task instance
	 * @throws HttpException
	 */
	Task StopTask(ApiToken apiToken, int taskId) throws HttpException;
	
	/**
	 * Stop all tasks
	 * @param API authentication token
	 * @throws HttpException
	 */
	void StartAll(ApiToken apiToken) throws HttpException;
	 
	/**
	 * Stop all tasks
	 * @param API authentication token
	 * @throws HttpException
	 */
	void StopAll(ApiToken apiToken) throws HttpException; 
	
}
