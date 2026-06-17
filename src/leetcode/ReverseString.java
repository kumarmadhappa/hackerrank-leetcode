package leetcode;

public class ReverseString {

    public static void main(String[] args) {
        String input = "abcdef";

        //Using String Builder
        StringBuilder sb = new StringBuilder(input);
        System.out.println(sb.reverse());


        char[] arr = input.toCharArray();
        int left =0;
        int right=arr.length-1;
        for(int i=0;i<arr.length;i++){

            while(left < right){
                char temp = arr[left];
                arr[left]= arr[right];
                arr[right]=temp;
                left++;
                right--;
            }

        }
        System.out.println(new String(arr));

    }
}
