// Program to demonstrate operator precedence
package first_project;

public class Question6 {
	    public static void main(String[] args) {
	        // Expression 1: 10 + 2 * 5
	        int result1 = 10 + 2 * 5;
	        System.out.println("10 + 2 * 5 = " + result1); // 20

	        // Expression 2: (10 + 2) * 5
	        int result2 = (10 + 2) * 5;
	        System.out.println("(10 + 2) * 5 = " + result2); // 60

	        // Expression 3: 100 / 5 + 2 * 3 - 4
	        int result3 = 100 / 5 + 2 * 3 - 4;
	        System.out.println("100 / 5 + 2 * 3 - 4 = " + result3); // 22
	    }
	}
