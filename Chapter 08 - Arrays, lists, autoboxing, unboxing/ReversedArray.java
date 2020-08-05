import java.util.Arrays;
import java.util.Scanner;

public class ReversedArray {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count = scanner.nextInt();
        int[] intList = readIntegers(count);
        int[] reverseIntList = reverse(intList);
        System.out.println("Array: " + Arrays.toString(intList));
        System.out.println("Reversed array: " + Arrays.toString(reverseIntList));
    }

    private static int[] readIntegers(int count) {
        int[] array = new int[count];
        System.out.println("Enter " + count + " whole numbers: ");
        for (int i=0; i<count; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int[] reverse(int[] array) {
        int[] reversedArray = new int[array.length];
        int i1 = 0;
        int i2 = array.length - 1;
        while (i1 < array.length) {
            reversedArray[i1] = array[i2];
            i1++;
            i2--;
        }
        return reversedArray;
    }

}
