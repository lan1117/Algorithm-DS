package 二刷;
import java.util.*;
public class TwoTwentynine_MajorityElementII {
	public List<Integer> majorityElement(int[] nums){
		List<Integer> res = new ArrayList<>();
		int count1 = 0, count2 = 0, candidate1 = nums[0], candidate2 = nums[0];
		for(int n : nums){
			if(n == candidate1){
				count1++;
			}
			else if(n == candidate2){
				count2++;
			}
			else if(count1 == 0){
				candidate1 = n;
				count1 = 1;
			}
			else if(count2 == 0){
				candidate2 = n;
				count2 = 1;
			}else{
				count1--;
				count2--;
			}
		}
		count1 = 0; count2 = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == candidate1){
				count1++;
			}else if(nums[i] == candidate2){
				count2++;
			}
		}
		if(count1 > nums.length / 3) res.add(candidate1);
		if(count2 > nums.length / 3) res.add(candidate2);
		return res;
	}
}
