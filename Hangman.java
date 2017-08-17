/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.util.*;
import java.awt.*;

public class Hangman extends ConsoleProgram {

	
	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
		canvas.reset();
		
	}
    public void run() {
		/* You fill this in */
    	playGame();
    	
	}
   
    private void playGame() {
    	x = new HangmanLexicon();
    	printFirstInstance();
    	hidden = printDashes(word);

    	while(guesses <= 8) {
    		letsHang();
    		
    		if(guesses >= 0 && countTotal == y) {
    			println("You win! The word is " + word);
    			break;
    		}
    		if(guesses == 0 && countTotal != y) {
    			println("You lose! The word was " + word);
    			break;
    		}
    		if(wrong == 6) {
    			canvas.addRightLeg();
    			println("You've been hung. The word was " + word);
    			break;
    		}
    	}
    }
    private void printFirstInstance() { 
    	word = x.getWord(rgen.nextInt(10));
    	
    	println("Welcome to Hangman!");
    	println("The word now looks like this: " + printDashes(word));
    	println("You have " + guesses + " guesses left.");
    }
    
    public String printDashes(String s) {
    	y = s.length();
		result = "";
    	for (int i = 0; i < y; i++) {
    		result += "-";
    	}	
    	return result;
    }
    
    
    private void letsHang() {
    	//Prompts the user for input
   	 	String guess = readLine("Your guess: ");
   	 	if(isLetter(guess) == false) {
   	 		println("Enter a real letter");
   	 	} else if(alreadyGuessed(guess) == true) {
   	   	 	//Penalizes the user for two (or more) of the same incorrect guesses
   	 		if(wrong == 1) {
   	 			guesses--;
   	 			println("Cmon dude.");
   	 			println("I penalized you. You now have " + guesses + " guesses left");
   	 		}
   	 		//println(times);
   	 		println("You can't guess more than once :)");
   	 	}else if(guess.isEmpty() == true) {
   	 		println("You need to enter a character!");
   	 	} else if(guess.length() > 1){
   	 		println("Only one letter at a time sucka!!");
   	 	} else {
   	    	checkGuess(guess.toUpperCase());
   	 	}
   	//Adds the man to the graphics portion of the game
   	 	switch(wrong) {
   	 	case 1: canvas.addHead();
   	 	break;
   	 	case 2: canvas.addBody();
   	 	break;
   	 	case 3: canvas.addLeftArm();
   	 	break;
   	 	case 4: canvas.addRightArm();
   	 	break;
   	 	case 5: canvas.addLeftLeg();
   	 	break;
   	 	}
   	 	
    }
    
    //Loops through the word to check each occurrence of the guessed letter
    private void checkGuess(String guess) {
    	guesses --;
    	int count = 0;     	
    	
    	for(int i = 1; i < y + 1; i++) {
    		s_1 = word.substring(i - 1, i);
    		s_1 = s_1.toUpperCase();
    		if (s_1.equals(guess) == true) {
    			guessedLetters.add(s_1);
    			count ++;
    			countTotal ++;
        		hidden = hidden.substring(0, i - 1) + s_1 + hidden.substring(i);
        		canvas.displayWord(hidden);


    		}
    	}

    	
    	//Responds back to the user the result
    	if(s_1.equals(guess) == false && count == 0) {
    		wrong++;
    		guessedLetters.add(guess);
    		println(wrong);
			println("There are no " + guess + "\'s in the word.");
				
		} else {
			println("That guess is correct.");
		}
		println("The word now looks like: " + hidden );
        println("You have " + guesses + " guesses left.");
    }
    //Checks to see if the letter was guessed more than once
    private boolean alreadyGuessed(String guess) {
    	guess = guess.toUpperCase();
    	boolean guessed = false;
    	println(guessedLetters);
    	if(guessedLetters.contains(guess)) {
    		guessed = true;
    	}
    	return guessed;
    }
    
    //Checks to see if String is a letter or not
    private boolean isLetter(String guess) {
    	boolean letterOrNot = true;
    	for(int i = 0; i < guess.length(); i++) {
   	 		char ch = guess.charAt(i);
   	 		if(Character.isLetter(ch) == false) {
   	 			letterOrNot = false;
   	 		}
   	 	}
    	return letterOrNot;
    }
   
    
    
    /* private instance varables
     * and 1 class variable*/
    private HangmanLexicon x;
    private int y;
    private int countTotal;
    private int guesses = 8;
    private int wrong = 0;
    private String s_1;
    private String result;
    private String word;
    static String hidden;
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private ArrayList <String> guessedLetters = new ArrayList <String>();
    private HangmanCanvas canvas;
    

    
 
}
