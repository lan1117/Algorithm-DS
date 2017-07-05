package 二刷;

public class TwoThirtyeight_ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums){
		int len = nums.length;
		int[] res = new int[len];
		res[0] = 1;
		for(int i = 1; i < len; i++){
			res[i] = res[i-1] * nums[i-1];
		}
		int last = 1;
		for(int j = len - 1; j >= 0; j--){
			res[j] *= last;
			last *= nums[j];
		}
		return res;
	}
}
