package 二刷;

public class TwoSixtyfour_UglyNumberII {
	public int nthUglyNumber(int n){
		int count = 0;
		int[] dp = new int[n];
		dp[0] = 1;
		int fac2 = 2, fac3 = 3, fac5 = 5;
		int idx2 = 0, idx3 = 0, idx5 = 0;
		for(int i = 1; i < n; i++){
			dp[i] = Math.min(Math.min(fac2, fac3), fac5);
			if(fac2 == dp[i]) fac2 = 2 * dp[++idx2];
			if(fac3 == dp[i]) fac3 = 3 * dp[++idx3];
			if(fac5 == dp[i]) fac5 = 5 * dp[++idx5];
		}
		return dp[n-1];
	}
}
