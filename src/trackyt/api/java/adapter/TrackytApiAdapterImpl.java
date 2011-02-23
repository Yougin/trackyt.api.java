package trackyt.api.java.adapter;

import java.util.List;

import org.apache.http.HttpException;

import trackyt.api.java.TrackytApiAdapter;
import trackyt.api.java.exceptions.NotAuthenticatedException;
import trackyt.api.java.models.ApiToken;
import trackyt.api.java.models.Task;

public class TrackytApiAdapterImpl implements TrackytApiAdapter {

	@Override
	public ApiToken Authenticate(String email, String password)
			throws NotAuthenticatedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> GetAllTasks(ApiToken token) throws HttpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task AddTask(ApiToken token, String description)
			throws HttpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int DeleteTask(ApiToken apiToken, int taskId) throws HttpException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Task StartTask(ApiToken apiToken, int taskId) throws HttpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task StopTask(ApiToken apiToken, int taskId) throws HttpException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void StartAll(ApiToken apiToken) throws HttpException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void StopAll(ApiToken apiToken) throws HttpException {
		// TODO Auto-generated method stub
		
	}

}
