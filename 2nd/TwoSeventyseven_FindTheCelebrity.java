package 二刷;

public class TwoSeventyseven_FindTheCelebrity {
	public int findCelebrity(int n){
		int candidate = 0;
		for(int i = 0; i < n; i++){
			if(knows(candidate, i)){
				candidate = i;
			}
		}
		for(int i = 0; i < candidate; i++){
			if(knows(candidate, i) || !knows(i, candidate)) return -1;
		}
		for(int i = candidate + 1; i < n; i++){
			if(knows(candidate, i)) || !knows(i, candidate)) return -1;
		}
		return candidate;
	}
}
