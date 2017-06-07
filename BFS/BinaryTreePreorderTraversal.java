package BFS;
import java.util.*;

//Given a binary tree, return the preorder traversal of its nodes' values.
public class BinaryTreePreorderTraversal {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if(root != null){
			stack.push(root);
		}
		while(!stack.isEmpty()){
			TreeNode cur = stack.pop();
			res.add(cur.val);
			if(cur.right != null){
				stack.push(cur.right);
			}
			if(cur.left != null){
				stack.push(cur.left);
			}
		}
		return res;
	}
}
