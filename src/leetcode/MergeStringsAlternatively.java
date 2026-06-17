package leetcode;

public class MergeStringsAlternatively {
    //Leetcode Problem 1768

    public static String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int minValue= Math.min(m, n);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<minValue; i++){
            sb.append(word1.charAt(i))
                    .append(word2.charAt(i));
        }

        if(m>n){
            sb.append(word1.substring(n));
        }
        else{
            sb.append(word2.substring(m));
        }

        return sb.toString();


    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd","pqrstu"));
        System.out.println(mergeAlternately("abcd","pq"));
    }

}
