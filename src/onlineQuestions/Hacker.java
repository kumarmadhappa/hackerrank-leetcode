package onlineQuestions;

public class Hacker {

	public static void main(String[] args) {
		int m=15;
		int n=6;
		int groups = 0;
		if (m<n){
            groups = 2;
        }
        else if (m>=n*(n-1)/2){
            groups = n;
        }
        else if (m==n ){
            groups = 2;
        }
        else if ( m<n*(n-1)/2){
            groups = (int) Math.ceil(1/(1-((float)(2*m)/(n*n))));
        }
		System.out.println(groups);

	}

}
