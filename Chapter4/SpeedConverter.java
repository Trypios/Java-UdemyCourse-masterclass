public class SpeedConverter {
    
    public static long toMilesPerHour(double kilometersPerHour) {
        double milesPerHour = kilometersPerHour / 1.609d;
        if (kilometersPerHour < 0) {
            return -1;
        } else {
            return Math.round(milesPerHour);
        }
    }

    public static void printConversion(double kilometersPerHour) {
        long result = toMilesPerHour(kilometersPerHour);
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometersPerHour + " km/h = " + result + " mi/h");
        }

    }
}