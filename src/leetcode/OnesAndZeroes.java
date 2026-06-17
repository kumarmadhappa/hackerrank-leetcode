package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnesAndZeroes {
    public static int findMaxForm(String[] strs, int m, int n) {
        List<String> result = new ArrayList<>();
        Arrays.stream(strs).forEach(
                s->{
                    if(s.length()<m || s.length()<n){
                        result.add(s);
                        return;
                    }
                    int[] count= new int[2];
                    for (int i=0;i<s.length();i++){
                        count[s.charAt(i) - '0']++;
                    }
                    if(count[0]>m || count[1]>n){
                        return;
                    }
                    else {
                        result.add(s);
                        return;
                    }

                }
        );
        return result.size();
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},
                5, 3));
        System.out.println(findMaxForm(new String[]{"10","0","1"},
                1, 1));

    }

    //Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
    //["10","0","1"], m = 1, n = 1
}