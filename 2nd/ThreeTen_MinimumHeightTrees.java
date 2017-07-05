package 二刷;
import java.util.*;

public class ThreeTen_MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges){
		List<Integer> res = new ArrayList<>();
		if(n == 1){
			res.add(0);
			return res;
		}
		List<Set<Integer>> list = new ArrayList<>();
		for(int i = 0; i < n; i++){
			list.add(new HashSet<>());
		}
		for(int[] edge : edges){
			list.get(edge[0]).add(edge[1]);
			list.get(edge[1]).add(edge[0]);
		}
		List<Integer> leaves = new ArrayList<>();
		for(int i = 0; i < n; i++){
			if(list.get(i).size() == 1) leaves.add(i);
		}
		while(n > 2){
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for(int leave : leaves){
				int j = list.get(leave).iterator().next();
				list.get(j).remove(leave);
				if(list.get(j).size() == 1) newLeaves.add(j);
			}
			leaves = newLeaves;
		}
		return leaves;
	}
}
