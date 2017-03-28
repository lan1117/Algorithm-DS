package BinaryTreenDivideConquer;
//Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

public class Minimum_Subtree {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	private int min = Integer.MAX_VALUE;
	private TreeNode subtree = null;
	public TreeNode findSubtree(TreeNode root){
		helper(root);
		return subtree;
	}
	private int helper(TreeNode root){
		//corner case
		if(root == null){
			return 0;
		}
		//divide
		int left = helper(root.left);
		int right = helper(root.right);
		
		//conquer
		int sum = left + right + root.val;
		if(sum < min){
			min = sum;
			subtree = root;
		}
		return sum;
	}
}
