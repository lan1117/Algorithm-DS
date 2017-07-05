package 二刷;

public class TwoEightyfive_InorderSuccessorInBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
		if(root == null) return null;
		if(root.val <= p.val){
			return inorderSuccessor(root.right, p);
		}else{
			TreeNode left = inorderSuccessor(root.left, p);
			return (left != null) ? left : root;
		}
	}
	public TreeNode predecessor(TreeNode root, TreeNode p){
		if(root == null) return null;
		if(root.val >= p.val){
			return predecessor(root.left, p);
		}else{
			TreeNode right = predecessor(root.right, p);
			return (right != null) ? right : root;
		}
	}
}
