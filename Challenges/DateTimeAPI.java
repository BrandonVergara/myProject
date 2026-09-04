package assignments;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.Period;
import java.util.Scanner;

public class DateTimeAPI {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		
		System.out.println("Date: " + today);
		System.out.println("Year: " + today.getYear());
		System.out.println("Month: " + today.getMonth());
		System.out.println("Day: " + today.getDayOfMonth());
		System.out.println();
		
		
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your birthday: ");
		String birthday = in.nextLine();
		
		LocalDate bday = LocalDate.parse(birthday);
		Period age = Period.between(bday, today);
		
		System.out.println("You are " + age.getYears() + " years old");
		System.out.println();
		
		
		
		System.out.print("Enter your birthday: ");
		String birthday1 = in.nextLine();
		LocalDate bday1 = LocalDate.parse(birthday1);
		
		LocalDate nextbday = LocalDate.of(today.getYear(), bday1.getMonth(), bday.getDayOfMonth());
		
		if(nextbday.isBefore(today)) {
			nextbday = nextbday.plusYears(1);
		}
		
		long days = ChronoUnit.DAYS.between(today, nextbday);
		System.out.println("Days until your next birthday: " + days);
		in.close();
	}

}
