package library;

public class Series {

    public static void main(String[] args) {}

    public static int factorial(int n) {
        // returns n! (n factorial)
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            System.out.println("No negative numbers");
            return n;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int nSum(int n) {
        // returns the sum of all whole numbers from 0 to n
        if (n == 0) {
            return 0;
        } else if (n < 0) {
            System.out.println("No negative numbers");
            return n;
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static int fibonacci(int n) {
        // returns the nth fibonacci number where f(n) = f(n-1) + f(n-2)
        if (n == 0) {
            return 0;
        }

        int a = 0;
        int b = 1;
        int temp;
        for (int i = 1; i < n; i++) {
            temp = a;
            a = b;
            b = temp + a;
        }
        return b;
    }

}
