package assignments;

import java.util.Scanner;

public class CalculateScores {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter 5 test scores: ");
		
		int[] scores = new int[5];
		int l = scores.length;
		
		for(int i = 0;i<l; i++) {
			scores[i]=in.nextInt();
		}
		
		int total = 0;
		for (int i=0;i<l;i++) {
			total += scores[i];
		}
		System.out.println("Total: " + total);
		
		int average = total/l;
		System.out.println("Average: " + average);
		
		int highest = scores[0];
		int lowest = scores[0];
		
		for(int i=0; i<l; i++) {
			if(scores[i]>highest) {
				highest = scores[i];
			}
			if(scores[i]<lowest) {
				lowest = scores[i];
			}
		}
		
		System.out.println("Highest: " + highest);
		System.out.println("Lowest: " + lowest);
		
		for (int i=0; i<l; i++) {
			int score = scores[i];
			
			if(score >= 90) {
				System.out.println(score + " - A");
			}else if(score >= 80) {
				System.out.println(score + " - B");
			}else if(score >= 70) {
				System.out.println(score + " - C");
			}else if(score >= 60) {
				System.out.println(score + " - D");
			}else {
				System.out.println(score + " - F");
			}
		}
		
		in.close();
		
	}
}
