package onlineQuestions;

public class ArraySum
{

	public static void main(String[] args)
	{
		long sum = 0;
		long startStime=System.currentTimeMillis();
		int[] a = {1,-4, 5,6,8,2,3,7,9,3,1,4,1,4,777,4233,667,531454,7674,7,34,213,57,3534,979,314,57478};
		 for(int i=0;i<a.length ;i++){
			 for(int j=0;j<a.length ;j++){
				 sum+=a[i]+a[j];
			 }
			 
		 }
		 long endtime=System.currentTimeMillis();
		 System.out.println(sum );
		 System.out.println(endtime-startStime);
		 int b=3;
		 if (b >> 1==0) {
			 System.out.println("even " );
			 System.out.println((b >> 1)==0);
			 
		 }
		 else {
			 System.out.println("odd " );
			 System.out.println((b >> 1)==0);
		 }

	}

}
