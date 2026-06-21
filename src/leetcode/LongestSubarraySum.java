package leetcode;

import java.util.Arrays;

public class LongestSubarraySum {

    public int bruteForce(int target, int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {
            int sum = nums[i];
            if (sum < target) {
                for (int j = i + 1; j < n; j++) {
                    sum += nums[j];
                    if (sum == target) {
                        max = Math.max(max, j - i + 1);
                        break;
                    } else if (sum > target) {
                        break;
                    }
                }
            }
        }

        return max==Integer.MIN_VALUE ? 0: max;
    }

    public int twoPointer(int target, int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        int left = 0;
        int sum = 0;        // {1,3,1,5,2,1,1,1} 5
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                if (sum == target) {
                    max = Math.max(max, right - left + 1);
                }
                sum -= nums[left++];
            }

        }

        return max==Integer.MIN_VALUE?0:max;
    }


    public static void main(String[] args) {
        LongestSubarraySum obj = new LongestSubarraySum();
        int res = obj.bruteForce(5, new int[]{1,3,1,5,2,1,1,1});
        System.out.println(res);


        res = obj.twoPointer(5, new int[]{1,3,1,5,2,1,1,1});
        System.out.println(res);

    }
}
