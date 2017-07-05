package 二刷;

public class TwoThirtysix_LowestCommonAncestorOfABinaryTree {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root == null || root == p || root == q) return root;
		//recursion DFS
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		//when left and right both not empty (p and q)
		if(right != null && left != null){
			return root;
		}
		return left == null ? right : left;
	}
}
