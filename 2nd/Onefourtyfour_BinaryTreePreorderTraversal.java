package 二刷;
import java.util.*;
public class Onefourtyfour_BinaryTreePreorderTraversal {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> res = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		if(root != null) stack.push(root);
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
