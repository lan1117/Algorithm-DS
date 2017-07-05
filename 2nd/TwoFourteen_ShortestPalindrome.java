package 二刷;
import java.util.*;
public class TwoFourteen_ShortestPalindrome {
	public String shortestPalindrome(String s){
		String str = s + "#" + new StringBuilder(s).reverse().toString();
		int[] table = buildTable(str);
		return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
	}
	public int[] buildTable(String s){
		int[] table = new int[s.length() + 1]; // size = length + 1;
		int i = 0, j = -1;
		table[i] = -1; //no prefix and postfix for single character
		while(i < s.length()){
			while(j >= 0 && s.charAt(j) != s.charAt(i))
				j = table[j];
			i++;
			j++;
			table[i] = j;
		}
		return table;
	}
}
