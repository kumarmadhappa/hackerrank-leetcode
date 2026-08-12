package leetcode;

public class MoveZeroesToEnd {

    public static void main(String[] args){
        int[] nums = new int[]{0, 4, 5, 0 ,0,1, 0, 9, 0};

        int currZeroPointer = 0;

        for(int i=0;i<nums.length;i++){

            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[currZeroPointer];
                nums[currZeroPointer] = temp;

                currZeroPointer++;
            }
        }

        // Print the modified array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
