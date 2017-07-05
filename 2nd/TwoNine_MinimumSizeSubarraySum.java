package 二刷;

public class TwoNine_MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums){
		//subarray not subset
		if(nums == null || nums.length == 0) return 0;
		//use two pointer i, j to maintain a window with sum larger than s
		int i = 0, j = 0, sum = 0, min  = Integer.MAX_VALUE;
		while(j < nums.length){
			sum += nums[j++];
			while(sum >= s){
				min = Math.min(min, j-i);
				sum -= nums[i++];
			}
		}
		return min == Integer.MAX_VALUE ? 0: min;
	}
}
