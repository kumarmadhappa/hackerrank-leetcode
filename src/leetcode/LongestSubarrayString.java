package leetcode;

import java.util.HashSet;

public class LongestSubarrayString {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubarrayString solution = new LongestSubarrayString();
        String s = "abcdbdc";
        int length = solution.lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repeating characters: " + length);
    }
}
