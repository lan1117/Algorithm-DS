package 二刷;
import java.util.*;

public class ThreeFive_NumberOfIslandsII {
	int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public List<Integer> numIslands2(int m, int n, int[][] position){
		List<Integer> res = new ArrayList<>();
		if(m <= 0 || n <= 0) return res;
		
		int count = 0;
		int[] roots = new int[m*n];
		Arrays.fill(roots, -1);
		
		for(int[] p : position){
			int root = n * p[0] + p[1];				//assume new point is isolated isloand
			roots[root] = root;						//add new island
			count++;
			
			for(int[] dir : dirs){
				int x = p[0] + dir[0];
				int y = p[1] + dir[1];
				int nb = x * n + y;
				if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) continue;
				
				int rootNb = findIsland(roots, nb);
				if(root != rootNb){					//if neighbor is in another island
					roots[root] = rootNb;			//union two islands
					root = rootNb;					//current tree root = joined tree root
					count--;
				}
			}
			res.add(count);
		}
		return res;
	}
	public int findIsland(int[] roots, int id){
		while(id != roots[id]){
			roots[id] = roots[roots[id]];
			id = roots[id];
		}
		return id;
	}
}
