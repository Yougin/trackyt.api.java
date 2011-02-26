package trackyt.api.java.adapter;

import java.util.List;

import org.apache.http.HttpException;

import trackyt.api.java.TrackytApiAdapter;
import trackyt.api.java.exceptions.NotAuthenticatedException;
import trackyt.api.java.models.ApiToken;
import trackyt.api.java.models.Task;
import trackyt.api.java.responses.AuthenticationResponse;
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
		
		AuthenticationResponse authResponse = new AuthenticationResponse();
		authResponse = new Gson().fromJson(receivedString, AuthenticationResponse.class);

		if (!authResponse.success) {
			throw new NotAuthenticatedException();
		}
		
		ApiToken apiToken = new ApiToken(authResponse.getApiToken());
		
		return apiToken;
	}

	@Override
	public List<Task> getAllTasks(ApiToken token) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task addTask(ApiToken token, String description) throws Exception {
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
