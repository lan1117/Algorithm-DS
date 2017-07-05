package 二刷;

public class Onesix_ConstructBTFromInorderAndPostorderTraversal {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val = x;}
	}
	//int postlength;
	int postIdex;
	public TreeNode generate(int[] inorder, int[] postorder){
		if(inorder == null || inorder.length == 0) return null;
		postIdex = postorder.length - 1;
		return construct(inorder, postorder, 0, inorder.length - 1);
	}
	public TreeNode construct(int[] inorder, int[] postorder, int start, int end){
		if(start > end) return null;
		TreeNode node = new TreeNode(postorder[postIdex--]);
		if(start == end) return node;
		int inIdex = search(inorder, node, start, end);
		
		node.right = construct(inorder, postorder, inIdex+1, end);
		node.left = construct(inorder, postorder, start, inIdex - 1);
		
		return node;
	}
	public int search(int[] inorder, TreeNode node, int start, int end){
		for(int i = start; i <= end; i++){
			if(inorder[i] == node.val){
				return i;
			}
		}
		return -1;
	}
}
