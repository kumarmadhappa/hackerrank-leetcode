package CGPACalculator;

public class Aided extends Student
{

	@Override
	public String result(String marksOfStudent)
	{
		String[] marksArray = marksOfStudent.split("\\|");
		String[] subjectMarks = marksArray[0].split("\\,");
		String[] nccMarks = marksArray[1].split("\\,");
		String[] sportsMarks = marksArray[2].split("\\,");
		
		
		calculateSubjectGrades(subjectMarks);
		calculateOtherGrades(nccMarks);
		calculateOtherGrades(sportsMarks);
		
		return calculateCGPA();
	}

}
