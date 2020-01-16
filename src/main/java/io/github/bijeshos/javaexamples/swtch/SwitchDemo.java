package io.github.bijeshos.javaexamples.swtch;

/*
from java 7 and higher
 */

public class SwitchDemo {
    public static void main(String[] args) {
        System.out.println(getTypeOfDayWithSwitchStatement("Monday"));
        System.out.println(getTypeOfDayWithSwitchStatement("Wednesday"));
        System.out.println(getTypeOfDayWithSwitchStatement("Friday"));
        System.out.println(getTypeOfDayWithSwitchStatement("Sunday"));
    }

    public static String getTypeOfDayWithSwitchStatement(String dayOfWeek) {
        String typeOfDay;
        switch (dayOfWeek) {
            case "Monday":
                typeOfDay = "Start of work week";
                break;
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                typeOfDay = "Midweek";
                break;
            case "Friday":
                typeOfDay = "End of work week";
                break;
            case "Saturday":
            case "Sunday":
                typeOfDay = "Weekend";
                break;
            default:
                throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeek);
        }
        return typeOfDay;
    }
}
