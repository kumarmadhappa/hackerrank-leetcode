package leetcode;

public class GCDOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }

        //check if the str2 is unique or it has repeated substring
        //int indexNo = (str2+str2).indexOf(str2,1);
        //The length of the repeatable string is indexNo

        //String divisorStr = str2.substring(0,indexNo);
        //get unique or repeated substring from str2
        //This will be the new string - divisorStr

        // find the GCD of length of divisorStr and length of str1

        return gcd(str1, str2);
    }

    private String gcd(String dividend, String divisor) {
        int gcdLength = calculateGCDByEuclideanMethod(dividend.length(), divisor.length());
        return dividend.substring(0,gcdLength);

    }

    private int calculateGCDByEuclideanMethod(int a, int b) {
        if(b==0){
            return a;
        }
        return calculateGCDByEuclideanMethod(b,a % b);
    }

    public static void main(String[] args) {
        GCDOfStrings prob =  new GCDOfStrings();
        System.out.println(prob.gcdOfStrings("ABCABC","ABC"));
        System.out.println(prob.gcdOfStrings("ABCABCABCABC","ABCABC"));

        System.out.println(prob.gcdOfStrings("LEET","CODE"));
        System.out.println(prob.gcdOfStrings("AAAAAB","AAA"));
        System.out.println(prob.gcdOfStrings("ABABABAB","ABAB"));
    }
}
