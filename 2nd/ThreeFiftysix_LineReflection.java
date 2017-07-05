package 二刷;
import java.util.*;

public class ThreeFiftysix_LineReflection {
	public boolean isReflected(int[][] points){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		HashSet<String> set = new HashSet<>();
		for(int[] p : points){
			max = Math.max(max, p[0]);
			min = Math.min(min, p[0]);
			String str = p[0] + "a" + p[1];
			set.add(str);
		}
		int sum = max + min;
		for(int[] p : points){
			String str = (sum - p[0]) + "a" + p[1];
			if(!set.contains(str)){
				return false;
			}
		}
		return true;
	}
}
