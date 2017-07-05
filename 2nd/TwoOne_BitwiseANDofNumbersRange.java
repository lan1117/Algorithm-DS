package 二刷;

public class TwoOne_BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int m, int n){
		//when n!= m there is at least one even and odd in the range thus last bit is 0
		int i = 0;
		while(n!=m){
			n>>=1;
			m>>=1;
			i++;
		}
		return m<<i;
	}
}
