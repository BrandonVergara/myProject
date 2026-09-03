package assignments;

import java.util.Scanner;

public class WordAnalyzer {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a word: ");
		String word = in.nextLine().toLowerCase();
		
		int characters = word.length();
		int vowels = 0;
		int cons = 0;
		int digits = 0;
		int spaces = 0;
		
		for(int i=0; i<characters ;i++) {
			char c = word.charAt(i);
			
			if(c == 'a'| c== 'e' | c == 'i' | c == 'o' | c == 'u') {
				vowels++;
			}else if(Character.isLetter(c)){
				cons++;
			}
			if(Character.isDigit(c)) {
				digits++;
			}
			if(c == ' ') {
				spaces++;
			}
		}
		
		System.out.println("Characters: " + characters);
		System.out.println("Vowels: " + vowels);
		System.out.println("Consonants: " + cons);
		System.out.println("Digits: " + digits);
		System.out.println("Spaces: " + spaces);
		
		in.close();
	}
}
