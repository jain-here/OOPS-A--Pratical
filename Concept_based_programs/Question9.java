// Program to demonstrate bitwise operators
package first_project;

import java.util.Scanner;

public class Question9 {

	public static void main(String[] args) {
		System.out.println("Enter 2 nums");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("the AND will be :" + (a&b) + "\n" + "the OR will be :" + (a|b) + "\n" + "the XOR will be :" + (a^b) + "\n" + "the LEFT_SHIFT will be :" + (a<<b) + "\n" + "the RIGHT_SHIFT will be :" + (a>>b) + "\n");
		System.out.println("================");
		System.out.println("the AND will be :" + Integer.toBinaryString(a&b) + "\n" + "the OR will be :" + Integer.toBinaryString(a|b) + "\n" + "the XOR will be :" + Integer.toBinaryString(a^b) + "\n" + "the LEFT_SHIFT will be :" + Integer.toBinaryString(a<<b) + "\n" + "the RIGHT_SHIFT will be :" + Integer.toBinaryString(a>>b) + "\n");
	}
}
