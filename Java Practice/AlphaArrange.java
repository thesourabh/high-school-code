//Program to correctly sort words alphabetically

import java.io.*;
public class AlphaArrange
{
	static String str[] = {"HELLO","ADIOS","YAHOO","HEADPHONES","ICECREAM","YAHOP","ADIDAS","HEAD"};
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp;
		for(int i=0;i<str.length;i++)
		{
			System.out.println(str[i]);
		}
		br.readLine();
		System.out.println("\n\n");
		for(int i=0;i<(str.length-1);i++)
		{
			for(int j=i;j<str.length;j++)
			{
				System.out.println("i = "+i+"    j:  "+j+"  str[i]="+str[i]+"  str[j]="+str[j]+"  compare to: "+str[i].compareTo(str[j]));	
				if(str[i].compareTo(str[j])>0)
				{
					temp=str[i];
					str[i]=str[j];
					str[j]=temp;
				}
			}
		}
		for(int i=0;i<str.length;i++)
		{
			System.out.println(str[i]);	
		}
		br.readLine();
	}
}