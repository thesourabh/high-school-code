/*Reverse a sentence. Only reverse the order of words, not the letters themselves. For example,
INPUT:	Hello how are you
OUTPUT:	you are how Hello
*/
import java.io.*;
public class ReverseWords
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter sentence");
		String str=br.readLine();
		String ch="";
		int c=0, count=0;
		str=str+" ";
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
				c++;
		}
		String arr[]=new String[c];
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
			{
				arr[count]=ch;
				count++;
				ch="";
				continue;
			}
			else
			{
				ch=ch+str.charAt(i);
			}
		}
		System.out.println();
		for(int i=(c-1);i>=0;i--)
		{
			System.out.print(arr[i]+" ");
		}
		br.readLine();
	}
}