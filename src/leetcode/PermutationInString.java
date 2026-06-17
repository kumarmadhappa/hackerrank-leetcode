package leetcode;

import java.util.Arrays;

public class PermutationInString {


        public static boolean  checkInclusion(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();

            if (m > n){
                return false; //Given string is shorter, so S1 will not be present in s2
            }
            else{

                int[] strFreq = new int[26];
                int[] windowFreq = new int[26];


                //String freq
                //window freq , window size is m
                for (int i=0; i <m;i++){
                    strFreq[s1.charAt(i)-'a']++;
                    windowFreq[s2.charAt(i)-'a']++;
                }

                for (int i=0; i<(n-m); i++){
                    if(Arrays.equals(strFreq, windowFreq)){
                        return true;
                    }
                    else{
                        windowFreq[s2.charAt(i)-'a']--;
                        windowFreq[s2.charAt(i+m)-'a']++;
                    }
                }

                return Arrays.equals(strFreq, windowFreq);
            }

        }

    public static void main(String[] args) {
        if(checkInclusion("abcd","abdscbdaf")){
            System.out.println("Permutation found");
        }
        else{
            System.out.println("Permutation not available");
        }

    }


}
