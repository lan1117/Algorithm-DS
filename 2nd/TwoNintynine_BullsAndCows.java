package 二刷;
import java.util.*;
public class TwoNintynine_BullsAndCows {
	public String getHint(String secret, String guess){
		if(secret == null || secret.length() == 0 || guess == null || guess.length() ==0) return "";
		int bull = 0, cows = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < secret.length(); i++){
			if(secret.charAt(i) == guess.charAt(i)){
				bull++;
			}else{
				int j = map.getOrDefault(secret.charAt(i), 0) + 1;
				map.put(secret.charAt(i), j);
			}
		}
		for(int i = 0; i < guess.length(); i++){
			char c = guess.charAt(i);
			if(map.containsKey(c)){
				cows++;
				int j = map.get(c);
				if(--j == 0){
					map.remove(c);
				}
			}
		}
		return bull + "A" + cows + "B";
	}
}
