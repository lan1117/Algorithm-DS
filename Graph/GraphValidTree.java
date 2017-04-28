package graph;
import java.util.*;
import java.util.Arrays;

/*
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Note: you can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class GraphValidTree {
	public boolean validTree(int n, int[][] edges){
		List<Set<Integer>> adj = new ArrayList<>();
		HashMap<Integer, Integer> degree = new HashMap<>();
		int gree = 0;
		for(int i = 0; i < n; i++){
			adj.add(new HashSet<>());
		}
		for(int[] edge : edges){
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
			if(!degree.containsKey(edge[0]) && !degree.containsKey(edge[1])){
				degree.put(edge[0], gree);
				degree.put(edge[1], gree);
				gree += 1;
			}
			else if(!degree.containsKey(edge[0]) && degree.containsKey(edge[1])){
				int gree1 = degree.get(edge[1]);
				degree.put(edge[0], gree1);
				gree += 1;
			}
			else if(!degree.containsKey(edge[1]) && degree.containsKey(edge[0])){
				int gree2 = degree.get(edge[0]);
				degree.put(edge[1], gree2);
				gree += 1;
			}
			else if(degree.containsKey(edge[0]) && degree.containsKey(edge[1]) && degree.get(edge[0]) == degree.get(edge[1])){
				gree += 1;
				continue;
			}
			else if(degree.containsKey(edge[0]) && degree.containsKey(edge[1]) && degree.get(edge[0]) != degree.get(edge[1])){
				int gree3 = degree.get(edge[0]);
				int gree4 = degree.get(edge[1]);
				for(int in : degree.keySet()){
					if(degree.get(in) == gree4){
						degree.put(in, gree3);
					}
				}
				gree++;
			}
		}
		int deg = degree.get(0);
		for(int i : degree.keySet()){
			if(degree.get(i) != deg) return false;
		}
		List<Integer> leaves = new ArrayList<>();
		for(int i = 0; i < n; i++){
			if(adj.get(i).size() == 1) leaves.add(i);
		}
		while(n > 2){
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for(int i : leaves){
				int j = adj.get(i).iterator().next();
				adj.get(j).remove(i);
				if(adj.get(j).size() == 1) newLeaves.add(j);
			}
			if(newLeaves.size() == 0) return false;
			else leaves = newLeaves;
		}
		return true;
	}
}
