package 二刷;
import java.util.*;
public class Onethirtyfive_Candy {
	public int candy(int[] ratings){
		int[] can = new int[ratings.length];
		Arrays.fill(can, 1);
		int n = ratings.length;
		for(int i = 1; i < n; i++){
			if(ratings[i] > ratings[i-1]){
				can[i] = can[i-1] + 1;
			}
		}
		for(int i = n - 2; i >= 0; i--){
			if(ratings[i] > ratings[i+1]){
				can[i] = Math.max(can[i], can[i+1]+1);
			}
		}
		int sum = 0;
		for(int c : can){
			sum += c;
		}
		return sum;
	}
}
