package 二刷;

public class Twentyseven_RemoveElement {
	public int removeElement(int[] nums, int val){
		int interposition = 0;
		for(int num : nums){
			if(num != val){
				nums[interposition++] = num;
			}
		}
		return interposition;
	}
}
