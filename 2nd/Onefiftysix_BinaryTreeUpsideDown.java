package 二刷;

public class Onefiftysix_BinaryTreeUpsideDown {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	public TreeNode upsideDownBinaryTree(TreeNode root){
		if(root == null || root.left == null) return root;
		TreeNode node = upsideDownBinaryTree(root.left);
		node.left = root.right;
		node.right = root;
		root.left = null;
		root.right = null;
		return node;
	}
}
