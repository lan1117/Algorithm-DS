package 二刷;

import java.util.Arrays;
//O(n^2)
public class Sixteen_3SumClosest {
	public int threeSumColsest(int[] nums, int target){
		int res = nums[0] + nums[1] + nums[nums.length - 1];
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++){
			int lo = i+1, hi = nums.length - 1;
			while(lo < hi){
				int sum = nums[i] + nums[lo] + nums[hi];
				if(sum < target){
					lo++;
				}
				else{
					hi--;
				}
				if(Math.abs(sum - target) < Math.abs(res - target)){
					res = sum;
				}
			}
		}
		return res;
	}
}
