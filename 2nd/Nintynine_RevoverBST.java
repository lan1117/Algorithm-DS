package 二刷;

public class Nintynine_RevoverBST {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	TreeNode first = null;
	TreeNode second = null;
	TreeNode pre = null;
	public void recoverTree(TreeNode root){
		if(root == null) return;
		inorder(root);
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}
	public void inorder(TreeNode node){
		if(node == null) return;
		inorder(node.left);
		if(pre!= null && first == null && node.val <= pre.val){
			first = pre; //first wrong node
		}
		if(first != null && node.val <= pre.val){
			second = node;
		}
		pre = node;
		inorder(node.right);
	}
}
