package assignments;
import java.util.*;

public class REPLApp {

	public static void main(String[] args) {
		System.out.println("Welcome to my REPL App!");
		Scanner in = new Scanner (System.in);
		System.out.print(">");
		String option = in.next();
		
		while (!option.equalsIgnoreCase("quit")){
			if (option.equalsIgnoreCase("help")) {
				System.out.println("Available commands:\n add\n subtract\n multiply\n divide\n random\n reverse\n quit");
			}else if (option.equalsIgnoreCase("add") || option.equalsIgnoreCase("subtract") || 
					option.equalsIgnoreCase("multiply") ||option.equalsIgnoreCase("divide")) {
				System.out.print("First number: ");
				int number1 = in.nextInt();
				
				System.out.print("Second number: ");
				int number2 = in.nextInt();
				
				if(option.equalsIgnoreCase("add")) {
					System.out.println("Result: " + (number1+number2));
				}else if(option.equalsIgnoreCase("subtract")) {
					System.out.println("Result: " + (number1-number2));
				}else if(option.equalsIgnoreCase("multiply")) {
					System.out.println("Result: " + (number1*number2));
				}else{
					if(number2 == 0) {
						System.out.println("Cannot Divide by 0");
					}else {
					System.out.println("Result: " + (number1-number2));
					}
				}
			}else if(option.equalsIgnoreCase("random")) {
				System.out.print("Minimum: ");
				int min = in.nextInt();
				System.out.print("Maximum: ");
				int max = in.nextInt();
				
				System.out.println("Random Number: " + ((int)(Math.random()*(max-min)*1)));
			}else if(option.equalsIgnoreCase("reverse")) {
				in.nextLine();
				System.out.print("Enter text: ");
				String text = in.nextLine();
				
				String rev = "";
				for(int i=text.length()-1;i>=0;i--) {
					rev += text.charAt(i);
				}
				System.out.println(rev);
			}else {
				System.out.println("Command not available.");
			}
			System.out.println();
			System.out.print(">");
			option = in.next();
		}
		System.out.println("Goodbye!");
		in.close();
		
	}
}
