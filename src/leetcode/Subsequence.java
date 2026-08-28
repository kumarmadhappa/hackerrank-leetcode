package leetcode;

public class Subsequence {

    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty())
            return true;

        int si=0;
        int ti=0;

        while (ti<t.length() && si<s.length()){
            if(s.charAt(si)==t.charAt(ti)){
                si++;
                ti++;
            }
            else
                ti++;

        }
        return si == s.length();
    }

    public static void main(String[] args) {
        Subsequence s = new Subsequence();
        System.out.println(s.isSubsequence("abc","ahbgdc"));
        System.out.println(s.isSubsequence("axc","ahbgdc"));
        System.out.println(s.isSubsequence("","ahbgdc"));
        System.out.println(s.isSubsequence("abc",""));
    }
}
