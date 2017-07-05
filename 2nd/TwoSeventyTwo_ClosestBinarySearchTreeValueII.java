package 二刷;
import java.util.*;
public class TwoSeventyTwo_ClosestBinarySearchTreeValueII {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public List<Integer> closestKValues(TreeNode root, double target, int k){
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		inorder(root, target, stack1, false);
		inorder(root, target, stack2, true);
		
		List<Integer> res = new ArrayList<>();
		while(k-- > 0){
			if(stack1.isEmpty()){
				res.add(stack2.pop());
			}
			else if(stack2.isEmpty()){
				res.add(stack1.pop());
			}
			else if(Math.abs(stack1.peek() - target) > Math.abs(stack2.peek()- target)){
				res.add(stack2.pop());
			}
			else{
				res.add(stack1.pop());
			}
		}
		return res;
	}
	public void inorder(TreeNode root, double target, Stack<Integer> stack, boolean reverse){
		if(root == null) return;
		inorder(reverse ? root.right : root.left, target, stack, reverse);
		
		if((reverse && root.val <= target) || (!reverse && root.val > target)){
			return;
		}
		stack.push(root.val);
		
		inorder(reverse ? root.left : root.right, target, stack, reverse);
	}
}
