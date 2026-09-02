package assignments;
import java.util.Scanner;

public class REPL {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("BANK\nEnter a number for one of the following:\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
		double balance = 0;

		int opt = in.nextInt();
		while(opt != 4) {
	
			if(opt == 1) {
				System.out.println("Balance is: " + balance);
			}else if(opt == 2) {
				System.out.print("How much would you like to deposit: ");
				double add = in.nextDouble();
				balance += add;
				System.out.println("Amount Deposited. New Balance is: " + balance);
			}else if(opt == 3) {
				System.out.print("How much would you like to withdraw: ");
				double subtract = in.nextDouble();
				if((balance - subtract)<0) {
					System.out.println("Remaining balance cannot negative. Try again.");
					subtract = in.nextDouble();
				}else {
				balance -= subtract;
				System.out.println("Amount Withdrawn. New Balance is: " + balance);
				}
			}else {
				System.out.println("Option not detected. Try again.");
			}
			
			System.out.print("Enter Option: ");
			opt = in.nextInt();
		}
		
		System.out.println("Account exited successfully Thank You!");
		in.close();
	}
}
