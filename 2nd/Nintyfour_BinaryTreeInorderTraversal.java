package 二刷;
import java.util.*;
public class Nintyfour_BinaryTreeInorderTraversal {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public List<Integer> inorderTraversal(TreeNode root){
		//recursive
		/*List<Integer> res = new ArrayList<>();
		if(root.left != null){
			inorderTraversal(root.left);
		}
		res.add(root.left.val);
		if(root.right != null){
			inorderTraversal(root.right);
		}
		return res;*/
		//non-recursive
		List<Integer> res = new LinkedList<>();
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
