/*
Count number of sentences,
and number of vowels and words in each sentence.
Then using scale 3:1, output in format VVVVV and WWWW
*/
import java.io.*;
public class VowelsWordsSentences
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int low=0,count=0,sum=0,added;
		System.out.print("Enter sentence\n");
		String str = br.readLine();
		int vowels[]=new int[10];
		int words[]=new int[10];
		int f=0;
		str=str+"  ";
		String s;
		for(int i=0;i<10;i++)
		{
			vowels[i]=0;
			words[i]=0;
		}
		System.out.println("Sentence	No. of Vowels	No. of Words\n-----------------------------------------");
		for(int i=0;i<(str.length()-2);i++)
		{
			if(str.substring(i,i+2).equals(". ") || str.substring(i,i+2).equals("! ") || str.substring(i,i+2).equals("? "))
			{
				count++;
				System.out.print(" "+count+"                ");
				for(int j=0;j<str.substring(low,i).length();j++)
				{
					if(str.substring(low,i).toUpperCase().charAt(j)=='A' || str.substring(low,i).toUpperCase().charAt(j)=='E' || str.substring(low,i).toUpperCase().charAt(j)=='I' || str.substring(low,i).toUpperCase().charAt(j)=='O' || str.substring(low,i).toUpperCase().charAt(j)=='U')
						vowels[count-1]++;
					else if(str.substring(low,i).toUpperCase().charAt(j)==',' && str.substring(low,i).toUpperCase().charAt(j+1)==' ')
						words[count-1]++;
					else if(str.substring(low,i).toUpperCase().charAt(j)==' ')
						words[count-1]++;
				}
				words[count-1]+=1;
				System.out.println(+vowels[count-1]+"                "+words[count-1]+"\n");
				low=i+2;
			}
		}
		System.out.println("Sentence	No of words/vowels\n-------------------------------------");
		for(int i=0;i<count;i++)
		{
			System.out.print(i+1+"               ");
			for(int j=0;j<vowels[i]*3;j++)
			{
				System.out.print("V");
			}
			System.out.print("\n                ");
			for(int j=0;j<words[i]*3;j++)
			{
				System.out.print("W");
			}
			System.out.println("\n");
		}
		System.out.println("-------------------------------------");
		br.readLine();
	}
}