package 二刷;

public class Nintysix_UniqueBinarySearchTrees {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public int numTrees(int n){
		int[] G = new int[n+1];
		G[0] = 1; //no node, 1 condition
		G[1] = 1; //one node, 1 condition
		//G[n]: root is n
		//G[n] = F(1, n) + F(2, n) + F(3, n) + ... + F(n, n)
		//F(i, n) = G(i - 1) * G(n-i);
		//G[n] += G[i-1] * G[n-i]
		for(int i = 2; i < n+1; i++){
			for(int j = 1; j <= i; j++){
				G[i] += G[j-1] * G[i-j];
			}
		}
		return G[n];
	}
}
