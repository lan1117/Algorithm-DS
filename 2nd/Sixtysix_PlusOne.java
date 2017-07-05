package 二刷;

public class Sixtysix_PlusOne {
	public int[] plusone(int[] digits){
		//999
		//[][0][0][0]
		int n = digits.length;
		for(int i = n - 1; i >= 0; i--){
			if(digits[i] < 9){
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		int[] res = new int[n + 1];
		res[0] = 1;
		return res;
	}
}
