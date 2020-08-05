import java.util.Scanner;

public class InputCalculator {

    public static void main(String[] args) {

        inputThenPrintSumAndAverage();

    }

    public static void inputThenPrintSumAndAverage() {

        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int sum = 0;
        long avg = 0;

        while (true) {
            System.out.println("Enter number: ");
            boolean isInteger = scanner.hasNextInt();
            if (isInteger) {
                int userNumber = scanner.nextInt();
                scanner.nextLine();
                sum += userNumber;
                counter++;
            } else {
                break;
            }
        }
        if (counter>0) {
            avg = Math.round(sum / (double) counter);
        }

        System.out.println("SUM = " + sum + " AVG = " + avg);
        scanner.close();
    }

}