package datastructures.linkedlist;

class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  /*
    head
    9,11 => slow va fi 11
    head.next
    9,11 => slow va fi 9
   */

    private ListNode findMid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head; // why does it not work with fast = head; ?

        while ( fast != null && fast.next != null )
        {
            slow = slow.next;
            fast = fast.next.next;
        }
    

        return slow;
    }

    public ListNode sortList(ListNode head)
    {

        if (head == null || head.next == null ) { return head;}

        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        ListNode sleft  = sortList(left);
        ListNode sright = sortList(right);
        ListNode res = merge(sleft, sright);

        return res;
    }

    private ListNode merge(ListNode left, ListNode right)
    {



        ListNode dummy  = new ListNode(0);
        ListNode sorted = dummy;

        while ( left != null && right != null)
        {
            if (left.val <= right.val)
            {
                sorted.next = left;
                left = left.next;
            }
            else
            {
                sorted.next = right;
                right = right.next;
            }
            sorted = sorted.next;

        }

        if (left != null)
        {
            sorted.next = left;
        }

        if (right != null)
        {
            sorted.next = right;
        }

        return dummy.next;
    }

    public static void main(String[] args)
    {
        ListNode first = new ListNode(9);
        ListNode second = new ListNode (11);
        ListNode third = new ListNode(5);
        ListNode fourth = new ListNode(2);
        first.next = second;
        second.next = third;
        third.next = fourth;

        Solution s = new Solution();
        s.sortList(first);

    }

}
