package 二刷;
import java.util.*;
/*O(nlongn)
public class One_TwoSum {
	public int[] TwoSum(int[] nums, int target){
		int[] res = new int[2];
		Arrays.sort(nums);
		int i = 0, j = nums.length - 1;
		while(i < j){
			if(nums[i] + nums[j] == target){
				res[0] = i;
				res[1] = j;
			}
			else if(nums[i] + nums[j] < target){
				i++;
			}
			else{
				j--;
			}
		}
		return res;
	}
}*/

//O(n)
public class One_TwoSum{
	public int[] twoSum(int[] nums, int target){
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			map.put(nums[i], i);
		}
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
				res[0] = i;
				res[1] = map.get(target - nums[i]);
				break;
			}
		}
		return res;
	}
}
