package 二刷;

public class Onetwentyone_BestTimeToBuyandSellStock {
	public int maxProfit(int[] prices){
		/*int maxCur = 0;
		int maxProf = 0;
		for(int i = 1; i < prices.length; i++){
			maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
			maxProf = Math.max(maxProf, maxCur);
		}
		return maxProf;*/
		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;
		for(int i = 0; i < prices.length; i++){
			if(prices[i] < minprice){
				minprice = prices[i];
			}
			else if(prices[i] - minprice > maxprofit){
				maxprofit = prices[i] - minprice;
			}
		}
		return maxprofit;
	}
}
