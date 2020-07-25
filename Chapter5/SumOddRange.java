public class SumOddRange {

    public static void main(String[] args) {

        System.out.println(sumOdd(1, 100)); //→ should return 2500
        System.out.println(sumOdd(-1, 100)); //→  should return -1
        System.out.println(sumOdd(100, 100)); //→ should return 0
        System.out.println(sumOdd(13, 13)); //→ should return 13 (This set contains one number, 13, and it is odd)
        System.out.println(sumOdd(100, -100)); //→ should return -1
        System.out.println(sumOdd(100, 1000)); //→ should return 247500

        int number = 4;
        int finishNumber = 20;
        int evenCounter = 0;
        while(number <= finishNumber) {
            if(!isEvenNumber(number)) {
                number++;
                continue;
            }
            if(evenCounter>=5) {
                break;
            }

            System.out.println("Even number " + number);
            number++;
            evenCounter++;
        }
        System.out.println(evenCounter + " even numbers have been found");

    }

    public static boolean isEvenNumber(int number) {
        if ((number % 2) != 0) {
            return false;
        }
        return true;
    }

    public static boolean isOdd(int number) {
        if ((number <= 0) || (number % 2 == 0)) {
            return false;
        }
        return true;
    }

    public static int sumOdd(int start, int end) {
        if ((end < start) || (start < 0) || (end < 0)) {
            return -1;
        }
        int oddSum = 0;
        for(int i=start; i<=end; i += 1) {
            if (isOdd(i)) {
                oddSum += i;
            }
        }
        return oddSum;
    }

}
