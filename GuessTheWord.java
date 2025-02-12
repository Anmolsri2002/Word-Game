package game;

import java.util.Scanner;

public class GuessTheWord {
	private boolean play=true;
	private Words randomword=new Words();
	private Scanner scanner=new Scanner(System.in);
	private int rounds=randomword.selectedWord.length();
	private char lastRound;
	public void start() {
		do {
			showWord();
			getInput();
			checkInput();
		}while(play);
	}
	void showWord() {
		System.out.println("You have "+ rounds + " tries left.");
		System.out.println(randomword);
	}
	void getInput() {
		System.out.println("Enter a letter to guess the word: ");
		String UserGuess=scanner.nextLine();
		lastRound=UserGuess.charAt(0);
	}
	void checkInput() {
		boolean isGuessedRight=randomword.guess(lastRound);
		if(isGuessedRight) {
			if(randomword.isGuessedRight()) {
				System.out.println("Congrats, you won !");
				System.out.println("The guessed word is "+ randomword);
				play=false;
			}
		}
		else {
			rounds--;
			if(rounds==0) {
				System.out.println("Game Over");
				play=false;
			}
		}
	}
	public void end() {
		scanner.close();
	}
	
}
