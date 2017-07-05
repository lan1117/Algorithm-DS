package 二刷;

public class Onesixtyseven_TwoSumII {
	public int[] twoSum(int[] number, int target){
		int[] res = new int[2];
		int i = 0, j = number.length - 1;
		while(i < j){
			if(number[i] + number[j] == target){
				res[0] = i + 1;
				res[1] = j + 1;
				return res;
			}
			if(number[i] + number[j] < target){
				i++;
			}
			else{
				j--;
			}
		}
		return res;
	}
}
