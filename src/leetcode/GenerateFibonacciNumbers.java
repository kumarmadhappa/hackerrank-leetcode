package leetcode;

public class GenerateFibonacciNumbers {

    public static int[] generateFibo(int n){

        int[] fib = new int[n];

        if(n == 1) {
            fib[0]=0;
            return fib;
        }
        if(n == 2) {
            fib[0]=0;
            fib[1]=1;
            return fib;
        }

        if(n>2){
            fib[0]=0;
            fib[1]=1;
            for (int i = 2; i < n; i++) {
                fib[i] =  fib[i-2] + fib[i-1];
            }
        }
        return fib;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] fib = generateFibo(n);
        for (int i = 0; i < n; i++) {
            System.out.print(fib[i] + " ");
        }
    }
}
