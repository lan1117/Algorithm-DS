package 二刷;

public class Fourtythree_MultiplyString {
	public String multiply(String num1, String num2){
		int l1 = num1.length(), l2 = num2.length();
		int[] res = new int[l1 + l2];
		for(int i = l1 - 1; i >= 0; i--){
			for(int j = l2 - 1; j>= 0; j--){
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = mul + res[p2];
				res[p1] += sum / 10;
				res[p2] = sum % 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int num : res){
			if(!(sb.length() == 0 && num == 0)){
				sb.append(num);
			}
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
}
