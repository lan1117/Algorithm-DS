package 二刷;
import java.util.*;
public class TwoSixteen_CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n){
		if(n <= 0) return null;
		if(k > 9) k = 9;
		List<List<Integer>> res = new ArrayList<>();
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		//backtrack(res, nums, k, n, 0, new ArrayList<>());
		backtrack(res, new ArrayList<>(), k, n, 1);
		return res;
	}
	/*public void backtrack(List<List<Integer>> res, int[] nums, int k, int remain, int start, List<Integer> tempList){
		if(remain < 0) return;
		if(remain > 0 && tempList.size() >= k) return;
		if(tempList.size() == k && remain == 0){
			res.add(new ArrayList<>(tempList));
			return;
		}
		for(int i = start; i < nums.length; i++){
			tempList.add(nums[i]);
			backtrack(res, nums, k, remain - nums[i], i+1, tempList);
			tempList.remove(tempList.size() - 1);
		}*/
	public void backtrack(List<List<Integer>> res, List<Integer> tempList, int k, int n, int idx){
		if(n == 0 && tempList.size() == k){
			res.add(new ArrayList<>(tempList));
			return;
		}
		if(n <= 0 || tempList.size() >= k){
			return;
		}
		for(int i = idx; i < 10; i++){
			tempList.add(i);
			backtrack(res, tempList, k, n - i, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}
