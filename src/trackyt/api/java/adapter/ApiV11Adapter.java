package trackyt.api.java.adapter;

import java.util.List;

import org.apache.http.HttpException;

import trackyt.api.java.TrackytApiAdapter;
import trackyt.api.java.exceptions.NotAuthenticatedException;
import trackyt.api.java.models.ApiToken;
import trackyt.api.java.models.Task;
import trackyt.api.java.responses.AuthenticationResponse;
import trackyt.api.java.responses.CreateTaskResponse;
import trackyt.api.java.responses.GetAllTasksResponse;
import trackyt.api.java.utils.RequestMaker;

import com.google.gson.Gson;

public class ApiV11Adapter implements TrackytApiAdapter {

	RequestMaker requestMaker;

	public ApiV11Adapter() {
		requestMaker = RequestMaker.getInstance();
	}

	@Override
	public ApiToken authenticate(String email, String password)
			throws NotAuthenticatedException {
		
		String receivedString;
		
		try {
			receivedString = requestMaker.authenticate(email, password);
		} catch (HttpException e) {
			throw new NotAuthenticatedException();
		}
		
		AuthenticationResponse authResponse = new Gson().fromJson(receivedString, AuthenticationResponse.class);

		if (!authResponse.success) {
			throw new NotAuthenticatedException();
		}
		
		ApiToken apiToken = new ApiToken(authResponse.getApiToken());
		
		return apiToken;
	}

	@Override
	public List<Task> getAllTasks(ApiToken token) throws Exception {
		String receivedString;
		
		try {
			receivedString = requestMaker.getAllTasks(token);
		} catch (HttpException e) {
			throw new Exception("Request/Response from/to server was unsuccessful");
		}
		
		GetAllTasksResponse response = new Gson().fromJson(receivedString, GetAllTasksResponse.class);
		
		if (!response.success) {
			throw new Exception("Get all tasks operation was unsuccessful");
		}
		
		return response.getTasksList();
	}

	@Override
	public Task addTask(ApiToken token, String description) throws Exception {
		String receivedString;
		
		try {
			receivedString = requestMaker.addTask(token, description);
		} catch (HttpException e) {
			throw new Exception("Request/Response from/to server was unsuccessful");
		}
		
		CreateTaskResponse response = new Gson().fromJson(receivedString, CreateTaskResponse.class);
		
		if (!response.success) {
			throw new Exception("Add task operation was unsuccessful");
		}
		
		return response.getTask();
	}

	@Override
	public int deleteTask(ApiToken apiToken, int taskId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Task startTask(ApiToken apiToken, int taskId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task stopTask(ApiToken apiToken, int taskId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startAll(ApiToken apiToken) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void stopAll(ApiToken apiToken) throws Exception {
		// TODO Auto-generated method stub

	}

}
