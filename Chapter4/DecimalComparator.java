public class DecimalComparator{
    public static boolean areEqualByThreeDecimalPlaces(double number1, double number2) {

       double value1 = number1 * 1000;
       double value2 = number2 * 1000;
       System.out.println(value1 + " & " + value2);

       if ((int) value1 == (int) value2) {
           return true;
       } else {
           return false;
       }

   }
}