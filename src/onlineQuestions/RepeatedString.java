package onlineQuestions;

import java.util.Arrays;

public class RepeatedString
{
	
	 static long repeatedString(String s, long n) {
		 long result=0;
		 int size=s.length();
		 char ch='a';
		 int inOneLength=noOfOccurences(ch,s,size);
		 System.out.println(inOneLength);
		 int inPartialLength= noOfOccurences(ch,s,n%size);
		 System.out.println(inPartialLength);
		 
		 result= inOneLength*(n/size) + inPartialLength;
		 

		 return result;
	    }

	private static int noOfOccurences(char ch,String s, long length)
	{
		int count=0;
		for (int i=0;i<length;i++) {
			if(s.charAt(i)==ch) {
				count++;
			}
		}
		return count;
		
	}

	public static void main(String[] args)
	{
		
		
		String s="abaca";
		long n = 3;
		long result=repeatedString(s,n);
		//abaabaabaa
		System.out.println(result);

	}

}
