package 二刷;
import java.util.*;

public class ThreeSixtyeight_LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums){
		List<Integer> res = new LinkedList<>();
		if(nums == null || nums.length == 0) return res;
		
		if(nums.length < 2){
			res.add(nums[0]);
			return res;
		}
		//record the length of longest subset
		//maxIdx is the index of last element that is within the subset
		int[] len = new int[nums.length];
		len[0] = 0;//record the max length for each element
		int[] parent = new int[nums.length]; //record the previous element in the subset for backtrack
		int maxLen = 0, maxIdx = 0;
		//sort the array in ascending order, if the new larger element can be
		//divided by the largest in the subset, then it can be divided by all the elements in the subset
		Arrays.sort(nums);
		for(int i = nums.length - 1; i >= 0; i--){
			for(int j = i; j < nums.length; j++){
				if(nums[j] % nums[i] == 0 && len[i] < 1+len[j]){
					len[i] = 1+len[j]; //update the length if longer one is found
					parent[i] = j; //update the parent index
					if(len[i] > maxLen){
						maxLen = len[i];
						maxIdx = i;
					}
				}
			}
		}
		for(int i = 0; i < maxLen; i++){
			res.add(nums[maxIdx]);
			maxIdx = parent[maxIdx];
		}
		return res;
	}
}
