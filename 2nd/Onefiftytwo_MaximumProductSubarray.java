package 二刷;

public class Onefiftytwo_MaximumProductSubarray {
	public int maxProduct(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		int preMax = nums[0];
		int preMin = nums[0];
		int max = nums[0], min = nums[0];
		int maxSoFar = max;
		for(int i = 1; i < nums.length; i++){
			max = Math.max(Math.max(preMax * nums[i], preMin * nums[i]), nums[i]);
			min = Math.min(Math.min(preMax * nums[i], preMin * nums[i]), nums[i]);
			
			preMax = max;
			preMin = min;
			maxSoFar = Math.max(maxSoFar, max);
		}
		return maxSoFar;
	}
}
