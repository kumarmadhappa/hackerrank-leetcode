package leetcode;

public class LongestPalindromeSubstring {

    public static String longestPalindrome(String s) {

        String maxPalin = "";

        for (int i=0;i<s.length();i++){
            String odd = moveAndCheckPalindrome(i, i, s);
            String even = moveAndCheckPalindrome(i, i+1, s);

            if(odd.length()>maxPalin.length()){
                maxPalin = odd;
            }
            if(even.length()>maxPalin.length()){
                maxPalin = even;
            }

        }

        return maxPalin;

    }

    private static String moveAndCheckPalindrome(int left, int right ,String s) {

        while (left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }

    public static void main(String[] args) {
        //String s = "babad"
        String s = "a";
        String result = longestPalindrome(s);
        System.out.println("Longest Palindromic Substring: " + result);
    }
}
