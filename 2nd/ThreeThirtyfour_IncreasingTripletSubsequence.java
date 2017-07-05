package 二刷;

public class ThreeThirtyfour_IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums){
		if(nums.length < 3) return false;
		int small = Integer.MAX_VALUE, sdSmall = Integer.MAX_VALUE;
		for(int n : nums){
			if(n <= small) small = n;
			else if(n <= sdSmall) sdSmall = n;
			else return true;
		}
		return false;
	}
}
