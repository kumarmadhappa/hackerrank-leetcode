package onlineQuestions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeTesting {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		getTimesinSpecificTimeZone();

		try
		{
			Date d1 = sdf.parse("12:44:00");
			System.out.println(d1.getTime());
			
			Date d2 = sdf.parse("01:44:00");
			System.out.println(d2.getTime());

			System.out.println((d2.getTime() - d1.getTime()) / (1000 * 60));
			Date d = new Date();
			System.out.println(d.getTime());
			// Thread.sleep(2000);
			d = new Date();
			System.out.println(d.getTime());
			long time = System.currentTimeMillis();
			System.out.println(time);
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd-HH:mm:ss.SSS");
			sdf2.setTimeZone(TimeZone.getTimeZone("GMT"));
			System.out.println(d);
			System.out.println("GMT TIME date-" + sdf2.format(d));
			
			System.out.println("GMT TIME time-" + sdf2.format(time));
			System.out.println(d.getTime());
			// Thread.sleep(5000);
			System.out.println(new Date(d.getTime()));
			int num;
			if ((num = 2) != 2)
			{
				System.out.println("if Num=" + num);
			}
			else
				System.out.println("else Num=" + num);

		}
		catch (ParseException e)
		{ // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void getTimesinSpecificTimeZone()
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long time = System.currentTimeMillis();

		System.out.println("Time in milliseconds=" + time);
		Date d = new Date(time);
		System.out.println("Date =" + d.toString());

		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		String result = format.format(d);
		System.out.println("Date in " + format.getTimeZone().getDisplayName() + " =" + result);

		format.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
		System.out.println("Date in " + format.getTimeZone().getDisplayName() + " =" + format.format(d));

	}

}
