package 二刷;

public class TwoThirteen_HourseRobberII {
	public int rob(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		return Math.max(rob2(nums, 0, nums.length - 2), rob2(nums, 1, nums.length - 1));
	}
	public int rob2(int[] nums, int lo, int high){
		int robPre = nums[lo], notRobPre = 0;
		for(int i = lo + 1; i <= high; i++){
			int rob = notRobPre + nums[i];
			int not = Math.max(robPre, notRobPre);
			robPre = rob;
			notRobPre = not;
		}
		return Math.max(robPre, notRobPre);
	}
}
