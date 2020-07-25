public class NumberOfDaysInMonth {

    public static void main(String[] args) {
        System.out.println(isLeapYear(-1600)); //→  should return false since the parameter is not in the range (1-9999)
        System.out.println(isLeapYear(1600)); //→ should return true since 1600 is a leap year
        System.out.println(isLeapYear(2017)); //→ should return false since 2017 is not a leap year
        System.out.println(isLeapYear(2000)); //→ should return true because 2000 is a leap year
        System.out.println(getDaysInMonth(1, 2020)); //→ should return 31 since January has 31 days
        System.out.println(getDaysInMonth(2, 2020)); //→ should return 29 since February has 29 days in a leap year and 2020 is a leap year.
        System.out.println(getDaysInMonth(2, 2018)); //→ should return 28 since February has 28 days if it's not a leap year and 2018 is not a leap year.
        System.out.println(getDaysInMonth(-1, 2020)); //→ should return -1 since the parameter month is invalid.
        System.out.println(getDaysInMonth(1, -2020)); //→ should return -1 since the parameter year is outside the range of 1 to 9999.
    }

    public static boolean isLeapYear(int year) {
        //true for a leap year
        if ((year < 1) || (year > 9999)) {
            return false;
        }
        if (year % 4 == 0) {
            if ((year % 100 == 0) && (year % 400 == 0)) {
                return true;
            } else if (year % 100 == 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public static int getDaysInMonth(int month, int year) {
        //return number of days in the month
        if ((month < 1) || (month > 12) || (year < 1) || (year > 9999)) {
            return -1;
        }
        switch (month) {
            case 1:case 3:case 5:case 7:case 8:case 10:case 12:
                return 31;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
        }
        return 30;
    }
}
