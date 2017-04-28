package DP;
/*
 * Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 */
public class UglyNumber {
	public int nthUglyNumber(int n){
		int[] dp = new int[n];
		dp[0] = 1;
		int idx2 = 0, idx3 = 0, idx5 = 0;
		int fac2 = 2, fac3 = 3, fac5 = 5;
		for(int i = 1; i < n; i++){
			dp[i] = Math.min(Math.min(fac2, fac3), fac5);
			if(fac2==dp[i]) fac2 = 2 * dp[++idx2];
			if(fac3==dp[i]) fac3 = 3 * dp[++idx3];
			if(fac5==dp[i]) fac5 = 5 * dp[++idx5];
		}
		return dp[n - 1];
	}
}
