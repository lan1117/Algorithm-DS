package 二刷;
import java.util.*;
public class Fifteen_3Sum {
	public List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length < 3) return res;
		Arrays.sort(nums);
		int n = nums.length;
		for(int i = 0; i < n-2; i++){
			if(i > 0 && nums[i] == nums[i - 1]){
				continue;
			}
			int lo = i+1, hi = n-1;
			while(lo < hi){
				int sum = nums[i] + nums[lo] + nums[hi];
				if(sum == 0){
					res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
					lo++;
					hi--;
					while(lo < n && nums[lo] == nums[lo - 1]) lo++;
					while(hi >= 0 && nums[hi] == nums[hi + 1]) hi--;
				}
				else if(sum < 0){
					lo++;
				}
				else{
					hi--;
				}
			}	
		}
		return res;
	}
}
