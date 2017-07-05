package 二刷;

public class ThreeThirtyfive_SelfCrossing {
	public boolean isSelfCrossing(int[] x){
		int n = x.length;
		if(n <= 3) return false;
		for(int i = 3; i < n; i++){
			if(x[i] >= x[i-2] && x[i-1] <= x[i-3]){
				return true; //4th cross with 1st
			}
			if(i >= 4 && x[i-1] == x[i-3] && x[i] + x[i-4] >= x[i-2])
				return true; //5th meet with 1st
			if(i >= 5 && x[i-2] >= x [i-4] && x[i] >= x[i-2] - x[i-4] && x[i-1] >= x[i-3] - x[i-5] && x[i-1] <= x[i-3]){
				return true; //6th cross with 1st
			}
		}
		return false;
	}
}
