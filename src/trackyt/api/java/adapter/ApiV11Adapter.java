package trackyt.api.java.adapter;

import java.util.List;

import trackyt.api.java.TrackytApiAdapter;
import trackyt.api.java.exceptions.NotAuthenticatedException;
import trackyt.api.java.models.ApiToken;
import trackyt.api.java.models.Task;

public class ApiV11Adapter implements TrackytApiAdapter {

	@Override
	public ApiToken authenticate(String email, String password)
			throws NotAuthenticatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getAllTasks(ApiToken token) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task addTask(ApiToken token, String description)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
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
