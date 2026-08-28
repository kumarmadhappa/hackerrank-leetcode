package leetcode;


import java.util.List;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        //  head
        //  2 -> 4 -> 3

        //prev = null
        //1st time   null <- 2    4 -> 3, prev is now 2, curr is 4
        //2nd time   null <- 2 <- 4    3, prev is 4,     curr is 3
        //3rd rime   null <- 2 <- 4 <- 3, prev is 2,  curr is null

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode nextNode = curr.next;   // Saving the next element
            curr.next = prev;                // prev will point to next element
            prev = curr;                     // curr will become prev
            curr = nextNode;                 // the next element will become the current element
        }
        return prev;
    }

    private void reverseLinkedList(ListNode node, ListNode rev) {
        if (node.next==null)
            rev.next=node;

        else reverseLinkedList(node.next,rev);

    }

    public static void main(String[] args) {
        ReverseLinkedList prob = new ReverseLinkedList();
        List<Integer> l1_nums =  List.of(1,2,3,4,5);
        ListNode l1 = new ListNode(l1_nums.get(0));
        ListNode l1_head = l1;
        for (int i = 1; i < l1_nums.size(); i++) {
            l1.next = new ListNode(l1_nums.get(i));
            l1 = l1.next;
        }
        ListNode l1_tail = l1;

        //print the linked list
        System.out.println("L1 -> "+ l1_head);
        System.out.println("L1 -> "+ l1_tail);

        ListNode res = prob.reverseList(l1_head);

        System.out.println("Result -> "+ res);

    }
}
