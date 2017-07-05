package 二刷;
import java.util.*;

public class Eightynine_GrayCode {
/*
 the purpose of this function is to convert an unsigned binary number to reflected
 binary gray code.
 the operator >> is shift right. The operator ^ is exclusive or.
 
 unsigned int binaryToGray(unsigned int num){
 	return (num >> 1) ^ num;
 }
 
 the purpose of this function is to convert a reflected binary Gray code number to
 a binary number.
 
 unsigned int grayToBinary(unsigned int num){
 	unsigned int mask;
 	for(mask = num >> 1; mast != 0; mask = mask >> 1){
 		num = num ^ mask;
 	}
 	return num;
 }
 */
	public List<Integer> grayCode(int n){
		List<Integer> res = new LinkedList<>();
		for(int i = 0; i < 1 << n; i++){
			res.add((i>>1)^i);
		}
		return res;
	}
}
