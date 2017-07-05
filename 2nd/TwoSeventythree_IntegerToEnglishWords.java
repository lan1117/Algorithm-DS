package 二刷;

public class TwoSeventythree_IntegerToEnglishWords {
	private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] TENS = {"", "Ten", "Twenty", "Thirty","Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
	public String numberToWords(int num){
		if(num == 0) return "Zero";
		String res = "";
		int th = 0;
		while(num > 0){
			if(num % 1000 != 0)
				res = helper(num % 1000) + THOUSANDS[th] + " " + res;
			th++;
			num /= 1000;
		}
		return res.trim();
	}
	public String helper(int n){
		if(n == 0){
			return "";
		}
		if(n < 20){
			return LESS_THAN_20[n] + " ";
		}
		if(n < 100){
			return TENS[n / 10] + " " + helper(n % 10);
		}
		return LESS_THAN_20[n / 100] + " Hundred " + helper(n % 100);
	}
}
