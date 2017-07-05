package 二刷;

public class TwoFiftysix_PaintHouse {
	public int minCost(int[][] costs){
		if(costs == null || costs.length == 0) return 0;
		int m = costs.length;
		int Prered = costs[0][0], Preblue = costs[0][1], Pregreen = costs[0][2];
		int cost = Math.min(Prered, Math.min(Preblue, Pregreen));
		for(int i = 1; i < m; i++){
			int red = Math.min(Preblue, Pregreen) + costs[i][0];
			int blue = Math.min(Prered, Pregreen) + costs[i][1];
			int green = Math.min(Prered, Preblue) + costs[i][2];
			
			cost = Math.min(Math.min(red, blue), green);
			Prered = red;
			Preblue = blue;
			Pregreen = green;
		}
		return cost;
	}
}
