package onlineQuestions;

import java.util.ArrayList;
import java.util.List;

public class UnitTesting
{

	public static void main(String[] args)
	{
		/*Singleton s=Singleton.getInstance();
		System.out.println(s.id);
		Singleton s1=Singleton.getInstance();
		Singleton s2=Singleton.getInstance();
		Singleton s3=Singleton.getInstance();
		Singleton s4=Singleton.getInstance();
		System.out.println(s1.id);
		System.out.println(s2.id);
		System.out.println(s4.id);
		System.out.println(s1==s4);*/
		String str = "kumar1";
		System.out.println("Hash code of string "+str.hashCode());
		

        int h = 0;
        StringBuilder formula=new StringBuilder();
        char[] value=str.toCharArray();
        List li = new ArrayList<>();
        
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
            	formula.append(" 31 * "+h +" + "+val[i]);
                h = 31 * h + val[i];
                
            }
            System.out.println("Hash code is "+h);
            System.out.println("Formula"+formula);
        }
    
		

	}

}
