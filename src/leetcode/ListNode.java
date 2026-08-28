package leetcode;

import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode temp = this;
        while (temp != null) {
            sb.append(temp.val).append(" ");
            temp = temp.next;
        }
        return sb.toString().trim();
    }

    public static ListNode createLinkedList(List<Integer> nums) {
        ListNode l = new ListNode(nums.get(0));
        ListNode l_head = l;
        for (int i = 1; i < nums.size(); i++) {
            l.next = new ListNode(nums.get(i));
            l = l.next;
        }

        //print the linked list
        System.out.println("Linked List -> "+ l_head);

        return l_head;
    }
}
