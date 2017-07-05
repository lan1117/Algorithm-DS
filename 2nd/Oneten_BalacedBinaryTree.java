package 二刷;

public class Oneten_BalacedBinaryTree {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public boolean isBalanced(TreeNode root){
		return balanceTree(root) != -1;
	}
	public int balanceTree(TreeNode root){
		if(root == null) return 0;
		int left = balanceTree(root.left);
		if(left == -1) return -1;
		int right = balanceTree(root.right);
		if(right == -1) return -1;
		if(Math.abs(left - right) > 1) return -1;
		return 1 + Math.max(left, right);
	}
}
