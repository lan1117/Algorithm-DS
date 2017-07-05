package 二刷;

public class TwoFour_CountPrimes {
	public int Prime(int n){
		boolean[] primes = new boolean[n];
		int count = 0;
		for(int i = 2; i < n; i++){
			if(primes[i] == false){
				count++;
				for(int j = 2; j * i < n; j++){
					primes[i*j] = true;
				}
			}
		}
		return count;
	}
}
