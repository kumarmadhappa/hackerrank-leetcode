package onlineQuestions;

public class IntegerDigits
{

	public static void main(String[] args)
	{
		int a =1009645;
		String str =Integer.toString(a);
		StringBuilder sb =new StringBuilder();
		//char[] cArr= str.toCharArray();
		char[] cArr = new char[10];
	    int j = 0;
	    do {
	    	cArr[j] = (char) (a % 10);
	        a /= 10;
	        j++;
	    } while (a != 0);
		int i=0;
		for (;i<cArr.length/2;i++) {
			sb.append(cArr[i]).append(cArr[cArr.length-i-1]);
		}
		if (cArr.length%2!=0) {
			sb.append(cArr[i]);
		}
		System.out.println(Integer.parseInt(sb.toString()));
	}
	
	

	
}
