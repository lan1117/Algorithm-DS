package 二刷;

public class Oneseventeen_PopulatingNextRightPointersInEachNodeII {
	class TreeLinkNode{
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x){val = x;}
	}
	public void connect(TreeLinkNode root){
		TreeLinkNode d = new TreeLinkNode(0);
		TreeLinkNode cur = d;
		while(root != null){ //level by level
			while(root != null){ //node by node
				if(root.left != null){
					cur.next = root.left;
					cur = cur.next;
				}
				if(root.right != null){
					cur.next = root.right;
					cur = cur.next;
				}
				root = root.next;
			}
			root = d.next;
			d.next = null;
			cur = d;
		}
	}
}
