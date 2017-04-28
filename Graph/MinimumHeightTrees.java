package graph;
import java.util.*;
/*For a undirected graph with tree characteristics, we can choose any node as the root. 
 * The result graph is then a rooted tree. Among all possible rooted trees, 
 * those with minimum height are called minimum height trees (MHTs). 
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. 
You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]
 * 
 */
//For a tree we can do some thing similar. We start from every end, by end we mean vertex of degree 1 (aka leaves). 
//We let the pointers move the same speed. When two pointers meet, we keep only one of them, 
//until the last two pointers meet or one step away we then find the roots.

//It is easy to see that the last two pointers are from the two ends of the longest path in the graph.

//The actual implementation is similar to the BFS topological sort. 
//Remove the leaves, update the degrees of inner vertexes. Then remove the new leaves. 
//Doing so level by level until there are 2 or 1 nodes left. What's left is our answer!
public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][]edges){
		List<Integer> res = new ArrayList<>();
		if(n == 1){
			res.add(edges[0][0]);
			return res;
		}
		List<Set<Integer>> adj = new ArrayList<>(n);
		for(int i = 0; i < n; i++){
			adj.add(new HashSet<>());
		}
		for(int[] edge : edges){
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
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
			leaves = newLeaves;
		}
		return leaves;
	}
}
