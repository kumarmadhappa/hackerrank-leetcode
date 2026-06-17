package onlineQuestions;

import java.util.Arrays;

public class MissingInteger
{

	public static void main(String[] args)
	{ 
		//int[] A = {1, 3, 6, 4, 1, 2};
		//int[] A = {1,2,3};
		//int[] A = {-1,-3};
		int[] A = {1,-4, 5,6,8,2,3,7,9};
		System.out.println(MissingInteger.solution(A));
		

	}
	public static int solution(int[] A) {
        // write your code in Java SE 8
        int res=1;
        Arrays.sort(A);
        for(int i=0;i<A.length ;i++){
            if(A[i]!=res){
                continue;
            }
            else {
            	res++;
           }
            
        }
        return res;
    }

}
