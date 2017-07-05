package 二刷;
import java.util.*;
public class TwoSeventyfour_H_Index {
	public int hIndex(int[] citations){
		/*Arrays.sort(citations);
		int h_idx = 0;
		for(int i = 0; i < citations.length; i++){
			int count = citations.length - i;
			if(citations[i] >= count){
				return count;
			}
		}
		return h_idx;*/
		if(citations.length == 0) return 0;
		//Count the paper of different citation
		//all the paper with citation larger than total # of paper is counted in the last element
		//since h index cannot exceed the number of paper
		int[] count = new int[citations.length + 1];
		for(int num : citations){
			if(num > citations.length)
				count[citations.length]++;
			else
				count[num]++;
		}
		int result = 0;
		for(int i = citations.length; i>=0; i--){
			result += count[i];
			if(result >= i) return i;
		}
		return 0;
	}
}
