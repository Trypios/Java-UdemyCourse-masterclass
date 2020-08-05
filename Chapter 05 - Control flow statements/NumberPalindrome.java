public class NumberPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221)); //→ should return true
        System.out.println(isPalindrome(707452)); //→ should return false
        System.out.println(isPalindrome(174525471)); //→ should return true
        System.out.println(isPalindrome(11212)); //→ should return false because reverse is 21211 and that is not equal to 11212.
    }

    public static boolean isPalindrome(int number) {

        int reverse = 0;
        int tempNumber = Math.abs(number);
        while (tempNumber >= 1) {
            reverse *= 10;
            int singleDigit = tempNumber % 10;
            reverse += singleDigit;
            tempNumber /= 10;
        }
        if (Math.abs(number) == reverse) {
            return true;
        }
        return false;

    }
}
