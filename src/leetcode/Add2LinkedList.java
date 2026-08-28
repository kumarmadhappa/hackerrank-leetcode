package leetcode;

import java.util.List;
import java.util.Optional;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Add2LinkedList {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        addNodeSum(l1, l2, res);

        return res;
    }

    private static void addNodeSum(ListNode l1, ListNode l2, ListNode res) {


        int sum = 0;
        ListNode l1Next=null;
        ListNode l2Next=null;

        if(l1!=null){
            sum+=l1.val;
            l1Next=l1.next;
        }
        if(l2!=null){
            sum+=l2.val;
            l2Next=l2.next;
        }
        if(res!=null){
            sum+=res.val;
            res.val = sum%10;
            res.next = new ListNode(sum/10);
        }

        if(l1Next!=null || l2Next!=null)
            addNodeSum(l1Next, l2Next, res.next);
        else
            if(res.next.val == 0)
                res.next = null;

    }

    public static void main(String[] args) {
        //l1 = [2,4,3], l2 = [5,6,4]
        List<Integer> l1_nums =  List.of(2,4,3);
        List<Integer> l2_nums =  List.of(5,6,4);

        //l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]

        //List<Integer> l1_nums =  List.of(9,9,9,9);
        //List<Integer> l2_nums =  List.of(9,9,9,9,9,9,9);

        // create the singly linked list using the list of integers
        ListNode l1 = new ListNode(l1_nums.get(0));
        ListNode l1_head = l1;
        for (int i = 1; i < l1_nums.size(); i++) {
            l1.next = new ListNode(l1_nums.get(i));
            l1 = l1.next;
        }
        ListNode l1_tail = l1;

        ListNode l2 = new ListNode(l2_nums.get(0));
        ListNode l2_head = l2;
        for (int i = 1; i < l2_nums.size(); i++) {
            l2.next = new ListNode(l2_nums.get(i));
            l2 = l2.next;
        }
        ListNode l2_tail = l2;



        //print the linked list
        System.out.println("L1 -> "+ l1_head);
        System.out.println("L2 -> "+ l2_head);

        System.out.println("L1 -> "+ l1_tail);
        System.out.println("L2 -> "+ l2_tail);

        ListNode res = addTwoNumbers(l1_head, l2_head);

        System.out.println("Result -> "+ res);


    }
}
