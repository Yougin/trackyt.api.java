package trackyt.api.java.responses;

import trackyt.api.java.models.Task;

public class StartTaskResponse extends BaseResponse{
	StartTaskResponseData data;
	
	public Task getTask() {
		return data.getTask();
	}
}

class StartTaskResponseData {
	Task task;
	
	public Task getTask() {
		return task;
	}
}
