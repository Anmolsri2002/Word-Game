package game;
import java.util.Random;

public class Words {
	private String[] randomwords= {"Animals","Dance","Birthday","Internship","Placement",
			"Package","Success","Innovation"};
	String selectedWord;
	private Random random=new Random();
	private char[] letters;
	public Words() {
		selectedWord=randomwords[random.nextInt(randomwords.length)];
		letters=new char[selectedWord.length()];
	}
	public String toString() {
		StringBuilder text=new StringBuilder();
		for(char letter:letters) {
			if(letter=='\u0000') {
				text.append('-');
			}
			else {
				text.append(letter);
			}
			text.append(' ');
		}
		return text.toString();
	}
	
	public boolean guess(char letter) {
		boolean guessedRight=false;
		
		for(int i=0;i<selectedWord.length();i++) {
			if(letter==selectedWord.charAt(i)) {
				letters[i]=letter;
				guessedRight=true;
			}
		}
		return guessedRight;
	}
	public boolean isGuessedRight() {
		for(char letter:letters) {
			if(letter=='\u0000') {
				return false;
			}
		}
		return true;
	}
}
