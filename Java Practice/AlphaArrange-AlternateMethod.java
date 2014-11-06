//Program to correctly sort words alphabetically

import java.io.*;
public class AlphaArrange
{
	static String str[] = {"HELLO","ADIOS","YAHOO","HEADPHONES","ICECREAM","YAHOP","ADIDAS","HEAD"};
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp;
		char aa,bb;
		int len=0,e,x=0;
		for(int i=0;i<str.length;i++)
		{
			System.out.println(str[i]);
		}
		br.readLine();
		System.out.println("\n\n");
		for(int i=1;i<str.length;i++)
		{
			for(int j=0;j<(str.length-1);j++)
			{
				if(i==j)
					continue;
				if(str[j].length()<str[i].length())
					len=str[j].length();
				else
					len=str[i].length();
				x=0;
				do
				{
					aa=str[j].charAt(x);
					bb=str[i].charAt(x);
					if(aa>bb)
						e=1;
					else 
						e=0;
					x++;
				}while(aa==bb && x<len);
				if(e==1)
				{
					temp=str[j];
					str[j]=str[i];
					str[i]=temp;
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