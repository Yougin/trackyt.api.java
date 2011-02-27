package trackyt.api.java.responses;

import trackyt.api.java.models.Task;

public class StopTaskResponse extends BaseResponse{
	StopTaskResponseData data;
	
	public Task getTask() {
		return data.getTask();
	}
}

class StopTaskResponseData {
	Task task;
	
	public Task getTask() {
		return task;
	}
}