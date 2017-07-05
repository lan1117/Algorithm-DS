package 二刷;

public class TwoThirty_KthSmallestElementInAaBST {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	int count;
	int num;
	public int kthSmallest(TreeNode root, int k){
		count = k;
		inorder(root);
		return num;
	}
	public void inorder(TreeNode root){
		if(root == null) return;
		inorder(root.left);
		count--;
		if(count == 0){
			num = root.val;
			return;
		}
		inorder(root.right);
	}
}
