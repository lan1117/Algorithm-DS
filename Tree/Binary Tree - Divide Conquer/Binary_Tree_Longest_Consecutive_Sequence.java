package BinaryTreenDivideConquer;
//Given a binary tree, find the length of the longest consecutive sequence path.

//The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

public class Binary_Tree_Longest_Consecutive_Sequence {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	int res = Integer.MIN_VALUE;
	public int longestConsecutive(TreeNode root){
		helper(root);
		return res;
	}
	private int helper(TreeNode root){
		//corner case
		if(root == null){
			return 0;
		}
		//int length = 1;
		//divide
		int left = helper(root.left);
		int right = helper(root.right);
		
		//conquer
		int longestsubtree = 1;
		if(root.left != null && root.left.val == root.val + 1){
			longestsubtree = Math.max(longestsubtree,  left + 1);
		}
		if(root.right != null && root.right.val == root.val + 1){
			longestsubtree = Math.max(longestsubtree, right + 1);
		}
		if(longestsubtree > res){
			res = longestsubtree;
		}
		return longestsubtree;
	}
}
