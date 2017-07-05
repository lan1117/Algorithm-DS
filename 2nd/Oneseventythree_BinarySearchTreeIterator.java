package 二刷;
import java.util.*;
public class Oneseventythree_BinarySearchTreeIterator {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	Stack<TreeNode> stack;
	public Oneseventythree_BinarySearchTreeIterator(TreeNode root){
		stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null){
			stack.push(cur);
			cur = cur.left;
		}
	}
	public boolean hasNext(){
		return !stack.isEmpty();
	}
	public int next(){
		TreeNode node = stack.pop();
		TreeNode cur = node;
		if(cur.right != null){
			cur = cur.right;
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
		}
		return node.val;
	}
}
