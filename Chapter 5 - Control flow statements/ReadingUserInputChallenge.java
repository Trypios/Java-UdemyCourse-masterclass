import java.util.Scanner;

public class ReadingUserInputChallenge {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // -Read 10 numbers from the console entered by the user and print the sum of those numbers.
        int counter = 0;
        int sum = 0;
        while (counter < 10) {
            System.out.println("Enter number #" + (counter + 1));

            if (scanner.hasNextInt()) {
                sum += scanner.nextInt();
                scanner.nextLine();
                counter++;
            } else {
                System.out.println("Invalid number");
                scanner.nextLine();
            }
        }
        scanner.close();
        System.out.println(sum);

    }
}
