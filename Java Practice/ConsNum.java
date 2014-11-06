//Program to find series of consecutive numbers whose sum is the given number
import java.io.*;
public class ConsNum
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=0,low=1,l=0, sum=0;
		System.out.println("Enter number to check\n");
		n=Integer.parseInt(br.readLine());
		while(low<((n/2)+1))
		{
			l=low-1;
			sum=0;
			while(sum<=n)
			{
				l=l+1;
				sum=sum+l;
			}
			if((sum-l)==n)
			{
				l=l-1;
				System.out.println();
				for(int i=low;i<=l;i++)
				{
					System.out.print(i+"  ");
				}
			}
			low=low+1;
		}
		br.readLine();
	}
}