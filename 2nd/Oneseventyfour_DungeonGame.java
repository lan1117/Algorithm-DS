package 二刷;

public class Oneseventyfour_DungeonGame {
	class save{
		int blood;
		int bsoFar;
		public save(int blood, int bsoFar){
			this.blood = blood;
			this.bsoFar = bsoFar;
		}
	}
	public int calculateMinimumHP(int[][] dungeon){
		/*int m = dungeon.length;
		int n = dungeon[0].length;
		save[][] dp = new save[m][n];
		dp[0][0] = dungeon[0][0] <= 0 ? new save(dungeon[0][0] * (-1) + 1, 1): new save(0, dungeon[0][0]);
		for(int i = 1; i < dungeon.length; i++){
			int cur = dp[i-1][0].bsoFar + dungeon[i][0];
			dp[i][0] = cur <= 0 ? new save(cur * (-1) + 1 + dp[i-1][0].blood, 1) : new save(dp[i-1][0].blood, dp[i-1][0].bsoFar + dungeon[i][0]);
		}
		for(int i = 1; i < dungeon[0].length; i++){
			int cur = dp[0][i - 1].bsoFar + dungeon[0][i];
			dp[0][i] = cur <= 0 ? new save(cur * (-1) + 1 + dp[0][i-1].blood, 1) : new save(dp[0][i-1].blood, dp[0][i-1].bsoFar + dungeon[i][0]);
		}
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				int curleft = dp[i][j-1].bsoFar + dungeon[i][j];
				int curup = dp[i-1][j].bsoFar + dungeon[i][j];
				int bloodneedleft = (curleft <= 0) ? (curleft * (-1) + 1 + dp[i][j-1].blood) : dp[i][j-1].blood;
				int bloodneedtop = (curup <= 0) ? (curup * (-1) + 1 + dp[i-1][j].blood) : dp[i-1][j].blood;
				int bloodsofarleft = (curleft <= 0) ? 1 : dp[i][j-1].bsoFar + dungeon[i][j];
				int bloodsofartop = (curup <= 0) ? 1 : dp[i-1][j].bsoFar + dungeon[i][j];
				if(bloodneedleft < bloodneedtop){
					dp[i][j] = new save(bloodneedleft, bloodsofarleft);
				}
				else if(bloodneedleft > bloodneedtop){
					dp[i][j] = new save(bloodneedtop, bloodsofartop);
				}
				else{
					dp[i][j] = bloodsofarleft > bloodsofartop ? new save(bloodneedleft, bloodsofarleft) : new save(bloodneedtop, bloodsofartop);
				}
			}
		}
		return dp[m-1][n-1].blood;*/
		if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){
            return 0;
        }
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] hp = new int[n+1][m+1];
        //Padding with MAX_VALUE
        for(int i=0; i<n; i++)
            hp[i][m] = Integer.MAX_VALUE;
        for(int j=0; j<m; j++)
            hp[n][j] = Integer.MAX_VALUE;
        hp[n][m-1] = 1;
        hp[n-1][m] = 1; //At least 1 hitpoint to stay alive at last cell
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                int hitpoint = Math.min(hp[i+1][j], hp[i][j+1]) - dungeon[i][j];
                hp[i][j] = hitpoint <= 0? 1:hitpoint;
            }
        }
        return hp[0][0];
	}
}
