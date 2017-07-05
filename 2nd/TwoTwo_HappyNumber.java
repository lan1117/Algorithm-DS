package 二刷;
import java.util.*;
public class TwoTwo_HappyNumber {
	public boolean ishappy(int n){
		HashSet<Integer> set = new HashSet<>();
		while(set.add(n)){
			int sum = 0;
			while(n > 0){
				int remain = n % 10;
				sum += remain * remain;
				n /= 10;
			}
			if(sum == 1) return true;
			n = sum;
		}
		return false;
	}
}
