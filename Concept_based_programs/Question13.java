// Program to find the greatest of three numbers
package first_project;

import java.util.Scanner;

public class Question13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter three numbers: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        if (a >= b && a >= c) {
            System.out.println(a + " is the greatest number.");
        } else if (b >= a && b >= c) {
            System.out.println(b + " is the greatest number.");
        } else {
            System.out.println(c + " is the greatest number.");
        }

        sc.close();
    }
}
