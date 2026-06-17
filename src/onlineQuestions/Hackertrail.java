package onlineQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class Hackertrail
{
  public static void main(String [] args) {
    try {
      Scanner scan = new Scanner(System.in);
      ArrayList<String> inputArray = new ArrayList<String>();
      while (scan.hasNextLine()) {
        String string = scan.nextLine();
        if (string.equals("EOL")) {
            break;
           }
        inputArray.add(string); 
        
      }
      
      for (int i=0;i<inputArray.size();i=i+3) {
    	  
          search(inputArray.get(i),inputArray.get(i+1),inputArray.get(i+2));
          
      }
     
      
      
      
      
    } catch (Exception e) {}
  }
  
  static void processArray(String pat, int M, int lps[])
	{
		
		int len = 0;
		int i = 1;
		lps[0] = 0; 
		while (i < M)
		{
			if (pat.charAt(i) == pat.charAt(len))
			{
				len++;
				lps[i] = len;
				i++;
			}
			else 
			{
				
				if (len != 0)
				{
					len = lps[len-1];

					
				}
				else 
				{
					lps[i] = len;
					i++;
				}
			}
		}
	}
  
  static void search(String searchStrlen ,String searchStr, String hayStack)
	{
		int strLen = Integer.parseInt(searchStrlen);
		int hayStackLen = hayStack.length();

		
		int lps[] = new int[strLen];
		int j = 0; 
		processArray(searchStr,strLen,lps);

		int i = 0; 
		while (i < hayStackLen)
		{
			if (searchStr.charAt(j) == hayStack.charAt(i))
			{
				j++;
				i++;
			}
			if (j == strLen)
			{
				System.out.println((i-j));
				j = lps[j-1];
			}

			
			else if (i < hayStackLen && searchStr.charAt(j) != hayStack.charAt(i))
			{
				
				if (j != 0)
					j = lps[j-1];
				else
					i = i+1;
			}
		}
	}


}

