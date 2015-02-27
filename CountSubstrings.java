import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;

/**
 * Program that prompts the user for a string and will search for the number of
 * occurances in said text file and return the number and the time taken using an ArrayList and LinkedList implementation.
 * 
 * @Aswin Selvaraj
 * @100922053
 * @090220151320
 */
public class CountSubstrings
{
    public static void main(String[] args) throws IOException
    {
       //Declarations that are used.
       //ArrayList declarations for text and pattern.
       ArrayList<Character> allChars = new ArrayList<Character>();
       ArrayList<Character> Target = new ArrayList<Character>();
       
       //ArrayList declarations for text and pattern.
       LinkedList<Character> LLallChars = new LinkedList<Character>();
       LinkedList<Character> LLTarget = new LinkedList<Character>();
       
       //Inputs
       Scanner uInput = new Scanner(System.in);
       System.out.println("Enter file name: ");
       String fileName = uInput.next();
       System.out.println("Enter target word: ");
       String searchWord = uInput.next();
       //Timer begins
       long stampStart = System.currentTimeMillis();
       
       //Converting the target to an ArrayList and LinkedList
       for(char c: searchWord.toCharArray())
        {
            Target.add(c);
            LLTarget.push(c);
        }
       
       
       readWordsofFile(allChars, LLallChars, fileName);
       
       //ArrayList implementation and the time.
       int count1 = wordMatch(allChars, Target);
       long stamp1 = System.currentTimeMillis()- stampStart;
       //LinkedList implementation and the time.
       int count2 = wordMatch(LLallChars, LLTarget);
       long stamp2 = System.currentTimeMillis()- stampStart;
       
       //Printing the final results.
       ToString(count1, stamp1, count2, stamp2, fileName, searchWord);
    }
    
   
    public static void readWordsofFile(ArrayList<Character> allChars, LinkedList<Character> LLallChars, String fileName) throws IOException
    {
        /*
         * This method asserts the existance of given file
         * opens the file
         * Converts it into a single string file and then a character array
         * This is in turn stored as an ArrayList and LinkedList
         */
        File fileIn = new File(fileName);
        String s = new String();
        
        if (!fileIn.exists())
        {
            System.out.println("Cannot find " + fileName);
            System.exit(0);
        }
        
        Scanner myFile = new Scanner(fileIn);
        
        for(int i = 0; myFile.hasNext(); i++)
        {
            s = s + myFile.nextLine();
        }
        
        for(char c: s.toCharArray())
        {
            allChars.add(c);
            LLallChars.push(c);
        }
        
        myFile.close();
    }
    
    public static int wordMatch(List<Character> allChars, List<Character> pattern)
    {
        /*
         * The wordMatch is a slightly tweaked version of the findBrute.java file provided by the professor.
         * Both the ArrayList and LinkedList implementation use it to find successful matches.
         */
        int n = n = allChars.size();
        int m = pattern.size();
        int count = 0;
        for (int i = 0; i <= n - m; i++)
        {
            //try every starting index within text
            int k = 0; // k is index into pattern
            while(k < m && allChars.get(i + k) == pattern.get(k))
            //kth character of pattern matches
            k++;
            if (k == m) // if we reach the end of the pattern
            {
                count++; // substring text[i .. m+i] is a match
            }
            // search failed
        }
        return count;
    }
    
    public static void ToString(int Count, long Stamp1, int Count2, long Stamp2, String fileName, String Target)
    {
       /*
        * This is a simple toString method to finally print out the final results on to the Java Terminal.
        */
       System.out.println("Please enter the path for the input file: " + fileName);
       System.out.println("Ente the pattern to look for: " + Target);
       System.out.println("Using ArrayLists: " + Count + " matches, derived in " + Stamp1 + " milliseconds.");
       System.out.println("Using LinkedLists: " + Count2 + " matches, derived in " + Stamp2 + " milliseconds.");
    }
}


