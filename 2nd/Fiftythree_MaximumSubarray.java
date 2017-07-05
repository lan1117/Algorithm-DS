package 二刷;

public class Fiftythree_MaximumSubarray {
	public int maxSubArray(int[] nums){
		int maxEnd = nums[0];
		int maxSoFar = nums[0];
		for(int i = 1; i < nums.length; i++){
			maxEnd = Math.max(maxEnd + nums[i], nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEnd);
		}
		return maxSoFar;
	}
}
