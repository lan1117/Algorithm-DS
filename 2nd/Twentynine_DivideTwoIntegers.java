package 二刷;

public class Twentynine_DivideTwoIntegers {
	public int divide(int dividend, int divisor){
		long ans = 0;
		int sign = 1;
		if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) sign = -1;
		if(divisor == 0) return Integer.MAX_VALUE;
		if(dividend == 0) return 0;
		long long_dividend = Math.abs((long)dividend);
		long long_divisor = Math.abs((long)divisor);
		while(long_dividend >= long_divisor){
			long tmp = long_divisor;
			long i = 1;
			while(long_dividend >= tmp){
				long_dividend -= tmp;
				ans += i;
				i<<=1;
				tmp<<=1;
			}
		}
		if(ans > Integer.MAX_VALUE){
			return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		return (sign == -1) ? (int) ans : (int)-ans;
	}
}
