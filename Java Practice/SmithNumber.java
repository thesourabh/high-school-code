/*
Takes prime factors, adds their digits and compares with sum of digits of original number
If equal, its a smith number.
*/
import java.io.*;
public class SmithNumber
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=0,copy=0,sum=0,added;
		System.out.print("INPUT ");
		n=Integer.parseInt(br.readLine());
		copy=n;
		added=summ(n);
		while(copy>1)
		{
			for(int i=2;i<n;i++)
			{
				while(copy%i==0)
				{
					copy=copy/i;
					sum=sum+summ(i);
				}
			}
			copy=1;
		}
			System.out.println(sum);
		if(added==sum)
			System.out.println("OUTPUT\tSMITH Number");
		else
			System.out.println("OUTPUT\tNOT SMITH Number");
		br.readLine();
	}
	public static int summ(int cop)
	{
		int digit=0, add=0;
		while(cop>0)
		{
			digit=cop%10;
			add=add+digit;
			cop=cop/10;
		}
		return add;
	}
}