package onlineQuestions;

import java.util.Collections;
import java.util.Stack;

public class QueueUsingStacks
{
	static Stack<String> s1 = new Stack<>();
	static Stack<String> s2 = new Stack<>();

	public static void main(String[] args)
	{
		enqueue("A");
		enqueue("B");	
		enqueue("C");
		dequeue();
		dequeue();
	}

	private static void dequeue()
	{
		if (s1.size() == 0)
		{
			System.out.println("Queue Is empty");
		}
		else
		{
			while (s1.size() != 0)
				s2.push(s1.pop());
			System.out.println("Elements of s1 "+s1);
			System.out.println("Elements of s2 "+s2);
			System.out.println("Dequeue Item is " + s2.pop());
		}
		
		while (s2.size() != 0)
			s1.push(s2.pop());
		System.out.println("Elements of s1 "+s1);
		System.out.println("Elements of s2 "+s2);

	}

	private static void enqueue(String e)
	{
		s1.push(e);
		System.out.println("Item e is added."+"Elements of s1 "+s1);
		
	}

}
