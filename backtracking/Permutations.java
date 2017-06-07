package backtracking;
import java.util.*;
//Given a collection of distinct numbers, return all possible permutations.
public class Permutations {
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, nums, new ArrayList<>());
		return list;
	}
	private void backtrack(List<List<Integer>> list, int[] nums, List<Integer> tempList){
		if(tempList.size() == nums.length){
			list.add(new ArrayList<>(tempList));
		}
		else{
			for(int i = 0; i < nums.length; i ++){
				if(tempList.contains(nums[i])) continue;
				tempList.add(nums[i]);
				backtrack(list, nums, tempList);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
