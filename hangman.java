// Write your Hangman class here
import java.util.Scanner;

public class hangman
{
	public static int incorrect = 0;

    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        
        // First get the word
       // int wordSeed = in.nextInt();

        //String word = Word.getWord(wordSeed);
        String[] words = {"willow", "snake", "baking", "elephant", "paper", "xylophone", "quiz", "monkey", "ivy", "field", "limes", "computer", 
    						"felt", "books"};
        System.out.println("Enter a number to get your word between 0 and " + words.length + ":");
        int wordSeed = in.nextInt();
        String word = words[wordSeed];
        String guesses = "";

        // Now you have the word ... encourage the user to guess.
        System.out.println("The word is");
        System.out.println(showLetters(word, guesses));
        //System.out.println("Guess a letter:");
        //char guess = in.nextChar();
        String output = "";
        while (allDone(word, guesses) == false) {
            System.out.println("Guess a letter:");
            char guess = in.next().charAt(0);
            guesses += guess;
            output = showLetters(word, guesses);
            if (containsLetter(word, guess) == false) {
            	incorrect += 1;
            }
            System.out.println(output);
            System.out.println("Incorrect guesses: " + incorrect);
            //System.out.println(incorrect);
            
        }
    }
    
    public static boolean allDone(String word, String guesses) {
        int count = 0;
        for (int i=0; i < word.length(); i++) {
            if (containsLetter(guesses, word.charAt(i)) == true) {
                count++;
                
            }
        }
        if (count == word.length()) {
        	System.out.println("Well Done, the word was " + word + ".");
            return true;
        }
        if (incorrect > 10) {
        	System.out.println("You have lost! With " + incorrect);
        	return true;
        }
        else {
            return false;
        }
        
    }
    public static boolean containsLetter(String word, char letter) {
        
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                return true;
            }
        }
        //incorrect += 1;
        return false;
    }
    
    public static String showLetters(String word, String guesses) {
        
        String output = "";
        for (int i = 0; i < word.length(); i++) {
            if (containsLetter(guesses, word.charAt(i)) == true) {
                output += word.charAt(i);
            }
            else {
                output += "_";
            }
        }
        return output;
    }
}
        
    
