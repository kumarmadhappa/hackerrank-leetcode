package leetcode;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        //check for .
        //if p's . can be matched with any charater of the same position


        //check for *
        //if p's * , then p[-1] chracter should be matched with the same caraters in s until end

        //check for any other character.
        //at the same position
        int si =0;

        for (int i=0;i<p.length();i++){
            if( p.charAt(i) == '.' ){
                si++;
            }
            else if(p.charAt(i) == '*'){
                char chkChar = p.charAt(i-1);
                while( si < s.length()){
                    if(chkChar=='.'){
                        si++;
                    }
                    else if(s.charAt(si++)!=chkChar)
                        return false;
                }
            }
            else if(p.charAt(i) == s.charAt(si))
                si++;
            else
                return false;

        }
        return si==s.length();
    }

    public static void main(String[] args) {
        RegularExpressionMatching prob = new RegularExpressionMatching();
        System.out.println(prob.isMatch("aa", "a"));
        System.out.println(prob.isMatch("aa", "a*"));
        System.out.println(prob.isMatch("ab", ".*"));
    }


}
