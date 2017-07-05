package 二刷;
import java.util.*;

public class Fourtysix_Permutations {
	public List<List<Integer>> permutation(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length == 0) return res;
		backtrack(res, nums, new ArrayList<>());
		return res;
	}
	public void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tempList){
		if(tempList.size() == nums.length){
			res.add(new ArrayList<>(tempList));
			return;
		}
		else{
			for(int i = 0; i < nums.length; i++){
				if(tempList.contains(nums[i])) continue;
				tempList.add(nums[i]);
				backtrack(res, nums, tempList);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
