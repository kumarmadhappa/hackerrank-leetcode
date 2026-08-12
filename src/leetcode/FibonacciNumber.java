package leetcode;

import java.time.LocalTime;
import java.util.Arrays;

public class FibonacciNumber {

    public static long fib(int n) {

        if(n < 2) return n;
        else return fib(n-2)+fib(n-1);

    }

    public static long fibWithForLoop(int n){
        if(n < 2) return n;
        long prev0=0;//F(0)
        long prev1=1;//F(1)
        for(int i=2;i<=n;i++){
            long sum = prev0+prev1;
            prev0=prev1;
            prev1=sum;
        }
        return prev1;
    }
    
    public static long fibWithDP(int n, long[] dp){
        long res = -1;
        if(dp[n]!=-1){
            res = dp[n];
        }
        else if(n<2){
            res = n;
            dp[n]=n;
        }

        else if(n>=2){
            dp[n] = fibWithDP(n-2, dp) + fibWithDP(n-1, dp);
            res = dp[n];
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 50;
        LocalTime startTime = LocalTime.now();
        long res = fib(n);
        System.out.println("Nth fib numbers is - "+res);
        LocalTime endTime = LocalTime.now();
        System.out.println("Time taken for recursions: " + java.time.Duration.between(startTime, endTime).toSeconds() + " seconds");

        res = fibWithForLoop(n);
        System.out.println("Nth fib numbers is - "+res);

        startTime = LocalTime.now();
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        //Arrays.setAll(dp, i -> i);
        res = fibWithDP(n, dp);
        endTime = LocalTime.now();
        System.out.println("Nth fib numbers is - "+res);
        System.out.println("All fib numbers are - "+ Arrays.toString(dp));
        System.out.println("Time taken for DP: " + java.time.Duration.between(startTime, endTime).toSeconds() + " seconds");
    }
}
