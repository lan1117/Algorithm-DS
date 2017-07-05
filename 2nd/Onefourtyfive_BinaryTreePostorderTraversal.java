package 二刷;
import java.util.*;

public class Onefourtyfive_BinaryTreePostorderTraversal {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public List<Integer> postorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode top = stack.pop();
			res.add(top.val);
			if(top.left != null){
				stack.push(top.left);
			}
			if(top.right != null){
				stack.push(top.right);
			}
		}
		Collections.reverse(res);
		return res;
	}
	
}
