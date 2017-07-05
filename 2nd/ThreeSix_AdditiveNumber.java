package 二刷;

public class ThreeSix_AdditiveNumber {
	public boolean isAdditiveNumber(String num){
		for(int i = 1; i <= num.length() / 2; i++){
			//substring(0, i) exclusive i
			if(num.charAt(0) == '0' && i > 1) return false;
			for(int j = i+1; j < num.length(); j++){
				//substring(i, j) exclusive j
				if(num.charAt(i) == '0' && j-i > 1) break;
				if(dfs(num, 0, i, j)) return true;
			}
		}
		return false;
	}
	public boolean dfs(String num, int i, int j, int k){
		long num1 = Long.parseLong(num.substring(i, j));
		long num2 = Long.parseLong(num.substring(j, k));
		String sum = String.valueOf(num1+num2);
		if(!num.substring(k).startsWith(sum)) return false;
		if(k + sum.length() == num.length()) return true;
		return dfs(num, j, k, k+sum.length());
	}
}
