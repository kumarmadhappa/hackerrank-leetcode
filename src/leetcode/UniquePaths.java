package leetcode;

import java.util.Arrays;

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        // create dp matrix
        // fill last row and last column with 1 -
        // this is required because there is only one unique path to the destination

        // for loop starting from last but 1 row and last but 1 column
        //add the calculate the i,j using the adjacent values

        //return dp[0][0] -0 this is the total unique steps from this location

        int[][] dp = new int[m][n];

        Arrays.fill(dp[m-1],1);//last row
        for(int i=0;i<m-1;i++) //last column
            dp[i][n-1]=1;

        for (int row=m-2; row>=0; row--){
            for (int col=n-2; col>=0; col--){
                dp[row][col] = dp[row+1][col]+dp[row][col+1];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        System.out.println(u.uniquePaths(3,7));
        System.out.println(u.uniquePaths(3,2));
    }
}
