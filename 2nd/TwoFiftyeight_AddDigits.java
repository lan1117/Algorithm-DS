package 二刷;

public class TwoFiftyeight_AddDigits {
	public int addDigits(int num){
		return num == 0 ? 0 : (num % 9 == 0 ? 9 : num % 9);
	}
}
