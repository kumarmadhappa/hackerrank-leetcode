package onlineQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Base
{
	public static void display()
	{
		System.out.println("Static or class method from Base");
	}

	private void print()
	{
		System.out.println("Non-static or instance method from Base");
	}
}

class Derived extends Base
{
	
	
	public static void display()
	{
		System.out.println("Static or class method from Derived");
	}
	
	public final void display1(int i)
	{
		System.out.println("Static or class method from Derived");
	}

	public void print()
	{
		System.out.println("Non-static or instance method from Derived");
	}
}

public class StaticMethodOverriding
{

	public static void main(String[] args)
	{
		Base obj = new Derived();
		Base baseObj = new Base();
		Derived derivedObj = new Derived();
		derivedObj.display();
		baseObj.display();
		obj.display();
		System.gc();
		HashMap<String, String> map = new HashMap<>();
		map.keySet().iterator();
		map.values().iterator();
		map.entrySet().iterator();
		List<String> array = new ArrayList<>();
		int[] ar = new int[10];
		String[] sit = new String[10];
		

	}

}


