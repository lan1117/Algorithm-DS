package 二刷;
import java.util.*;

public class Sixty_PermutationSequence {
	public String getPermutation(int n, int k){
		List<Integer> nums = new ArrayList<>(); //Pool of available numbers
		int[] fac = new int[n+1];
		fac[0] = 1;
		for(int i = 1; i <= n; i++){
			nums.add(i);
			fac[i] = fac[i-1] * i;
		}
		k--;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++){
			int idx = k/fac[n-i];			//Get the current number idx in the list
			sb.append(nums.get(idx));		//append to the result
			nums.remove(idx);				//remove the number from the pool
			k = k - idx * fac[n - i];
		}
		return sb.toString();
	}
}
