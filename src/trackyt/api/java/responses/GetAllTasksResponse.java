package trackyt.api.java.responses;

import java.util.ArrayList;
import java.util.List;

import trackyt.api.java.models.Task;

public class GetAllTasksResponse extends BaseResponse {
	public GetAllTasksData data;

	public List<Task> getTasksList() {
		return data.getTasksList();
	}
}

class GetAllTasksData {
	
	List<Task> tasksList = new ArrayList<Task>();
	
	public GetAllTasksData() {
		
	}
	
	public List<Task> getTasksList() {
		return tasksList;
	}
}