package 二刷;

public class Onesixteen_PopulatingNextRightPointersInEachNode {
	class TreeLinkNode{
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x){val = x;}
	}
	public void connect(TreeLinkNode root){
		/*if(root == null) return;
		if(root.left != null){
			root.left.next = root.right;
			if(root.next != null){
				root.right.next = root.next.left;
			}
		}
		connect(root.left);
		connect(root.right);*/
		if(root == null) return;
		TreeLinkNode level = root;
		while(level != null){
			TreeLinkNode cur = level;
			while(cur != null){
				if(cur.left != null){
					cur.left.right = cur.right;
				}
				if(cur.right != null && cur.next != null){
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			level = level.left;
		}
	}
}
