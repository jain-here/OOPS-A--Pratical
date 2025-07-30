// Program to demonstrate type casting
package first_project;

public class Question3 {

	public static void main(String[] args) {
		float f = 5.0f;
		System.out.println("Value = " + String.format("%.8f", f));
		System.out.printf("Value = %.8f\n", f);
		System.out.println(f);
		int i = (int)f;
		System.out.println(i);
	}
}
