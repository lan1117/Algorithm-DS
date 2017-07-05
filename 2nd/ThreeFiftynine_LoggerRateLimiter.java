package 二刷;
import java.util.*;

public class ThreeFiftynine_LoggerRateLimiter {
	Map<String, Integer> map;
	public ThreeFiftynine_LoggerRateLimiter(){
		map = new HashMap<>();
	}
	public boolean shouldPrintMessage(int timestamp, String message){
		if(!map.containsKey(message) || map.get(message) + 10 <= timestamp){
			map.put(message, timestamp);
			return true;
		}
		return false;
	}
}
