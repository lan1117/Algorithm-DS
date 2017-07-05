package 二刷;

public class TwoEightythree_MoveZeros {
	public void moveZeros(int[] nums){
		int insertposition = 0;
		for(int num : nums){
			if(num != 0){
				nums[insertposition++] = num;
			}
		}
		while(insertposition < nums.length){
			nums[insertposition++] = 0;
		}
	}
}
