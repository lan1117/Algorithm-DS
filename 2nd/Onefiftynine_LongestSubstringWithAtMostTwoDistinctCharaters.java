package 二刷;
import java.util.*;
public class Onefiftynine_LongestSubstringWithAtMostTwoDistinctCharaters {
	public int lengthOfLongestSubstring(String s){
		if(s.length() < 1) return 0;
		HashMap<Character, Integer> index = new HashMap<>();
		int lo = 0, hi = 0, maxLength = 0;
		while(hi < s.length()){
			if(index.size() <= 2){
				char c = s.charAt(hi);
				index.put(c, hi);
				hi++;
			}
			if(index.size() > 2){
				int leftMost = s.length();
				for(int i : index.values()){
					leftMost = Math.min(leftMost, i);
				}
				char c = s.charAt(leftMost);
				index.remove(c);
				lo = leftMost + 1;
			}
			maxLength = Math.max(maxLength, hi-lo);
		}
		return maxLength;
	}
}
