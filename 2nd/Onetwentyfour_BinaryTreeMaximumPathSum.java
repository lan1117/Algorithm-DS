package 二刷;

public class Onetwentyfour_BinaryTreeMaximumPathSum {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	int max;
	public int maxPathSum(TreeNode root){
		if(root == null) return 0;
		max = Integer.MIN_VALUE; //FOR THE CASE OF just one negative number
		postOrder(root);
		return max;
	}
	//post-order traversal sum up from child
	public int postOrder(TreeNode node){
		if(node == null) return 0;
		int left = Math.max(postOrder(node.left), 0); //discard if smaller than 0
		int right = Math.max(postOrder(node.right), 0);
		max = Math.max(left + right + node.val, max);
		return Math.max(left, right) + node.val; //half of the node
	}
}
