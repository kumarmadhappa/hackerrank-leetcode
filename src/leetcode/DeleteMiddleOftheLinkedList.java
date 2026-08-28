package leetcode;

import java.util.List;

import static leetcode.ListNode.createLinkedList;

public class DeleteMiddleOftheLinkedList {

    public ListNode bruteForce(ListNode head){

        if(head==null || head.next==null){
            return null;
        }

        int n=0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        int deleteIndex = n/2;
        int i=0;
        ListNode curr = head;
        while(i<=deleteIndex && curr!=null){
            if(i==deleteIndex-1){
                curr.next = curr.next.next;
                break;
            }
            i++;
            curr = curr.next;

        }
        return head;
    }

    public ListNode optimized(ListNode head){

        //we will use 2 pointer, slow and fast,
        // slow moves 1 step, fast moves 2 step.
        //so when fast reaches the end of the list, slow will be at the middle
        // now we can swap the middle element using slow pointer

        if(head==null || head.next==null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;
        //ListNode prev = null;

        while(fast!=null && fast.next!=null){
            //prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;

    }

    public static void main(String[] args) {
        DeleteMiddleOftheLinkedList prob = new DeleteMiddleOftheLinkedList();
        List<Integer> l1_nums =  List.of(1,2,3,4,5);
        ListNode l1_head = createLinkedList(l1_nums);

        ListNode res = prob.bruteForce(l1_head);
        System.out.println("Result -> "+ res);
        System.out.println("Result -> "+prob.bruteForce(createLinkedList(List.of(1,3,4,7,1,2,6))));
        System.out.println("Result -> "+prob.bruteForce(createLinkedList(List.of(1))));

        System.out.println("OPTIMISED:");
        System.out.println("Result optimized -> "+prob.optimized(createLinkedList(List.of(1,2,3,4,5))));
        System.out.println("Result optimized -> "+prob.optimized(createLinkedList(List.of(1,3,4,7,1,2,6))));
        System.out.println("Result optimized -> "+prob.optimized(createLinkedList(List.of(1))));


    }


}
