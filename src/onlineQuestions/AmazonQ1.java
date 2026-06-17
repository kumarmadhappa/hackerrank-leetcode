package onlineQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonQ1 {

    /*
     * Complete the 'countMaximumTeams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY skill
     *  2. INTEGER teamSize
     *  3. INTEGER maxDiff
     */
	
	public static void main(String args[]) {
		int[] arr = {3,4,3,1,6,5};
		//int[] arr = {1,1,4,5,8,9};
		List<Integer> skill = Arrays.stream(arr).boxed().collect(Collectors.toList());
		int teamSize=3;
		int maxDiff=2;
		countMaximumTeams(skill,teamSize,maxDiff);
	}

    public static int countMaximumTeams(List<Integer> skill, int teamSize, int maxDiff) {

    	Collections.sort(skill);
    	System.out.println(skill);
        	
        int count = 0;
        
        for (int min=0,max=teamSize-1;max<skill.size();) {
        	if(skill.get(max)-skill.get(min)<=maxDiff) {
        		 min = max + 1;
                 max = min + teamSize -1;
        		count++;
        	}
        	else {
        		min++;
                max++;
        	}
        	
        }
       System.out.println(count);
       return count;
  
    }

}