package 二刷;
//Implement atoi to convert a string to an integer.
/*
 * Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first 
non-whitespace character is found. Then, starting from this character, 
takes an optional initial plus or minus sign followed by as many numerical digits 
as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number,
 which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral 
number, or if no such sequence exists because either str is empty or it contains 
only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. 
If the correct value is out of the range of representable values, 
INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class Eight_StringToInteger_ATOI {
	public int myAtoi(String str){
		//if null of no elements, return 0
		int result = 0;
		int sign = 1;
		if(str == null || str.length() < 1) return 0;
		int idx = 0;
		//erase white space
		while(str.charAt(idx) == ' ') idx++;
		//check the sign
		if(str.charAt(idx) == '+' || str.charAt(idx) == '-'){
			sign = str.charAt(idx) == '+' ? 1 : -1;
			idx++;
		}
		while(idx < str.length()){
			int n = str.charAt(idx) - '0';
			if(n < 0 || n > 9) return result*sign;
			if(Integer.MAX_VALUE /10 < result || Integer.MAX_VALUE / 10 == result && 7 < n){
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + n;
			idx++;
		}
		return result * sign;
	}
}
