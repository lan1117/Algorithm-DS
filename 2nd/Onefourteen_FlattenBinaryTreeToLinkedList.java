package 二刷;

public class Onefourteen_FlattenBinaryTreeToLinkedList {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	//preorder
	private TreeNode lastNode = null;
	public void flatten(TreeNode root){
		if(root == null){
			return;
		}
		if(lastNode != null){
			lastNode.left = null;
			lastNode.right = root;
		}
		lastNode = root;
		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);
	}
}
