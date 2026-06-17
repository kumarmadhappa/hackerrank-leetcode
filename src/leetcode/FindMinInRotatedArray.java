package leetcode;

public class FindMinInRotatedArray {
//LeetCode problem 153
    /**
     * Example 2:

     Input: nums = [4,5,6,7,0,1,2]
    Output: 0
    Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 3 times
     [5,6,7,0,1,2,4] - rotated 4 times
     */

    public int findMin(int[] nums) {
        int l=0;
        int r= nums.length-1;


        while (l < r) {
            int mid = (l+r)/2;
            if(nums[mid]>nums[r] || nums[mid]==nums[r]){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }


        return nums[l];
    }

    public static void main(String[] args) {
        FindMinInRotatedArray find =  new FindMinInRotatedArray();
        //System.out.println(find.findMin(new int[]{3,4,5,1,2}));
        //System.out.println(find.findMin(new int[]{4,5,6,7,0,1,2}));
        //System.out.println(find.findMin(new int[]{3,3,1,3}));
        System.out.println(find.findMin(new int[]{1,3,3}));
    }
}
