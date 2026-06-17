package onlineQuestions;

/**
 * Write a function that checks if a given word is a palindrome. Character case
 * should be ignored.
 * 
 * For example, isPalindrome("Deleveled") should return true as character case
 * should be ignored, resulting in "deleveled", which is a palindrome since it
 * reads the same backward and forward.
 * 
 * @author Kumar Madhappa
 *
 */
public class Palindrome {

	public boolean isPalindrome (String word) {
		int i = word.length()-1;
        StringBuffer rev = new StringBuffer();
        while (i>=0)
        {
            rev.append(word.charAt(i));
            i--;
        }
        if (rev.toString().equalsIgnoreCase(word))
            return true;
        else return false;
		
	}

	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		if (p.isPalindrome("Deleveled")) {
			System.out.println("It is a plindrome");
		}
		else {
			System.out.println("Not a palin");
		}
		
	}

}
