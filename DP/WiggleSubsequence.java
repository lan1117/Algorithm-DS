package DP;

public class WiggleSubsequence {
	public int wiggleMaxLength(int[] nums){
		if(nums.length < 2) return nums.length;
		
		int[] preLarger = new int[nums.length];
		preLarger[0] = 1;
		int[] preSmaller = new int[nums.length];
		preSmaller[0] = 1;
		for(int i = 1; i < nums.length; i ++){
			preLarger[i] = 1; preSmaller[i] = 1;
			for(int j = 0; j < i; j ++){
				if(nums[i] > nums[j]){
					preLarger[i] = Math.max(preLarger[i], preSmaller[j] + 1);
				}
				else if(nums[j] > nums[i]){
					preSmaller[i] = Math.max(preSmaller[i], preLarger[j]+ 1);
				}
			}
		}
		return Math.max(preLarger[nums.length - 1], preSmaller[nums.length - 1]);
	}
}
