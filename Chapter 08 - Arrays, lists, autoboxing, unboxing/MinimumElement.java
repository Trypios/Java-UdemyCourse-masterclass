import java.util.Scanner;

public class MinimumElement {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count = scanner.nextInt();
        int[] intList = readIntegers(count);
        int minValue = findMin(intList);
        System.out.println("The minimum value is " + minValue);
    }

    private static int[] readIntegers(int count) {
        int[] array = new int[count];
        System.out.println("Enter " + count + " whole numbers: ");
        for (int i=0; i<count; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int findMin(int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }

}
