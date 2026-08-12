package leetcode;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int maxArea = 0;
        int left =0;

        int right = height.length-1;

        while (left < right){
            for(int i=right; i>=left+1; i--){
                int len;
                if(left == 0)
                    len = i;
                else
                    len = i - left;

                int ht = Math.min(height[left], height[i]);
                int area = len * ht;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
            left++;

        }
        return maxArea;
    }

    public int maxAreaOptimized(int[] height) {
        int maxArea = 0;
        int left =0;

        int right = height.length-1;

        while (left<right){
            int len;
            if(left == 0)
                len = right;
            else
                len = right - left;

            int ht = Math.min(height[left], height[right]);
            int area = len * ht;
            maxArea = Math.max(maxArea, area);

            if(height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;

    }


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater cont = new ContainerWithMostWater();
        int maxArea = cont.maxArea(height);
        System.out.println("Maximum area: " + maxArea);


        maxArea = cont.maxArea(height);
        System.out.println("Maximum area(Optimized): " + maxArea);
    }
}
