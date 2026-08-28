package leetcode;

import java.util.List;


/**
 *
 * 24. Swap Nodes in Pairs
 * Medium
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 */
public class SwapLinkedListInPairs {



    public static void main(String[] args) {
        List<Integer> nums =  List.of(1,2,3,4);
        //ListNode node = new ListNode(nums.get(0));

        // create the singly linked list using the list of integers
        ListNode head = new ListNode(nums.get(0));
        ListNode curr = head;
        for (int i = 1; i < nums.size(); i++) {
            curr.next = new ListNode(nums.get(i));
            curr = curr.next;
        }

        //print the linked list
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

        ListNode result = swapInPairs(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();

    }

    private static ListNode swapInPairs(ListNode head) {
        //base case
        if(head==null || head.next==null) return head;

        //set prev and curr
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;


        //swap
        while(curr!=null && curr.next!=null){

            ListNode first = curr;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
            curr = first.next;
        }

        return dummy.next;
    }


}


// Definition for singly-linked list.

