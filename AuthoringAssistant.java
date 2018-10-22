import java.util.*;
import java.lang.*;
/**
* Write a description of class Repetition here.
*
* @author (your name)
* @version (a version number or a date)
*/
public class AuthoringAssistant
{
public static void printMenu()
{
   System.out.print("c - Number of non-whitespace characters"
   + "\nw - Number of words" + "\nf - Find text" + "\nr - Replace all !'s"
   + "\ns - Shorten spaces" + "\nq - Quit" + "\n\nChoose an option: "); 
   
}

public static int getNumOfNonWSCharacters(String string)
{
 
   int numofWS = 0;
   for (int i = 0; i < string.length(); i++)
   {
            if (string.charAt(i) == ' ')
                numofWS++;
   }
       
       return (string.length() - numofWS);
    
}


public static int getNumOfWords(String string)
{
   int numofWords = 0;
   for(int i = 0; i < string.length(); i++)
   {
            if(string.charAt(i) == ' ') 
            {
                if(string.charAt(i+1) == ' ')
                    {
                        numofWords = numofWords;
                    }
                else
                numofWords++;
            }
   }
   
   return numofWords + 1;
   
}


public static int findText(String texttofind, String string)
{
   int atindex = 0;
   int count = 0;
   
   
   while (atindex != -1) 
   {

       atindex = string.indexOf(texttofind, atindex);

       if (atindex != -1) 
       {
           count++;
           atindex += texttofind.length();
       }
   }
   
   System.out.print("\n" + "\"" + texttofind + "\"" + " instances: ");
   return count;
}

public static String replaceExclamation(String string)
{
   return string.replaceAll("!", ".");
   
}
                            
public static String shortenSpace(String string)
{
   return string.replaceAll(" +"," ");
}

public static void main(String args[])
{
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter a sample text: ");
    String string = keyboard.nextLine();
    System.out.println("You entered: " + string);
    boolean obj = true;
    do
    {
        printMenu();
        char option = keyboard.next().charAt(0);
        
        switch(option)
        {
            case 'c':
            System.out.println("Number of non-whitespace characters: " 
            + getNumOfNonWSCharacters(string)); break;
            
            case 'w':
            System.out.println("Number of words: " + getNumOfWords(string)); break;
        
            case 'f':
            {
                System.out.print("Find text: ");
                System.out.print("\nEnter a word or phrase to be found: ");
   
                keyboard.nextLine();
                String texttofind = keyboard.nextLine();

                int numofinstance = findText(texttofind,string);
                System.out.print(numofinstance);
                
            }
            break;
            
            case 'r':
            {
                System.out.println("Replace all !'s");
                String newstring = replaceExclamation(string);
                System.out.println(newstring);
            }
            break;
            
            case 's':
            {
                System.out.println("Shorten spaces");
                String newstring = shortenSpace(string);
                System.out.println(newstring);
            }
            break;
            
            case 'q':
            {
                obj = false;
            }

            
        }
    }while(obj);
    }
}
