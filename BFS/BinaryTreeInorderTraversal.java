package BFS;
import java.util.*;

public class BinaryTreeInorderTraversal {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.push(root);
				root = root.left;
			}
			TreeNode cur = stack.pop();
			res.add(cur.val);
			root = cur.right;
		}
		return res;
		
	}
}
