package leetcode;

public class MostWaterProblem {
    public Integer max_area(int[] heights) {
        // Your code goes here
        int left =0;
        int right = heights.length-1;
        int max = Integer.MIN_VALUE;

        while (left < right){
            int length = right - left;
            int height = Math.min(heights[left], heights[right]);
            int area = length*height;
            max = Math.max(max, area);

            if(heights[left]<heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MostWaterProblem prob =  new MostWaterProblem();
        int[] heights = new int[]{3, 4, 1, 2, 2, 4, 1, 3, 2};

        System.out.println(prob.max_area(heights));

    }
}
