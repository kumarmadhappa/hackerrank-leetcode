package CGPACalculator;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class Student
{

	double totalMarksCredit = 0;
	int totalCredit = 0;
	public static int CREDIT_MAX_VALUE = 5;

	public abstract String result(String MarksOfStudent);

	public double getGradePoint(String marks)
	{

		/*
		 * 49-40+1 = 10 getMarksRange() int[] low,range
		 * 
		 * 6.9 -6.0+0.1= 1.0 getgradesRange() double[] low ,range every mark from low =
		 * 1.0/10 = 0.1
		 * 
		 * 40-40=0*0.1=0+6.0=6.0 41-40=1*0.1=0.1+6.0=6.1 43-40=3*0.1=0.3+6.0=6.3
		 */

		double gradePoint = 0.0;
		int marksInt = Integer.parseInt(marks);
		if (marksInt < 40)
		{
			gradePoint = 0.0;
		}
		else if (marksInt >= 40 && marksInt <= 49)
		{
			gradePoint = calculateGradePointInRange(40, 49, 6.0, 6.9, marksInt);

		}
		else if (marksInt >= 50 && marksInt <= 59)
		{
			gradePoint = calculateGradePointInRange(50, 59, 7.0, 7.9, marksInt);

		}
		else if (marksInt >= 60 && marksInt <= 74)
		{
			gradePoint = calculateGradePointInRange(60, 74, 8.0, 8.9, marksInt);

		}
		else if (marksInt >= 75 && marksInt <= 100)
		{
			gradePoint = calculateGradePointInRange(75, 100, 9.0, 10.0, marksInt);

		}
		return gradePoint;

	}

	public double calculateGradePointInRange(int markLow, int markHigh, double gradeLow, double gradeHigh, int marks)
	{

		int marksRange = markHigh - markLow + 1;
		double gradeRange = gradeHigh - gradeLow + 0.1;

		double gradient = gradeRange / marksRange;

		double res = (marks - markLow) * gradient + gradeLow;

		DecimalFormat df = new DecimalFormat("#.#");
		df.setRoundingMode(RoundingMode.FLOOR);
		res = Double.parseDouble(df.format(res));
		// System.out.println("Marks-"+marks+";grade-"+res+";"+Double.parseDouble(df.format(res)));
		if (res > gradeHigh)
			res = gradeHigh;
		else if (res < gradeLow)
			res = gradeLow;

		return res;

	}

	public void calculateSubjectGrades(String[] subjectMarks)
	{
		for (int i = 0; i < subjectMarks.length; i++)
		{
			String[] marks = subjectMarks[i].split(" ");
			totalMarksCredit += getGradePoint(marks[0]) * Integer.parseInt(marks[1]);
			//totalCredit+=Integer.parseInt(marks[1]);
			totalCredit += CREDIT_MAX_VALUE;
		}
	}

	public void calculateOtherGrades(String[] otherMarks)
	{
		if (otherMarks[0].equals("1"))
		{
			totalMarksCredit += getGradePoint(otherMarks[1]) * Integer.parseInt(otherMarks[2]);
			//totalCredit+=Integer.parseInt(otherMarks[2]);
			totalCredit += CREDIT_MAX_VALUE;
		}
	}

	public String calculateCGPA()
	{

		double cgpa = totalMarksCredit / totalCredit;
		String value = String.format("%.2f", cgpa);
		
		return value;

	}

}
