package assignments;

public class PrintTest {
	public static void main(String[] args) {
		
		//Challenge - Hello World
		System.out.println("Hello World!");
		System.out.println();
		
		
		//Challenge - Printing Output
		int age = 23;
		double height = 5.67;
		String name = "Brandon Vergara";
		
		System.out.println("Name: " + name + ", Age: " + age + ", Height: " + height);
		System.out.println();
		
		//Challenge - Operators
		int a = 20;
		int b = 10;
		
		System.out.println("Addition: " + (a+b));
		System.out.println("Subtraction: " + (a-b));
		System.out.println("Multiplication: " + (a*b));
		System.out.println("Division: " + (a/b));
		
		boolean comp = a>b;
		boolean check = (a>b && b>0);
		System.out.println("Is a greater than b? " + comp);
		System.out.println("Is a>b and b>0? " + check);
		System.out.println();
		
		//Challenge - Control Flow
		int score = 75;
		char grade = 'B';
		String finalG;
		
		if(score >= 50) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
		
		if(score>=90) {
			finalG = "A";
		}else if(score >= 75 && score <=89) {
			finalG = "B";
		}else if(score>=60 && score<=74) {
			finalG = "C";
		}else {
			finalG = "D";
		}
		
		System.out.println("Grade: " + finalG);
		System.out.println();
		
		//Challenge - Loops
		System.out.print("For Loop:");
		for(int i = 1; i<=5; i++) {
			System.out.print(" " + i);
		}
		System.out.println();
		
		int j=0;
		System.out.print("While Loop:");
		while(j<=5) {
			j++;
			System.out.print(" " + j);
		}
		System.out.println();
		
		System.out.print("Do-While Loop:");
		int g = 0;
		do {
			g++;
			System.out.print(" " + g);
		}while(g<5);
		System.out.println();
		System.out.println();
		
		//Challenge - Calculator
		double num1 = 7;
		double num2 = 3;
		char operator = '+';
		double value = 0;
		
		String again = "y";
		while(again.equals("y")) {
			if(operator == '+') {
				value = num1 + num2;
			}else if(operator == '-') {
				value = num1 - num2;
			}else if (operator == '*') {
				value = num1 * num2;
			}else if (operator == '/') {
				if(num2 == 0) {
					System.out.println("Cannot divide by zero.");
					break;
				}
			}else {
				System.out.println("Operator unrecognized.");
				break;
			}
			
			System.out.println("Result: " + value);
			again ="n";
		}
		System.out.print("Thank you for using the calculator.");
	}
}
