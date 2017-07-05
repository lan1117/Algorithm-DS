package 二刷;

public class TwoSeventyfive_HIndexII {
	public int hIndex(int[] citations){
		//linear search
		//return count with the first idx with citations[i] >= length - i;
		int lo = 0, hi = citations.length - 1;
		while(lo + 1 < hi){
			int mid = lo + (hi - lo) / 2;
			if(citations[mid] == citations.length - mid) return citations.length - mid;
			else if(citations[mid] > citations.length - mid) hi = mid;
			else lo = mid;
		}
		return citations.length - lo;
	}
}
