package assignments;
import java.util.Scanner;

public class PasswordValidator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please create a passwword\nPassword must:\nBe at least 8 Characters\nContain at least one uppercase letter\nContain at least one lowercase letter\nContain at least one number");
		String password = in.next();
		
		boolean condition = false;
		while(!condition) {
			boolean length = password.length() >= 8;
			boolean upper = false;
			boolean lower = false;
			boolean number = false;
			
			for(int i = 0; i<password.length();i++) {
				char c = password.charAt(i);
				
				if(Character.isUpperCase(c)) {
					upper = true;
				}
				if(Character.isLowerCase(c)) {
					lower = true;
				}
				if(Character.isDigit(c)) {
					number = true;
				}
				if(upper && lower && number) {
					if(length) {
						condition = true;
						break;
					}
					break;
				}
			}
			
			if(condition) {
				System.out.println("Password accepted!");
				break;
			}else {
				System.out.println("Password rejected:");
				if(!length) System.out.println("-Must be at least 8 characters.");
				if(!upper) System.out.println("-Must contain an uppercase letter.");
				if(!lower) System.out.println("Must containg a lower case letter.");
				if(!number) System.out.println("-Must contain at one number");
				
				password = in.next();
			}
		}
		
		in.close();
	}
}
