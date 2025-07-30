package first_project;

import java.util.Scanner;

public class Question10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter a number");
		Scanner scanf = new Scanner(System.in);
		double num = scanf.nextDouble();
		
		if (num % 3 == 0  && num % 5 == 0)
			System.out.println("it is divisible by 3 and 5");
		else
		System.out.println("does not work");
		
		
		
		
		
	}
	
	
	

}
