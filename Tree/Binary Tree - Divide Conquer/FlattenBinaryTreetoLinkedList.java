package BinaryTreenDivideConquer;
//Flatten a binary tree to a fake "linked list" in pre-order traversal.

//Here we use the right pointer in TreeNode as the next pointer in ListNode.

public class FlattenBinaryTreetoLinkedList {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	private TreeNode lastNode = null;
	public void flatten(TreeNode root){
		if(root == null){
			return;
		}
		if(lastNode != null){
			lastNode.left = null;
			lastNode.right = root;
		}
		lastNode = root; //visit itself
		TreeNode right = root.right; //mark right
		flatten(root.left); //call it self to traverse the node's left
		flatten(right); //call it self to traverse the node's right
	}
}
