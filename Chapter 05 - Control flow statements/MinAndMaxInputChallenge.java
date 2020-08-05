import java.util.Scanner;

public class MinAndMaxInputChallenge {

    public static void main(String[] args) {

        int minNumber = 0;
        int maxNumber = 0;
        Scanner userNumbers = new Scanner(System.in);

        while (true) {
            System.out.println("Enter number: ");
            boolean isInteger = userNumbers.hasNextInt();
            if(isInteger) {
                int number = userNumbers.nextInt();
                if(minNumber>number) {
                    minNumber = number;
                }
                if(maxNumber<number) {
                    maxNumber = number;
                }
            } else {
                System.out.println("Invalid number");
                break;
            }
            userNumbers.nextLine();

        }
        System.out.println("The minimum number entered was: "+minNumber);
        System.out.println("The maximum number entered was: "+maxNumber);
        userNumbers.close();

    }

}