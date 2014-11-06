import java.io.*;
class settletv
{
   public static void main(String args[])
  {
      try{
    // Open the file that is the first 
    // command line parameter
    FileInputStream fstream = new FileInputStream("C:/Users/Sourabh/Desktop/tv2.txt");
    // Get the object of DataInputStream
    DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
    String strLine, constr;
    int a=0;
    String str1[]=new String[5000];
    //Read File Line By Line
    while ((strLine = br.readLine()) != null)   {
      System.out.println (strLine);
      str1[a]=strLine;
      a++;
    }
    brr.readLine();
    
    in.close();
    String str="";
    constr=str1[0];
    for(int i=0;i<a;i++)
    {
        if(i==0)
        {
            System.out.println (i);
            str=str+str1[0];
            continue;
        }
        if( str1[i].substring(0,(str1[i].indexOf("Season ") - 1)).compareTo(constr.substring(0,(constr.indexOf("Season ") - 1))) == 0)
        {
            System.out.println (i);
        str=str+str1[i].substring(str1[i].indexOf("Season ") - 1);
        }
        else
        {
            System.out.println (i);
            constr=str1[i];
            str=str+"\n"+str1[i];
        }
    }
    FileWriter fstream1 = new FileWriter("C:/Users/Sourabh/Desktop/tv3.txt");
        BufferedWriter out = new BufferedWriter(fstream1);
        System.out.println("Created file");
        brr.readLine();
        out.write(str);
        
    //Close the output stream
    out.close();
    System.out.println("\n\n"+str);
    }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
  }
}