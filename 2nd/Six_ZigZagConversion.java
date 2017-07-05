package 二刷;

public class Six_ZigZagConversion {
	public String convert(String s, int numRows){
		if(numRows<=1) return s;
		StringBuilder[] str = new StringBuilder[numRows];
		for(int i = 0; i < numRows; i++){
			str[i] = new StringBuilder();
		}
		int row = 0;
		boolean down = false;
		for(int i = 0; i < s.length(); i++){
			if(row == 0) down = true;
			if(row == numRows-1){
				down = false;
			}
			str[row].append(s.charAt(i));
			if(down) row++;
			else row--;
		}
		for(int j = 1; j < numRows; j++){
			str[0].append(str[j]);
		}
		return str[0].toString();
	}
}
