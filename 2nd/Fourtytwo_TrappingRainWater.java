package 二刷;

public class Fourtytwo_TrappingRainWater {
	public int trappingwater(int[] nums){
		if(nums == null || nums.length == 0) return 0;
		int l = 0, r = nums.length - 1, vol = 0;
		int lHeight = nums[l], rHeight = nums[r];
		while(l < r){
			if(lHeight < rHeight){
				l++;
				if(lHeight > nums[l]){
					vol += (lHeight - nums[l]);
				}
				else{
					lHeight = nums[l];
				}
			}
			else{
				r--;
				if(rHeight > nums[r]){
					vol += (rHeight - nums[r]);
				}
				else{
					rHeight = nums[r];
				}
			}
		}
		return vol;
	}
}
