package 二刷;
import java.util.*;
public class Onetwentyeight_LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums){
		if(nums == null) return 0;
		Map<Integer, Integer> map = new HashMap<>();
		int max = 1;
		for(int n : nums){
			if(map.containsKey(n)){
				continue;
			}
			int left = map.getOrDefault(n - 1, 0);
			int right = map.getOrDefault(n+1, 0);
			int len = left + right + 1;
			map.put(n, len);
			map.put(n - left, len);
			map.put(n+right, len);
			max = Math.max(max, len);
		}
		return max;
	}
}
