package secretCode.code.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExtractString {
	String DIGIT_IN_TEXT = "onetwothreefourfivesixseveneightnineten";
	Map<Integer, Integer> digitPosition = new HashMap<>();

	public ExtractString()
	{
		digitPosition.put(0, 1);
		digitPosition.put(3, 2);
		digitPosition.put(6, 3);
		digitPosition.put(11, 4);
		digitPosition.put(15, 5);
		digitPosition.put(19, 6);
		digitPosition.put(22, 7);
		digitPosition.put(27, 8);
		digitPosition.put(32, 9);
		digitPosition.put(36, 10);
	}

	public ArrayList<ArrayList<Integer>> extractDigits(String conversation)
	{

		conversation = conversation.replaceAll("[^a-zA-Z0-9]", " ").trim();

		String[] words = conversation.split(" ");
		ArrayList<Integer> digitsInTextForm = new ArrayList<>();
		ArrayList<Integer> digitsInNumericForm = new ArrayList<>();
		int num;
		for (int i = 0; i < words.length; i++)
		{
			if (words[i].trim().equals(""))
				continue;
			if ((num = getDigitInTextForm(words[i])) != -1)
			{
				digitsInTextForm.add(num);
			}
			else if ((num = getDigitInNumericform(words[i])) != -1)
			{
				digitsInNumericForm.add(num);

			}

		}
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		list.add(digitsInTextForm);
		list.add(digitsInNumericForm);
		// System.out.println(digitsInTextForm.toString());
		// System.out.println(digitsInNumericForm.toString());
		return list;
	}

	private int getDigitInNumericform(String value)
	{
		int digit = -1;
		try
		{
			digit = Integer.parseInt(value);
		}
		catch (NumberFormatException e)
		{

		}

		return digit;
	}

	private int getDigitInTextForm(String value)
	{
		// System.out.println(value);
		int digit = -1;
		// Less than two characters will not make a number in Text form and also to  avoid worng words as numbers like "on"
		if (value.length() > 2)
		{
			value = value.toLowerCase();
			try
			{
				int index = DIGIT_IN_TEXT.indexOf(value);
				if (index != -1 && digitPosition.containsKey(index))
				{
					digit = digitPosition.get(index);
				}
			}
			catch (Exception e)
			{

			}

		}

		return digit;
	}

	public static void main(String[] args)
	{
		String conversation = "one 23 56 ten FiVe FOUR";
		ExtractString e = new ExtractString();
		ArrayList<ArrayList<Integer>> digitList = e.extractDigits(conversation);

		System.out.println(digitList.get(0).toString());
		System.out.println(digitList.get(1).toString());

	}

}
