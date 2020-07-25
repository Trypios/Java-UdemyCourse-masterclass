public class Sum3and5 {

    public static void main(String[] args) {

        // get sum of the first 5 numbers that can be divided by 3 and 5
        int counter = 0;
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i % 3 == 0 && i % 5 ==0) {
                System.out.println(i);
                sum += i;
                counter++;
            }
            if (counter == 5) {
                break;
            }
        }
        System.out.println(sum);
    }
}