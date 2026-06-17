package secretCode;

import java.util.ArrayList;

import secretCode.code.numbers.NumberFinder;
import secretCode.code.string.ExtractString;

public class KeithClass {
	public static void main(String[] args)
	{
		KeithClass k=new KeithClass();
		
	String conversation="A: Hello, Priya 3 speaking. Is this Aditi? B: Yeah Priya! I am there 28. A: How are you dear three? B: I am fine 19. What about you Priya 75? A: Glad to hear that! Me too fine! seven. Aditi how are your five holidays going? B: Great Priya! I am enjoying well! ";
	//	String conversation="28 19, 75 one 23 56 ten FiVe FOUR";
	conversation= "A: Hello, may I speak to Alice 14 please?  four B: This is she. How's it 19 going? A: I've been trying to call you 28 times all day B: Sorry about that. I was cleaning up 47. A: It's okay 61. B: So what were you calling 75 me about? A: Oh, I just wanted to see if you wanted to hang out 197 tomorrow. B: Sure, what did you want to do? A: Maybe we can go see a movie or something. B: That sounds like fun. Let's do it. A: I'll see you 7ytr4fhh6 tomorrow then. five B: See you then. Goodbye.";
	conversation="A: Hi, how are you 742. Is Alice there? B: 1104 Speaking. What's up? A: Why haven't you answered 1537 the phone? B: My bad, I had two chores to do. A: That's all right. B: What was the reason for your call? A: I want to do something tomorrow with you. B: Sounds good. What did you have in mind? A: I was thinking about seeing a one movie. B: Okay, let's go see a movie. A: Until then. B: Talk to you later.";
	conversation="A: Is Alice available? B: You're talking 2208 to her. A: I've called you a nine times today. B: I was busy doing something 2580. I apologize. A: No problem. B: Did you need 2345 something? A: Do you want to do something 48 tomorrow? B: Is there somewhere special you wanted 76 to go? A: How about a movie? B: A movie sounds good. A: Call me tomorrow three times then. B: I will see you tomorrow.";
		k.getInput(conversation);

	}
	
	
	
	public String getInput(String conversation) {
		ExtractString 	e = new ExtractString();
		
		ArrayList<ArrayList<Integer>> digitList = e.extractDigits(conversation);

		ArrayList<Integer> digitsInTextForm=digitList.get(0);
		ArrayList<Integer> digitsInNumericForm=digitList.get(1);
		
		
		System.out.println("digitsInTextForm="+digitsInTextForm.toString());
		System.out.println("digitsInNumericForm="+digitsInNumericForm.toString());
		
		int textSum=0;
		for (int i=0;i<digitsInTextForm.size();i++) {
			textSum+=digitsInTextForm.get(i);
			
		}
		StringBuilder s = new StringBuilder();
		NumberFinder nf = new NumberFinder();
		for (int i=0;i<digitsInNumericForm.size();i++) {
			boolean keithNumber=nf.checkIfKeithComposite(digitsInNumericForm.get(i));
			if (keithNumber) {
				s.append(digitsInNumericForm.get(i));
			}
		}
		
		s.append(textSum);
		
		System.out.println(s.toString());
		System.out.println(s.toString().hashCode());
		
		return s.toString();
	}
	
	

}
