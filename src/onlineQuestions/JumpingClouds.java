package onlineQuestions;

import java.util.Arrays;

public class JumpingClouds
{
	
	 static int jumpingOnClouds(int[] c) {
		 
		 int count=0;
		 StringBuilder seq=new StringBuilder();
		 seq.append("0");
		 for (int i=0;i<c.length;i++) {
			 //try {
				 if(i+2 <c.length && c[i+2]==0) {
					// seq.append("->"+(i+2));
					 i++;
				 }
				 /*else {
					 if (i+1==c.length) {
						 break;
					 }
					 seq.append("->"+(i+1));
				 
				 }*/
				 
				 //System.out.println(seq.toString());
				 count++;
				 
			// }
			/* catch(ArrayIndexOutOfBoundsException e){
				 if (i+1==c.length) {
					 break;
				 }
				 i=i+1;
				 seq.append("->"+i);
				 count++;
			 }*/
			 
		 }
		 
		 //System.out.println(seq.toString());
return count;
	    }


	public static void main(String[] args)
	{
		String s= "0 0 1 0 0 1 0 0 0 0";
		String[] sArray=s.split(" ");
		int[] c= new int[sArray.length] ;
		for (int i=0;i<sArray.length;i++) {
			c[i]=Integer.parseInt(sArray[i]);
		}
		System.out.println(Arrays.toString(c));
		int result=jumpingOnClouds(c);
		
		System.out.println(result);

	}

}
