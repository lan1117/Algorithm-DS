package 二刷;
import java.util.*;
public class TwoNintysix_BestMeetingPoint {
	public int minTotalDistance(int[][] grid){
		int m = grid.length;
		int n = grid[0].length;
		List<Integer> I = new LinkedList<>();
		List<Integer> J = new LinkedList<>();
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(grid[i][j] == 1){
					I.add(i);
					J.add(j);
				}
			}
		}
		return getMin(I) + getMin(J);
	}
	public int getMin(List<Integer> list){
		int ret = 0;
		Collections.sort(list);
		int i = 0;
		int j = list.size() - 1;
		while(i < j){
			ret += list.get(j--) - list.get(i++);
		}
		return ret;
	}
}
