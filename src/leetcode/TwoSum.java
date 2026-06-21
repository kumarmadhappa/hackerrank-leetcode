package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res= new int[2];

        for (int i=0;i<nums.length;i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                res = new int[]{i, map.get(complement)};
                break;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return res;
    }


    //Returning indexes
    public int[] bruteForce(int[] nums, int target) {
        int n = nums.length;
        int sum;
        int[] res = new int[0];
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                sum=nums[i]+nums[j];
                if(sum==target){
                    res = new int[]{i,j};
                    break;
                }
            }
            if(res.length!=0){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        TwoSum obj = new TwoSum();
        int[] output = obj.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(output));

        output = obj.bruteForce(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(output));

        output = obj.bruteForce(new int[]{3,3}, 6);
        System.out.println(Arrays.toString(output));

    }

}
