package 二刷;

public class Eightysix_PartitionList {
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
	public ListNode partition(ListNode head, int x){
		ListNode lessNode = new ListNode(-1);
		ListNode lesscur = lessNode;
		ListNode moreNode = new ListNode(0);
		ListNode morecur = moreNode;
		while(head != null){
			if(head.val >= x){
				morecur.next = new ListNode(head.val);
				head = head.next;
				morecur = morecur.next;
			}
			else{
				lesscur.next = new ListNode(head.val);
				head = head.next;
				lesscur = lesscur.next;
			}
		}
		lesscur.next = moreNode;
		morecur.next = null;
		return lessNode;
	}
}
