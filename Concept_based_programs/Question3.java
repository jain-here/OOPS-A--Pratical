// Program to demonstrate widening type conversion
package first_project;

public class Question3 {

	public static void main(String[] args) {
		int i = 100;
		long l = i; // int to long
		float f = l; // long to float

		System.out.println("Int value: " + i);
		System.out.println("Long value: " + l);
		System.out.println("Float value: " + f);
	}
}