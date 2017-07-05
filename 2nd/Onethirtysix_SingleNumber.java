package 二刷;

public class Onethirtysix_SingleNumber {
	public int singleNumber(int[] nums){
		int ans = 0;
		for(int i = 0; i < nums.length; i++){
			ans ^= nums[i];
		}
		return ans;
	}
}
