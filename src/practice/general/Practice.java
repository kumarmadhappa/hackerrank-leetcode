package practice.general;

public class Practice {
	public static void main(String[] args)
	{
		Practice p= new Practice();
		//p.randomNumber7();
		
		System.out.println((p.randomNumber7()*7)%5);
	}
	
	public void randomNumber()
	{
		int min = 50;
	      int max = 100;
	        
	      //Generate random int value from 50 to 100 
	      System.out.println("Random value in int from "+min+" to "+max+ ":");
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	      System.out.println(random_int);
	}
	
	public int randomNumber7()
	{
		  int min = 1;
	      int max = 7;
	        
	      //Generate random int value from 50 to 100 
	      System.out.println("Random value in int from "+min+" to "+max+ ":");
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	      System.out.println(random_int);
	      return random_int;
	}
}
