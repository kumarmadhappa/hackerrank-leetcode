package leetcode;

import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer>  minHeap =  new PriorityQueue<>();
        for(int num : nums){

           minHeap.add(num);

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {

        KthLargestElement prob = new KthLargestElement();
        System.out.println(prob.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(prob.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));

    }
}
