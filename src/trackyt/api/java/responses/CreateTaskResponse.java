package trackyt.api.java.responses;

import trackyt.api.java.models.Task;


public class CreateTaskResponse extends BaseResponse {
	CreateTaskResponseData data;
	
	public Task getTask() {
		return data.getTask();
	}
}

class CreateTaskResponseData {
	Task task;
	
	public Task getTask() {
		return task;
	}
}
