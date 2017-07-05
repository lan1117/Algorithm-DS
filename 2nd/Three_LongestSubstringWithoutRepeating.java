package 二刷;
import java.util.*;
public class Three_LongestSubstringWithoutRepeating {
	public int LongestSubstring(String s){
		if(s == null || s.length() == 0) return 0;
		if(s.length() == 1) return 1;
		HashSet<Character> set = new HashSet<>();
		int i = 0, j = 0;
		int ans = 0;
		while(i < s.length() && j < s.length()){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			}
			else{
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}
}
