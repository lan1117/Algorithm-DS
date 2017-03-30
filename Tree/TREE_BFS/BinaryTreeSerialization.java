package BFS;
import java.util.*;

public class BinaryTreeSerialization {
	public class TreeNode{
		public int val;
		public TreeNode left, right;
		public TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}
	public String serialize(TreeNode root){
		StringBuilder res = new StringBuilder();
		if(root == null){
			return "{}";
		}
		res.append("{");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i ++){
				TreeNode head = queue.poll();
				if(head == null){
					res.append("#");
				}
				else if(head.left == null && head.right == null){
					res.append(String.valueOf(head.val)).append("}");
				}
				
				else{
					res.append(String.valueOf(head.val)).append(",");
				}
				if(head.left != null){
					queue.offer(head.left);
				}
				else if(head.left == null){
					queue.offer(null);
				}
				if(head.right != null){
					queue.offer(head.right);
				}
				else if(head.right == null){
					queue.offer(null);
				}
			}
		}
		return res.toString();
	}
	
	public void main(String[] argc){
		BinaryTreeSerialization max = new BinaryTreeSerialization();
		TreeNode head1 = new TreeNode(5);
		head1.left = new TreeNode(3);
		head1.right = new TreeNode(3);
		head1.left.left = new TreeNode(1);
		head1.left.right = new TreeNode(1);
		head1.right.left = new TreeNode(2);
		String res = max.serialize(head1);
		System.out.println(res);
	}
	
}
