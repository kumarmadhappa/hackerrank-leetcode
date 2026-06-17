package onlineQuestions;

interface  Calculate{
	
	int add(int a, int b);
	int multiply(int a , int b);
	
}

public class AnonymousTest
{
	
	public static void main(String[] args) {
		
		Calculate c = new Calculate(){

			@Override
			public int add(int a, int b)
			{
				return 0;
			}

			@Override
			public int multiply(int a, int b)
			{
				return a*b+10;
			}
			
		};
		System.out.println(c.multiply(10,15));
		
	}

}
