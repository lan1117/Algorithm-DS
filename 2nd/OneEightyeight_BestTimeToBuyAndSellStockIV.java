package 二刷;

public class OneEightyeight_BestTimeToBuyAndSellStockIV {
	public int maxProfit(int k, int[] prices){
		int len = prices.length;
		if(len < 2 || prices == null) return 0;
		
		//when k >= len/2, maxProfit can be reached
		if(k >= len/2){
			int p = 0;
			for(int i = 1; i < len; i++){
				if(prices[i] > prices[i-1])
					p += prices[i] - prices[i-1];
			return p;
			}
		}
		int[][] profit = new int[k+1][len];
		for(int i = 1; i < k+1; i++){
			int tmpMax = -prices[0];
			for(int j = 1; j < len; j++){
				//tmpMax stores the value to hold from previous profit
				tmpMax = Math.max(tmpMax, profit[i-1][j-1] - prices[j]);
				//hold the max profit so far kth transition and jth day in the week
				profit[i][j] = Math.max(profit[i][j-1], prices[j] + tmpMax);
			}
		}
		return profit[k][len-1];
	}
}
