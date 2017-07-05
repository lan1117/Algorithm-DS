package 二刷;

public class Seventytwo_EditDistance {
	public int minDistance(String word1, String word2){
		int n = word1.length();
		int m = word2.length();
		int[][] cost = new int[n+1][m+1];
		for(int i = 0; i <= n; i++){
			cost[i][0] = i;
		}
		for(int i = 0; i <= m; i++){
			cost[0][i] = i;
		}
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					cost[i][j] = cost[i-1][j-1];
				}
				else{
					int c1 = cost[i-1][j]; //delete one char
					int c2 = cost[i][j-1]; //add one char
					int c3 = cost[i-1][j-1]; //replace one char
					cost[i][j] = Math.min(c1, Math.min(c3, c2)) + 1;
				}
			}
		}
		return cost[n][m];
	}
}
