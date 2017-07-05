package 二刷;

public class Seventyfive_SortColors {
	public void sortColors(int[] nums){
		int i = 0, j = nums.length - 1;
		int k = 0;
		while(k <= j){
			if(nums[k] == 0){
				swap(nums, i++, k++);
			}
			else if(nums[k] == 1){
				k++;
			}
			else{
				swap(nums, j--, k);
			}
		}
	}
	public void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
