package first_project;

public class Question1 {
    public static void main(String[] args) {
        byte b = 10;
        short s = 1000;
        int i = 100000;
        long l = 1000000L;
        float f = 3.14f;
        double d = 3.14159;
        char c = 'A';
        boolean b_v = true;

        System.out.println("Byte: " + b + ", Size: " + Byte.SIZE + " bits");
        System.out.println("Short: " + s + ", Size: " + Short.SIZE + " bits");
        System.out.println("Int: " + i + ", Size: " + Integer.SIZE + " bits");
        System.out.println("Long: " + l + ", Size: " + Long.SIZE + " bits");
        System.out.println("Float: " + f + ", Size: " + Float.SIZE + " bits");
        System.out.println("Double: " + d + ", Size: " + Double.SIZE + " bits");
        System.out.println("Char: " + c + ", Size: " + Character.SIZE + " bits");
        System.out.println("Boolean: " + b_v );
    }
}
