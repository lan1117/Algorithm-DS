package 二刷;
import java.util.*;
public class Onenintynine_BinaryTreeRightSideView {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){this.val = x;}
	}
	public List<Integer> rightSideView(TreeNode root){
		List<Integer> res = new ArrayList<>();
		rightSide(res, root, 0);
		return res;
	}
	public void rightSide(List<Integer> res, TreeNode root, int level){
		if(root == null) return;
		if(level == res.size()){
			res.add(root.val);
		}
		rightSide(res, root.right, level+1);
		rightSide(res, root.left, level + 1);
	}
}
