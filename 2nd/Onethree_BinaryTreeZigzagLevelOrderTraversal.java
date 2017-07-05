package 二刷;
import java.util.*;
public class Onethree_BinaryTreeZigzagLevelOrderTraversal {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty()){
			List<Integer> tempList = new ArrayList<>();
			if(s2.isEmpty()){
				while(!s1.isEmpty()){
					TreeNode top = s1.pop();
					tempList.add(top.val);
					if(top.left != null){
						s2.push(top.left);
					}
					if(top.right != null){
						s2.push(top.right);
					}
				}
				res.add(new ArrayList<>(tempList));
			}
			else{
				while(!s2.isEmpty()){
					TreeNode top = s2.pop();
					tempList.add(top.val);
					if(top.right != null){
						s1.push(top.right);
					}
					if(top.left != null){
						s1.push(top.left);
					}
				}
				res.add(new ArrayList<>(tempList));
			}
		}
		return res;
	}
}
