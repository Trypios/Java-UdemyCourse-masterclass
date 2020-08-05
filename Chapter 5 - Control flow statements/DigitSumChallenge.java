public class DigitSumChallenge {

    public static void main(String[] args) {
        System.out.println("Sum of digits for number 125 is " + sumDigits(125));
        System.out.println("Sum of digits for number 71447 is " + sumDigits(71447));
    }

    public static int sumDigits(int number) {
        int total = 0;
        if (number >= 10) {
            while (number != 0) {
                total += number % 10;
                number /= 10;
            }
            return total;
        }
        return -1;
    }
}
