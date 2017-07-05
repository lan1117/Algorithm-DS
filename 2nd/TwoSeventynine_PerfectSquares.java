package 二刷;

public class TwoSeventynine_PerfectSquares {
	public int numSquares(int n){
		int[] count = new int[n+1];
		for(int i = 1; i <= n; i++){
			count[i] = Integer.MAX_VALUE;
			for(int j = 1; j * j <= i; j++){
				count[i] = Math.min(count[i], count[i-j*j] + 1);
			}
		}
		return count[n];
	}
}
