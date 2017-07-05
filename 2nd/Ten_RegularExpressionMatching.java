package 二刷;

public class Ten_RegularExpressionMatching {
	public boolean isMatch(String s, String p){
		if(s == null || p == null) return false;
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m][n];
		dp[0][0] = true;
		for(int i = 1; i < n; i++){
			if(p.charAt(i) == '*'){
				dp[0][i+1] = dp[0][i-1];
			}
		}
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				if(s.charAt(i - 1) == p.charAt(j - 1)||p.charAt(j - 1) == '.'){
					dp[i][j] = dp[i - 1][j - 1];
				}
				else if(p.charAt(j - 1) == '*'){
					if(s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.'){
						dp[i][j] = dp[i][j - 2];
					}
					else{
						dp[i][j] = (dp[i - 1][j] || dp[i][j - 1] || dp[i][j-2]);
					}
				}
			}
		}
		return dp[m][n];
	}
}
