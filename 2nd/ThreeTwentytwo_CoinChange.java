package 二刷;

public class ThreeTwentytwo_CoinChange {
	public int coinChange(int[] coins, int amount){
		if(coins.length == 0 || coins == null) return -1;
		if(amount == 0) return 0;
		int[] count = new int[amount + 1];
		for(int i = 0; i <= amount; i++){
			count[i] = Integer.MAX_VALUE;
			for(int j = 0; j < coins.length; j++){
				if(i == coins[j]) count[i] = 1;
				else if(i < coins[j]) continue;
				else if(count[i-coins[j]] == Integer.MAX_VALUE) continue;
				else{
					count[i] = Math.min(count[i], count[i-coins[j]] + 1);
				}
			}
		}
		return count[amount] == Integer.MAX_VALUE ? -1 : count[amount];
	}
}
