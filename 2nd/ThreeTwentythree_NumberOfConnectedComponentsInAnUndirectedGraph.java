package 二刷;
import java.util.*;

public class ThreeTwentythree_NumberOfConnectedComponentsInAnUndirectedGraph {
	int[] root;
	public int countComponents(int n, int[][] edges){
		if(edges == null || edges.length == 0 || edges[0].length == 0) return 0;
		root = new int[n];
		for(int i = 0; i < n; i++){
			root[i] = i;
		}
		for(int[] edge : edges){
			int root1 = find(edge[0]);
			int root2 = find(edge[1]);
			if(root1 != root2){
				root[root1] = root[root2];
				n--;
			}
		}
		return n;
	}
	public int find(int i){
		while(i != root[i]){
			root[i] = root[root[i]];
			i = root[i];
		}
		return root[i];
	}
}
