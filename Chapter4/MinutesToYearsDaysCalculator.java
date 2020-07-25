public class MinutesToYearsDaysCalculator {

    public static void printYearsAndDays(long minutes) {
        //calculate the years and days from the minutes parameter
        if (minutes < 0) {
            System.out.println("Invalid Value");
        } else {
            long totalDays = (minutes / 60) / 24;
            long years = totalDays / 365;
            long days = totalDays % 365;
            System.out.println(minutes + " min = " + years + " y and " + days + " d");
        }
    }
}