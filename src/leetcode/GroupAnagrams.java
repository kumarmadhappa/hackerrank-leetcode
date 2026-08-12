package leetcode;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<String> first = new ArrayList<>();
        first.add(strs[0]);

        List<List<String>> result = new ArrayList<>();
        result.add(first);

        for(int i=1;i<strs.length;i++){

            String str2 =  strs[i];
            boolean found = false;
            for(int j=0;j<result.size();j++){
                String str1 = result.get(j).get(0);
                if(isAnagram(str1, str2)) {
                    result.get(j).add(str2);
                    found=true;
                    break;
                }
            }
            if(!found){
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str2);
                result.add(newGroup);
            }


        }


        return result;
    }


    public List<List<String>> groupAnagramsOptimised(String[] strs){
        Map<String, List<String>> map = new HashMap<>();

        for (String str:strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = Arrays.toString(ch);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());

    }

    private boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] freq = new int[26];

        for(int i=0;i<str1.length();i++) {
            freq[str1.charAt(i)-'a']++;
            freq[str2.charAt(i)-'a']--;
        }

        for(int count : freq) {
            if(count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //Input: strs = ["eat","tea","tan","ate","nat","bat"]
        //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        GroupAnagrams g = new GroupAnagrams();
        List<List<String>> result  = g.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});

        System.out.println(result);

        result  = g.groupAnagramsOptimised(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(result);

    }
}
