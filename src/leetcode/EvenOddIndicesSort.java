package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class EvenOddIndicesSort {

    public int[] sortEvenOdd(int[] nums) {

        //Extract even and odd
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer>  odd = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            if (i % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }


        //Sort According to the requirement

        //even in increasing
        even.sort(Comparator.naturalOrder());

        //odd in decreasing
        odd.sort(Comparator.reverseOrder());

        //Merge it back index wise
        ArrayList<Integer> combined = new ArrayList<>();

        Iterator<Integer> evenItr = even.iterator();
        Iterator<Integer> oddItr = odd.iterator();

        for (int i=0;i<nums.length;i++){   // 0 -> 0, 1->2, 2-> 4, 3->6, 4->8

            if(i%2==0){
                combined.add(evenItr.next());
            }
            else {
                combined.add(oddItr.next());
            }

        }

        return combined.stream()
                .mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        EvenOddIndicesSort obj = new EvenOddIndicesSort();
        System.out.println(Arrays.toString(obj.sortEvenOdd(new int[]{4, 1, 2, 3})));
        System.out.println(Arrays.toString(obj.sortEvenOdd(new int[]{2, 1})));
    }


}
