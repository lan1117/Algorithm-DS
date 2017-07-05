package 二刷;

public class ThreeNine_BestTimeToBuyAndSellStockWithCooldown {
	public int maxProfit(int[] prices){
		if(prices == null || prices.length <= 1) return 0;
		int preBuy = -prices[0], preSell1 = 0, preSell2 = 0, buy = 0, sell = 0;
		for(int i = 1; i < prices.length; i++){
			sell = Math.max(preSell1, preBuy + prices[i]);
			buy = Math.max(preBuy, preSell2 - prices[i]);
			
			preSell2 = preSell1;
			preSell1 = sell;
			preBuy = buy;
		}
		return sell;
	}
}
