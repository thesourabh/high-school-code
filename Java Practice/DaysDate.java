//Program to get the day of 1st Jan of a year and find day of any other date in the same year


import java.io.*;
public class DaysDate
{
	public static void main(String args[]) throws IOException
	{
		String weekday[]={"Sunday","Monday","Tueday","Wednesday","Thursday","Friday","Saturday"};
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Day of 1st Jan\n");
		String day=br.readLine();
		int index=0,theday=0,days=0;
		for(int z=0;z<weekday.length;z++)
		{
			if(day.equals(weekday[z]))
				index=z;
		}
		System.out.println("\n\nEnter Day to find\n");
		String date=br.readLine();
		int dd=Integer.parseInt(date.substring(0,2)),mm=Integer.parseInt(date.substring(3,5)),yyyy=Integer.parseInt(date.substring(6));
		System.out.println(dd+" "+mm+" "+yyyy);
		for(int i=0;i<mm;i++)
		{
			switch(i)
			{
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					days+=31;
					break;
				case 2:
					if(yyyy%4==0)
						days=days+29;
					else
						days=days+28;
					break;
				case 4:case 6:case 9:case 11:
					days=days+30;
					break;
				default:
					days=days;
			}
		}
		days=days+dd;
		theday=(days%7)+index-1;
		if(theday>=7)
		theday=theday-7;
		System.out.println("\n\n\n"+weekday[theday]);
		br.readLine();
		}
}