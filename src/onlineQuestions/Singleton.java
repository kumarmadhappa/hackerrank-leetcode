package onlineQuestions;

public class Singleton
{
	  private static Singleton obj;
	static int id=0;
	
	private Singleton()
	{
	}
	
	public static Singleton getInstance() {
		
		if(obj==null) {
			obj=new Singleton();
			id++;
		}
		
		return obj;
		
	}
}
