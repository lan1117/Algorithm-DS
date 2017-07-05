package 二刷;
import java.util.*;
public class Seventyeight_Subsets {
	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, nums, new ArrayList<>(), 0);
		return res;
	}
	public void backtrack(List<List<Integer>> res, int[] nums, List<Integer> tempList, int start){
		res.add(new ArrayList<>(tempList));
		for(int i = start; i < nums.length; i++){
			tempList.add(nums[i]);
			backtrack(res, nums, tempList, i+1);
			tempList.remove(tempList.size() - 1);
		}
	}
}
