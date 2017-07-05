package 二刷;

public class Onethirtytwo_PalindromePartitioningII {
	public int minCut(String s){
		char[] ch = s.toCharArray();
		int n = s.length();
		int[] dp = new int[n];
		boolean[][]pali = new boolean[n][n];
		
		for(int i = 0; i < n; i++){
			int min = i;
			for(int j = 0; j <= i; j++){
				if(ch[i] == ch[j] && (j + 1 > i - 1 || pali[j+1][i-1])){
					//valid palindrom
					min = j == 0 ? 0 : Math.min(min, dp[j-1] + 1);
					pali[j][i] = true;
				}
			}
			dp[i] = min;
		}
		return dp[n-1];
	}
}
