package DP;

/*
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, 
 * return -1.
 */

/*f[n] = Math.min(f[n - nums[0]], f[n - nums[1], f[n - nums[2]...) + 1, */
/*if not available, f[n] = Integer.MAX_VALUE*/
public class CoinChange {
	public int coinChange(int[] coins, int amount){
		if(coins == null || coins.length == 0) return -1;
		if(amount == 0) return 0;
		int[] count = new int[amount + 1];
		for(int i = 0; i <= amount; i ++){
			count[i] = Integer.MAX_VALUE;
			for(int j = 0; j <coins.length; j ++){
				if(i - coins[j] == 0) count[i] = 1;
				else if(i < coins[j]) ;
				else if(count[i - coins[j]] == Integer.MAX_VALUE) ;
				else{
					count[i] = Math.min(count[i], 1 + count[i - coins[j]]);
				}
			}
		}
		if(count[amount] == Integer.MAX_VALUE) return -1;
		return count[amount];
	}
}
