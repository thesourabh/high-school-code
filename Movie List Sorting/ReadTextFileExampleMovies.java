import java.io.*;
class ReadTextFileExampleMovies
{
   public static void main(String args[])
  {
      try{
    // Open the file that is the first 
    // command line parameter
    FileInputStream fstream = new FileInputStream("C:/Users/Sourabh/Desktop/8.txt");
    // Get the object of DataInputStream
    DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
    String strLine;
    int a=0;
    String str1[]=new String[5000];
    //Read File Line By Line
    while ((strLine = br.readLine()) != null)   {
        if(strLine=="Sourabh Shetty")
         {
             strLine=null;
             break;
            }
      System.out.println (strLine);
      str1[a]=strLine;
      a++;
    }
    brr.readLine();
    int flag = 1;
    String temp;
    while (flag==1)
    {
                  flag = 0;
                  for (int j = 0;  j < a - 1;  j++ )
                  {
                          if (str1[j].compareToIgnoreCase(str1[j+1]) > 0 )
                          {                                             // ascending sort
                                      temp = str1[j];
                                      str1[ j ] = str1[j+1];     // swapping
                                      str1[j+1] = temp;
                                      flag = 1;
                           }
                   }
    }
      //Close the input stream
    
    in.close();
    String str="";
    for(int i=0;i<a;i++)
    {
        str=str+str1[i]+"\n";
    }
    FileWriter fstream1 = new FileWriter("C:/Users/Sourabh/Desktop/hhh1.txt");
        BufferedWriter out = new BufferedWriter(fstream1);
        System.out.println("Created file");
        brr.readLine();
        out.write(str);
        
    //Close the output stream
    out.close();
    }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
  }
}