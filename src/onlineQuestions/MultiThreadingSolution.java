package onlineQuestions;

import java.util.Arrays;
import java.util.Scanner;

//Write your code here

class Task1 extends Thread{

	public static int a;
	public static int beg;
	
	@Override
	public void start()
	{
		for(int i=beg;i<a;i++)
        {
			MultiThreadingSolution.threadArray[i]=i;
        }
		
	}


	
}

class Task2 implements Runnable{
	
	public static int a;
	public static int beg;

	@Override
	public void run()
	{
		for(int i=beg;i<Task1.a+a;i++)
        {
			MultiThreadingSolution.threadArray[i]=i;
        }
		
	}
	
}
class Task3 implements Runnable{

	public static int a;
	public static int beg;
	
	@Override
	public void run()
	{
		for(int i=beg;i<Task1.a+Task2.a+a;i++)
        {
			MultiThreadingSolution.threadArray[i]=i;
        }
		
	}
	
}

public class MultiThreadingSolution {
        public static final int[] threadArray = new int[300];
        public static volatile String i = 0+"";
    public boolean test() throws InterruptedException
    {
    	Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Thread task2Thread = new Thread(task2);
        Thread task3Thread = new Thread(task3);
        task1.start();
        task2Thread.start();
        task1.join();
        task2Thread.join();
        task3Thread.start();
        
        System.out.println("threadArray="+Arrays.toString(threadArray));
        int first = Task1.a+Task2.a;
        int containsSecondThread = Task1.a;
        
        String oneAndTwo = "";
        String sizeOfTask1 = "";
        for(int i=0;i<first;i++)
        {
            oneAndTwo += threadArray[i]+" ";
        }
        System.out.println("oneAndTwo="+oneAndTwo);
        for(int i=0;i<containsSecondThread;i++)
        {
            sizeOfTask1 += threadArray[i]+" ";
        }
        System.out.println("sizeOfTask1="+sizeOfTask1);
        int begOfTask3 = Task3.beg;
        String checkingString = "";
        for(int i=begOfTask3;i<threadArray.length;i++)
        {
            checkingString += i + " ";
        }
        System.out.println("checkingString="+checkingString);
        String task3String = "";
        for(int j = begOfTask3;j<threadArray.length;j++)
        {
            task3String += threadArray[j]+" ";
        }
        
        System.out.println("task3String="+task3String);
        if((!oneAndTwo.contains(begOfTask3+"") && sizeOfTask1.contains(Task2.beg+"")) || task3String.equals(checkingString))
        {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws InterruptedException 
    {
        //Scanner sc= new Scanner(System.in);
            MultiThreadingSolution solution = new MultiThreadingSolution();
            int one = 80;
            int two = 130;
            int three = 90;
            System.out.println("one="+one+" two="+two+" three="+three);
            //int one = sc.nextInt();
            Task1.a = one;
            Task1.beg = 0;
            //int two = sc.nextInt();
            Task2.a = two;
            Task2.beg = one;
            //int three = sc.nextInt();
            Task3.a = three;
            Task3.beg = one+two;
            System.out.print(solution.test());
    }
}
