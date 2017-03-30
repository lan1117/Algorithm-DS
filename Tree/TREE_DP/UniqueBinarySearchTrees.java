package Tree_DP;
//Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

//For example,
//Given n = 3, there are a total of 5 unique BST's.
public class UniqueBinarySearchTrees {
	public int numTrees(int n){
		int[] G = new int[n + 1];
		G[0] = 1; //no node, one condition
		G[1] = 1; //one node, one condition
		//G[n]: root is n
		//G[n] = F(1, n) + F(2, n) + F(3, n) + ...+ F(n, n)
		//F(i, n) = G(i - 1) * G(n - i);
		//G[n] += G[i - 1] * G[n - i]
		for(int i = 2; i <= n; i ++){
			for(int j = 1; j <= i; j ++){
				G[i] += G[i - 1] * G[n - i];
			}
		}
		return G[n];
	}
}
