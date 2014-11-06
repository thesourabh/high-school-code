import java.io.*;
class FileRead 
{
   public static void main(String args[])
  {
      try{
    // Open the file that is the first 
    // command line parameter
    FileInputStream fstream = new FileInputStream("C:/Users/Sourabh/Desktop/hhh.txt");
    // Get the object of DataInputStream
    DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String strLine;
    int a=0;
    String strarr1[]=new String[500];
    //Read File Line By Line
    while ((strLine = br.readLine()) != null)   {
      // Print the content on the console
      a++;
      System.out.println (strLine);
      strarr1[a]=strLine;
    }
    //Close the input stream
    in.close();
    int b=0;
    while(b<=a)
    {
        System.out.println(strarr1[b]);
    }
    }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
  }
}