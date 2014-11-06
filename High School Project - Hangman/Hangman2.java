import java.io.*;
public class Hangman
{
    int count=0,wincount=0,totcount=0,totwin=0,j=0,a,num=1;
    int randnum[] = new int[10];
    String words[] = {"NETWORK","PROCESSOR","COMPUTER","TEXTBOOK","PHYSICS","DUMDUM","PURPLE","JUMPER","MERCURY","NEUTRON"};
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main()
    {
	menu();
    }
    public void menu() throws IOException
    {
        int mainchoice;
        num=1;
        p("      Hangman Game\n\n\nMain Menu\n\n 1. Rules\n 2. Play The Game\n\n 0. Exit\n\n\n\nEnter choice: ");
        try
        {
            mainchoice=Integer.parseInt(br.readLine());
        }
        catch(NumberFormatException nn)
        {
            menu();
            mainchoice=-1;
        }
        wincount=count=0;
        switch(mainchoice)
        {
            case 1: rules();
                break;
            case 2: midmenu();
                break;
            case 0:
            default:
                pln("\n\nThank you for playing.");
                if(totcount>0)
                {
                    p("\nYour score for the whole session: "+totwin+"/"+totcount);
                }
        }
        
    }
    public void midmenu() throws IOException
    {
        int b=1;
        if(num==1)
        {
            pln("\n\n\n\n\nThe game starts now...\n\n");
            game();
            num++;
            midmenu();
        }
        else
        {
            do
            {
                try
                {
                    p("\nDo you want to\n1. Continue\n2. Go to the Main Menu\n\nEnter choice: ");
                    b=Integer.parseInt(br.readLine());
                }
                catch(NumberFormatException n1)
                {
                    midmenu();
                }
                if(b==1)
                    game();
            }while(b==1);
            menu();
        }
    }
    public void game() throws IOException
    {
        int i=0,tries=7, won=0;
        String str="",stractual="",ltried="";
        char ch,m,g;
        totcount++;
        a=randomize();
        if (count==0)
        {
            randnum[0]=a;
        }   
        else   //To make sure random number is unique
        {
            for(j=0;j<count;j++)
            {
                if(a==randnum[j])
                {
                    a=randomize();
                    j=-1;
                }
            }
            randnum[count]=a;
        }
        /*
         * To replace consonants with '_' and keep the vowels as they are, in an easier to read format for the user.
         * If there are no spaces between the letters, consecutive consonants will be replaced by 2 underscores which cannot be easily differentiated.
         */
        for(i=0;i<words[a].length();i++)
        {
            m=words[a].charAt(i);
            if(m=='A' || m=='E' || m=='I' || m=='O' || m=='U')
            {
                str=str+" "+m;
            }
            else
            {
                str=str+" _";
            }
            stractual=stractual+" "+m;
        }
        stractual=stractual+" ";
        str=str+" ";
        do  //Keep asking for letters and checking them
        {
            p("\n\n"+str+"\n\n\n\nEnter letter: ");
            String guess= br.readLine().toUpperCase();
            pln("\n\n");
            g=guess.charAt(0);
            int pos, c=0;
            String newstr=str;
            pos=stractual.indexOf(g);
            if(pos!=-1) //pos not equal to -1 means match found
            {
                while(pos!=-1)  //to repeat operation in case there is a repeat of the letter
                {
                    newstr=str.substring(0,pos);
                    newstr=newstr+stractual.charAt(pos);
                    if(pos<str.length())
                    {
                        newstr=newstr+str.substring(pos+1);
                    }
                    pos=stractual.indexOf(g,pos+1);
                    str=newstr;
                    c++;
                }
                p("\n\n\n\n\nCorrect! There ");   //to adjust singular and plural
                switch(c)
                {
                    case 1: p("is "+c+" \'"+g+"\'");
                    break;
                    default: p("are "+c+" \'"+g+"\'s");
                }
                ltried=ltried+' '+g;
                pln(" in the word\n\nLetters tried: "+ltried+"\nNumber of incorrect tries left: "+tries);
            }
            /*
             * If pos is -1, it means the guess is incorrect.
             * This is to deduct number of tries and add to list of letters already tried.
             */
            else
            {
                --tries;
                ltried=ltried+' '+g;
                pln("\n\n\n\n\nIncorrect.\n\nLetters tried: "+ltried+"\nNumber of incorrect tries left: "+tries);
            }
            if(str.equals(stractual))
            {
                won=1;
                wincount++;
                totwin++;
            }
        }while(tries!=0 && won==0);
        if(won==1)
        {
            p("\n\n\nCongratulations! You guessed the whole word correctly with "+tries);
            switch(tries)
            {
                case 1: p(" try left.");
                    break;
                default: p(" tries left.");
            }
                p("The word was:\n\n"+stractual+"\n\n");
        }
        else
        {
            pln("\n\n\nSorry, you used up all your tries. The word was:\n\n"+stractual+"\n\n");
        }
        count++;
        if(count==10) //reset counter
        {
            pln("\n10 words are up. You solved: "+wincount+"/"+count+"\n");
            count=0;
            wincount=0;
        }
        else
        {
            pln("\nYou solved: "+wincount+"/"+count+"\n");
        }
    }
    public int randomize()
    {
        double d1;
        d1=Math.random()*10;
        return ((int)d1);
        
    }
    public void p(String output)
    {
        System.out.print(output);
    }
    public void pln(String output)
    {
        System.out.println(output);
    }
    public void rules() throws IOException
    {
        pln("\n\n      How To Play\n\n\n\n1. The objective of the game is to guess all the letters of the given word.\n");
        pln("2. You get 7 incorrect tries, i.e. if your guess is incorrect, you lose a try but if it is correct, you don't. If you miss on 7 tries, you lose.\n");
        pln("3. All the vowels are already given for you, so you have 5 less alphabets to worry about.\n");
        pln("4. If you guess the same wrong letter twice, it is still counted, so pay attention to the letters already guessed.\n   However, if you again guess an already correctly guessed letter, it won't be counted.\n");
        pln("5. You have the option of leaving at the end of each word.");
        p("\nPress Enter / Return key to go back to the main menu");
        br.readLine();
        pln("\n\n\n");
        menu();
    }
}
