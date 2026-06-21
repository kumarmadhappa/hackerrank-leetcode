package leetcode;

/*
905. Sort Array By Parity
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.



Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Example 2:

Input: nums = [0]
Output: [0]

 */

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {

        //find odd and even arrays
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        //put all even in the final object and odd in final object
        ArrayList<Integer> combined = new ArrayList<>();
        combined.addAll(even);
        combined.addAll(odd);

        return combined.stream().mapToInt(Integer::intValue).toArray();

    }

    public int[] sortArrayByArrayFunctions(int[] nums) {
        int n = nums.length;
        int j=0;
         for (int i=0; i<n; i++){
             if(nums[i]%2==0){
                 int temp = nums[i];
                 nums[i]=nums[j];
                 nums[j] = temp;
                 j++;
             }
         }

         return nums;

    }

    public int[] sortArrayByArray2Pointer(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        int even=0;
        int odd=n-1;
        for (int i=0;i<n;i++){
            if(nums[i]%2==0){
                ans[even]=nums[i];
                even++;
            }
            else{
                ans[odd]=nums[i];
                odd--;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        SortArrayByParity s = new SortArrayByParity();
        System.out.println(Arrays.toString(s.sortArrayByParity(new int[]{3, 1, 2, 4})));
        System.out.println(Arrays.toString(s.sortArrayByArrayFunctions(new int[]{0,3, 6,10,1, 5,7,2, 4})));
        System.out.println(Arrays.toString(s.sortArrayByArray2Pointer(new int[]{0,3, 6,10,1, 5,7,2, 4})));
    }


}
