public class SecondsAndMinutesChallenge {

    public static void main(String[] args) {
        System.out.println(getDurationString(61, 59));
        System.out.println(getDurationString(500));
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0 || seconds < 0 || seconds > 59) {
            return "Invalid value";
        }
        return String.format("%dh %dm %ds", minutes / 60, minutes % 60, seconds);
    }

    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return "Invalid value";
        }
        return getDurationString(seconds / 60, seconds % 60);
    }

}
