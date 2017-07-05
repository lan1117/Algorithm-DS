package 二刷;

public class ThreeFourtyfour_ReverseString {
	public String reverseString(String s){
		int i = 0, j = s.length() - 1;
		char[] sArray = s.toCharArray();
		while(i < j){
			swap(sArray, i++, j--);
		}
		return String.valueOf(sArray);
	}
	public void swap(char[] sArray, int i, int j){
		char tmp = sArray[i];
		sArray[i] = sArray[j];
		sArray[j] = tmp;
	}
}
