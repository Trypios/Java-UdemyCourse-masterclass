public class NumberToWords {
    // write your code here
    public static void numberToWords(int number) {
        //The method should print out the passed number using words for the digits.
        if (number < 0) {
            System.out.println("Invalid Value");
        } else if (number == 0) {
            System.out.println("Zero");
        }
        int reversedNumber = reverse(number);
        int leadingZero = (getDigitCount(number) - getDigitCount(reversedNumber));
        while (reversedNumber>0) {
            int digit = reversedNumber % 10;
            switch (digit) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }
            reversedNumber = reversedNumber / 10;
        }
        //deal with leading zeros of reversed number
        for (int i=0; i<leadingZero; i++) {
            System.out.println("Zero");
        }
    }

    public static int reverse(int number) {
        //returns number in reverse order. Useful to iterate through
        int reverseNumber = 0;
        if (number > 0) {
            while (number >= 1) {
                reverseNumber *= 10;
                int singleDigit = number % 10;
                reverseNumber += singleDigit;
                number /= 10;
            }
        } else if (number < 0) {
            number = Math.abs(number);
            while (number >= 1) {
                reverseNumber *= 10;
                int singleDigit = number % 10;
                reverseNumber += singleDigit;
                number /= 10;
            }
            reverseNumber *= -1;
        }
        return reverseNumber;

    }

    public static int getDigitCount(int number) {
        //returns the count of digits in number. Useful for leading zeros
        if (number < 0) {
            return -1;
        } else if (number == 0) {
            return 1;
        }
        int digitCounter = 0;
        while (number > 0) {
            digitCounter += 1;
            number /= 10;
        }
        return digitCounter;

    }
}