package BFS;

public class ValidateBinarySearchTree {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	private TreeNode prev = null;
	private int lastVal = Integer.MIN_VALUE;//最左边的数
	public boolean isValidBFS(TreeNode root){
		if(root == null){
			return true;
		}
		if(!isValidBFS(root.left)) return false;
		
		if(prev != null && lastVal >= root.val) return false;
		prev = root;
		lastVal = root.val;
		
		if(!isValidBFS(root.right)) return false;
		return true;
	}
}
