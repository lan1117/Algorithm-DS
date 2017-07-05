package 二刷;
import java.util.*;

public class Onetwo_BinaryTreeLevelOrderTraversal {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public List<List<Integer>> levelOrder(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;
		queue.offer(root);
		//int level = 1;
		while(!queue.isEmpty()){
			List<Integer> tempList = new ArrayList<>();
			int size = queue.size();
			while(size > 0){
				TreeNode top = queue.poll();
				tempList.add(top.val);
				if(top.left != null){
					queue.offer(top.left);
				}
				if(top.right != null){
					queue.offer(top.right);
				}
				size--;
			}
			res.add(new ArrayList<>(tempList));
		}
		return res;
	}
}
