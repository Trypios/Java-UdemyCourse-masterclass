public class GreatestCommonDivisor {
    // write your code here
    public static int getGreatestCommonDivisor(int first, int second) {

        if ((first  < 10) || (second < 10)) {
            return -1;
        } else if (first>second) {
            for (int i=second; i>1; i--) {
                if ((first % i == 0) && (second % i == 0)) {
                    return i;
                }
            }
        } else if (first<second) {
            for (int i=first; i>1; i--) {
                if ((first % i == 0) && (second % i == 0)) {
                    return i;
                }
            }
        }
        return -1;
    }
}