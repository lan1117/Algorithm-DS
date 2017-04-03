package BinaryTreenDivideConquer;

//import BinaryTreenDivideConquer.FlattenBinaryTreetoLinkedList.TreeNode;

//Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

//The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

public class lowestCommonAncestor {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode A, TreeNode B){
		if(root == null || root == A || root == B){
			return root;
		}
		//divide
		TreeNode left = lowestCommonAncestor1(root.left, A, B);
		TreeNode right = lowestCommonAncestor1(root.right, A, B);
		
		//conquer
		if(left != null && right != null){
			return root;
		}
		if(left != null){
			return left;
		}
		if(right != null){
			return right;
		}
		return null;
	}
}
