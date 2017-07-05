package 二刷;

public class Onenintyeight_HouseRobber {
	public int rob(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		int preRob = nums[0];
		int preNotRob = 0;
		for(int i = 1; i < nums.length; i++){
			int Rob = preNotRob + nums[i];
			int NotRob = Math.max(preNotRob, preRob);
			
			preRob = Rob;
			preNotRob = NotRob;
		}
		return Math.max(preRob, preNotRob);
	}
}
