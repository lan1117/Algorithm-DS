package 二刷;
import java.util.*;
public class Fourtyseven_PermutationsII {
	public List<List<Integer>> permutation(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		backtrack(res, nums, new ArrayList<>(), new boolean[nums.length]);
		return res;
	}
	public void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tempList, boolean[] used){
		if(tempList.size() == nums.length){
			res.add(new ArrayList<>(tempList));
			return;
		}
		else{
			for(int i = 0; i < nums.length; i++){
				if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
				tempList.add(nums[i]);
				used[i] = true;
				backtrack(res, nums, tempList, used);
				tempList.remove(tempList.size() - 1);
				used[i] = false;
			}
		}
	}
}
