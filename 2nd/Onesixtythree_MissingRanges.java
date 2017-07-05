package 二刷;
import java.util.*;
public class Onesixtythree_MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper){
		List<String> res = new ArrayList<>();
		int next = lower;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] < next) continue;
			if(nums[i] == next){
				next++;
				continue;
			}
			res.add(getRange(next, nums[i] - 1));
			next = nums[i] + 1;
		}
		if(next <= upper) res.add(getRange(next, upper));
		return res;
	}
	public String getRange(int n1, int n2){
		return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
	}
}
