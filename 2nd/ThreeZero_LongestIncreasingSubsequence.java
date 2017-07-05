package 二刷;
import java.util.*;
public class ThreeZero_LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums){
		/*if(nums == null || nums.length == 0) return 0;
		int[] dp = new int[nums.length];
		for(int i = 0; i < nums.length; i++){
			dp[i] = 1;
			for(int j = 0; j < i; j++){
				if(nums[j] < nums[i]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int res = 0;
		for(int num : dp){
			res = Math.max(res, num);
		}
		return res;*/
		//Construct a list to record the LIS
		List<Integer> list = new ArrayList<>();
		for(int num : nums){
			int size = list.size();
			//if the list is empty add the new number
			//if the list last element(biggest) is smaller, add it
			if(size == 0 || list.get(size - 1) < num){
				list.add(num);
			}else{
				//binary search
				int i = 0, j = size - 1;
				while(i < j){
					int mid = i + (j - i) / 2;
					if(list.get(mid) < num) i = mid+1;
					else j = mid;
				}
				list.set(j, num);
			}
		}
		return list.size();
	}
}
