package 二刷;

public class Twentyone_MergeTwoSortedLists {
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
	public ListNode MergeTwo(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null) return null;
		if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
		ListNode dummy = new ListNode(0);
		ListNode newNode = dummy;
		while(l1 != null && l2 != null){
				if(l1.val > l2.val){
					newNode.next = new ListNode(l2.val);
					l2 = l2.next;
					newNode = newNode.next;
				}
				else{
					newNode.next = new ListNode(l1.val);
					l1 = l1.next;
					newNode = newNode.next;
				}
		}
		if(l1 != null){
			newNode.next = l2;
		}
		if(l2 != null){
			newNode.next = l1;
		}
		return dummy.next;
	}
}
