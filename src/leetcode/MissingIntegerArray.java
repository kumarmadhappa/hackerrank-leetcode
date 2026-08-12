package leetcode;

import java.util.Arrays;

public class MissingIntegerArray {

    public static void findMissing(int[] nums){

        //nums is not ordered
        int n = nums.length;
        Arrays.sort(nums);


        for(int i=1; i<n; i++){
            if(nums[i] != nums[i-1] + 1){
                System.out.println("Missing integer: " + (nums[i-1] + 1));
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 1, 5, 2};
        findMissing(nums);
        findMissingUsingFormula(nums);
    }

    private static void findMissingUsingFormula(int[] nums) {
        int n = nums.length+1;
        int total = n*(n+1)/2;
        int sum =0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        System.out.println("Missing integer: " + (total-sum));

    }
}
