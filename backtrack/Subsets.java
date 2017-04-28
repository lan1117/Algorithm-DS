package backtracking;
import java.util.*;
//the output should be non desending
public class Subsets {
	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(res, new ArrayList<>(), nums, 0);
		return res;
	}
	public void backtrack(List<List<Integer>> res, List<Integer> templist, int[] nums, int start){
		res.add(new ArrayList<>(templist));
		for(int i = start; i < nums.length; i ++){
			templist.add(nums[i]);
			backtrack(res, templist, nums, i + 1);
			templist.remove(templist.size() - 1);
		}
	}
}
