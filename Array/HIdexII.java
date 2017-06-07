package Array;
import java.util.*;
/*
 * Follow up for H-Index: What if the citations array is sorted in ascending order? 
 * Could you optimize your algorithm?
 */

//Linear Search
//Return count with the first idx with citations[i] >= length - i; 

public class HIdexII {
	public int hIndex(int[] citations){
		int lo = 0, hi = citations.length - 1;
		while(lo <= hi){
			int mid = (lo+hi)>>1;
			if(citations[mid] == citations.length - mid) return citations.length - mid;
			else if(citations[mid] > citations.length - mid) hi = mid - 1;
			else lo = mid + 1;
		}
		return citations.length - lo;
	}
}
