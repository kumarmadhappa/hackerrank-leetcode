package leetcode;

import java.util.Arrays;

public class RangeSumQuery {
    int[] preFixSum;
    public RangeSumQuery(int[] nums) {
        preFixSum=new int[nums.length];
        preFixSum[0] = nums[0];
        for (int i=1;i<nums.length;i++){
           preFixSum[i] = preFixSum[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left==0){
            return preFixSum[right];
        }
        return preFixSum[right]-preFixSum[left-1];
    }

    public static void main(String[] args) {
        RangeSumQuery r = new RangeSumQuery(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(Arrays.toString(r.preFixSum));

        System.out.println(r.sumRange(0,3));// expected -4
        System.out.println(r.sumRange(1,3));// expected -2
        System.out.println(r.sumRange(2,5));// expected -1

    }
}
