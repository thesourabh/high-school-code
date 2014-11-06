//Program to first input a user chosen date and day, and then give out the day of any date after death of Christ.


import java.io.*;
public class Program
{
	public static void main(String args[]) throws IOException
{
String weekday[]={"Sunday","Monday","Tueday","Wednesday","Thursday","Friday","Saturday"};
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter known date\n");
String kdate=br.readLine();
System.out.println("Enter Day of the given known date\n");
String kday=br.readLine();
int ind=0,td=0,jday=0,leap=0,tot=0;
for(int z=0;z<weekday.length;z++)
{
if(kday.equals(weekday[z]))
ind=z;
}
int d=Integer.parseInt(kdate.substring(0,2));
int m=Integer.parseInt(kdate.substring(3,5));
int y=Integer.parseInt(kdate.substring(6));
System.out.println(d+" "+m+" "+y);
for(int i=0;i<m;i++)
{
	switch(i)
	{
	case 1: case 3: case 5: case 7: case 8: case 10: case 12:
	jday+=31;
		break;
	case 2:
	if(y%4==0)
	{
		jday=jday+29;
	}
	else
	{
		jday=jday+28;
	}
		break;
	case 4:case 6:case 9:case 11:
	jday=jday+30;
		break;
	default:
	jday=jday;
	}
}
jday=jday+d;
leap=y/4;
tot=(leap*366)+(365*(y-leap));
jday=tot-jday-1;
	td=(jday%7);
if(td>=7)
{
td=td-7;
}
System.out.println("\n\n\nJan 1st of the year 1 is "+weekday[td]);
y=1;
int index=0,theday=0,days=0,mcount=0,monthy;
for(int z=0;z<weekday.length;z++)
{
if(weekday[td].equals(weekday[z]))
index=z;
}
System.out.println("\n\nEnter Day to find\n");
String date=br.readLine();
int dd=Integer.parseInt(date.substring(0,2));
int mm=Integer.parseInt(date.substring(3,5));
int yyyy=Integer.parseInt(date.substring(6));
System.out.println(dd+" "+mm+" "+yyyy);
int temp=0;
System.out.println("\nyyyy = "+yyyy);
for(int k=0;k<=yyyy;k++)
{
System.out.println("\nk = "+k);
if(k==yyyy)
monthy=mm;
else
monthy=13;
for(int i=0;i<monthy;i++)
{
	switch(i)
	{
	case 1: case 3: case 5: case 7: case 8: case 10: case 12:
	days+=31;
		break;
	case 2:
	if((y+k)%4==0)
	{
		days=days+29;
	}
	else
	{
		days=days+28;
	}
		break;
	case 4:case 6:case 9:case 11:
	days=days+30;
		break;
	default:
	days=days;
	}

}
}

days=days+dd-2;	
	theday=(days%7)+index;
if(theday>=7)
{
theday=theday-7;
}
System.out.println("\n\n\n"+weekday[theday]);

br.readLine();
}
}