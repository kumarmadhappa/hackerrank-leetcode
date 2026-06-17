package CGPACalculator;

public class SelfFinance extends Student
{

	@Override
	public String result(String marksOfStudent)
	{
		String[] marksArray = marksOfStudent.split("\\|");
		String[] subjectMarks = marksArray[0].split("\\,");
		String[] sportsMarks = marksArray[1].split("\\,");
		
		
		calculateSubjectGrades(subjectMarks);
		calculateOtherGrades(sportsMarks);
		
		return calculateCGPA();
	}

}
