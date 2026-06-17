package CGPACalculator;

public class TestCGPA
{

	public static void main(String[] args)
	{
		Aided a = new Aided();
		//String res=a.result("100 5,100 5,100 5|1,100,5|0,100,5");
		String res=a.result("67 4,34 2,54 5,100 2|1,100,5|0,100,5");
		System.out.println(res);
		System.out.println(res.hashCode());
		//System.out.println("5.64".hashCode());
		
		
		SelfFinance s = new SelfFinance();
		res=s.result("100 5,100 5,53 5,76 3|0,100,5");
		
		System.out.println(res);

		/*for (int i = 0; i < 10; i++)
		{
			int marks = 40 + i * 1;
			double grade = a.calculateGradePointInRange(40, 49, 6.0, 6.9, marks);
			System.out.println("Marks-" + marks + ";grade-" + grade);
		}

		for (int i = 0; i < 10; i++)
		{
			int marks = 50 + i * 1;
			double grade = a.calculateGradePointInRange(50, 59, 7.0, 7.9, marks);
			System.out.println("Marks-" + marks + ";grade-" + grade);
		}
		for (int i = 0; i < 15; i++)
		{
			int marks = 60 + i * 1;
			double grade = a.calculateGradePointInRange(60, 74, 8.0, 8.9, marks);
			System.out.println("Marks-" + marks + ";grade-" + grade);
		}
		for (int i = 0; i < 26; i++)
		{
			int marks = 75 + i * 1;
			double grade = a.calculateGradePointInRange(75, 100, 9.0, 10.0, marks);
			System.out.println("Marks-" + marks + ";grade-" + grade);
		}*/

	}

}
