package trackyt.api.java;

import trackyt.api.java.adapter.ApiV11Adapter;

public class TrackytApiAdapterFactory {
	public static TrackytApiAdapter createV11Adapter() {
		return new ApiV11Adapter();
	}
}
