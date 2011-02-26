package trackyt.api.java.responses;

import trackyt.api.java.responses.BaseResponse;

public class AuthenticationResponse extends BaseResponse {
	
	public Data data;
	
	public String getApiToken() {
		return data.getApiToken();
	}
	
}

class Data {
	public String apiToken;

	public Data() {
		
	}
	public String getApiToken() {
		return apiToken;
	}

	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}
	
}