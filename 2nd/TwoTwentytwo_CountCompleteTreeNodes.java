package 二刷;

public class TwoTwentytwo_CountCompleteTreeNodes {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	public int countNodes(TreeNode root){
		int node = 0, h = height(root);
		while(root != null){
			if(height(root.right) == h - 1){
				node += (1<<h);
				root = root.right;
			}
			else{
				node += (1 <<(h-1));
				root = root.left;
			}
			h--;
		}
		return node;
	}
	public int height(TreeNode root){
		return root == null ? -1 : 1+height(root.left);
	}
}
