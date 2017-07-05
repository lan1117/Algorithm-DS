package 二刷;
import java.util.*;

public class ThreeFourty_LongestSubstringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k){
		if(s.length() <= k) return s.length();
		Map<Character, Integer> map = new HashMap<>();
		int lo = 0, hi = 0, longest = 0;
		while(hi < s.length()){
			if(map.size() <= k){
				char c = s.charAt(hi);
				map.put(c, hi);
				hi++;
			}
			if(map.size() > k){
				int lowindex = s.length();
				for(int i : map.values())
					lowindex = Math.min(lowindex, i);
				char c = s.charAt(lowindex);
				map.remove(c);
				lo = lowindex+1;
			}
			longest = Math.max(longest, hi - lo);
		}
		return longest;
	}
}
