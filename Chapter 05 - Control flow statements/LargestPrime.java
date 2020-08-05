public class LargestPrime {

    public static void main(String[] args) {

        System.out.println(getLargestPrime(21)); //should return 7 since 7 is the largest prime (3 * 7 = 21)
        System.out.println(getLargestPrime(217)); //should return 31 since 31 is the largest prime (7 * 31 = 217)
        System.out.println(getLargestPrime(0)); //should return -1 since 0 does not have any prime numbers
        System.out.println(getLargestPrime(45)); //should return 5 since 5 is the largest prime (3 3 * 5 = 45)
        System.out.println(getLargestPrime(-1)); //should return -1 since the parameter is negative
        System.out.println(getLargestPrime(7)); //should return 7
        System.out.println(isPrime(15));

    }
    
    public static int getLargestPrime(int number) {

        int largestPrime = -1;
        for (int i=3; i<=number; i++) {
            if ((number % i ==0) && (isPrime(i))) {
                largestPrime = i;
            }
        }
        return largestPrime;

    }

    public static boolean isPrime(int number) {
        for (int i=2; i<number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

