package 二刷;

public class TwoTwentysix_InvertBinaryTree {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public TreeNode invertTree(TreeNode root){
		if(root == null) return root;
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		
		root.left = right;
		root.right = left;
		return root;
	}
}
