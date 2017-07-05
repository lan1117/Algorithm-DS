package 二刷;

public class TwoSeventyeight_FirstBadVersion {
	public int firstBadVersion(int n){
		if(n == 0) return -1;
		int lo = 0, hi = n-1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(!isBadVersion(mid)){
				lo = mid + 1;
			}else{
				hi = mid;
			}
		}
		return isBadVersion(lo) ? lo : -1;
	}
}
