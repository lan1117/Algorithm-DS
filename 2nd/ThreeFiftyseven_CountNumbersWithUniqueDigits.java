package 二刷;

public class ThreeFiftyseven_CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n){
		int res = 10;
		if(n == 0) return 1;
		if(n == 1) return 10;
		
		int fac = 81;
		for(int i = 2; i <= n && i <= 10; i++){
			res += fac;
			fac *= (10-i);
		}
		return res;
	}
}
