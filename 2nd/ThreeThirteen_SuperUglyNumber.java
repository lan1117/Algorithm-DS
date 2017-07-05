package 二刷;

public class ThreeThirteen_SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes){
		int[] ugly = new int[n];
		ugly[0] = 1;
		int[] idx = new int[primes.length];
		int[] val = new int[primes.length];
		for(int i = 0; i < primes.length; i++) val[i] = primes[i];
		int min = 1;
		for(int i = 0; i < n; i++){
			ugly[i] = min;
			min = Integer.MAX_VALUE;
			for(int j = 0; j < primes.length; j++){
				if(val[j] == ugly[i]) val[j] = primes[j] * ugly[++idx[j]];
				min = Math.min(min, val[j]);
			}
		}
		return ugly[n-1];
	}
}
