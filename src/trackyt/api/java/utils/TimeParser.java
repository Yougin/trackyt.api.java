package trackyt.api.java.utils;

import trackyt.api.java.models.Time;

public class TimeParser {
	
    public static Time convertToTime(int receivedTime){
    	Time time = new Time();
    	
    	time.setHours(receivedTime / 3600);
    	time.setMinutes((receivedTime / 60) % 60);
    	time.setSeconds(receivedTime % 60);
    	
    	return time;
    }
    
}
	