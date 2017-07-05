package 二刷;

public class Seven_ReverseInteger {
	public int reverse(int x){
		int reverse = 0;
		while(x != 0){
			if(Integer.MAX_VALUE / 10 < Math.abs(reverse)) return 0;
			reverse = reverse * 10 + x % 10;
			x /= 10;
		}
		return reverse;
	}
}
