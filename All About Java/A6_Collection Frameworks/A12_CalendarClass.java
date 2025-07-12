/*Java Calendar class is an abstract class that provides methods for converting date between a 
specific instant in time and a set of calendar fields such as MONTH, YEAR, HOUR, etc. It 
inherits Object class and implements the Comparable interface.

 */
//Today 26/06/2025
import java.util.Calendar;
import java.util.TimeZone;
class A12_CalendarClass{
    // Helper method to print date in a readable format
        private static void printDate(Calendar calendar) {
            System.out.println("Date: " + calendar.get(Calendar.DAY_OF_MONTH) + "/"+ (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR));
        }

    // Helper method to print date and time
    private static void printDateAndTime(Calendar calendar) {
        System.out.println("Date: " + calendar.get(Calendar.DAY_OF_MONTH) + "/"
                + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR));
        System.out.println("Time: " + calendar.get(Calendar.HOUR_OF_DAY) + ":"
                + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
    }

    // Helper method to get the day of the week name
    private static String getDayName(int day) {
        switch (day) {
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
            default:
                return "Invalid";
        }
    }
    public static void main(String[] args){
        //get the current date and time
        Calendar calendar = Calendar.getInstance();

        System.out.println("=== Current Date and Time ===");
        System.out.println("The current date is : " + calendar.getTime()); //The current date is : Thu Jun 26 17:51:40 IST 2025
        
        System.out.println("Year: " + calendar.get(Calendar.YEAR));//Year: 2025
        System.out.println("Month: " + (calendar.get(Calendar.MONTH) + 1)); // 0-based month   //Month: 6
        System.out.println("Day: " + calendar.get(Calendar.DAY_OF_MONTH));//Day: 26
        System.out.println("Hour: " + calendar.get(Calendar.HOUR_OF_DAY)); // 24-hour format   //Hour: 17
        System.out.println("Minute: " + calendar.get(Calendar.MINUTE));//Minute: 33
        System.out.println("Second: " + calendar.get(Calendar.SECOND));//Second: 16
        System.out.println();

         // Add 5 days to the current date
        calendar.add(Calendar.DAY_OF_MONTH, 5);
        System.out.println("=== After Adding 5 Days ===");
        printDate(calendar);//Date: 1/7/2025
        
        
         // Subtract 3 months
        calendar.add(Calendar.MONTH, -3);
        System.out.println("=== After Subtracting 3 Months ===");
        printDate(calendar);//Date: 1/4/2025
    
        // Set a specific date
        calendar.set(2025, Calendar.DECEMBER, 25); // Year, Month (0-based), Day
        System.out.println("=== Setting Date to Christmas (Dec 25, 2025) ===");
        printDate(calendar);//Date: 25/12/2025

        // Get the day of the week
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("Day of the Week: " + getDayName(dayOfWeek));
        System.out.println();

//**************************************************** */

        // Timezone demonstration
        TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
        Calendar tzCalendar = Calendar.getInstance(timeZone);
        System.out.println("=== Date and Time in New York ===");
        printDateAndTime(tzCalendar);//Date: 26/6/2025  Time: 8:15:5
        


        // Current Time Demonstration
        Calendar timeCalendar = Calendar.getInstance();
        System.out.println("=== Current Time ===");
        System.out.println("Hour: " + timeCalendar.get(Calendar.HOUR));
        System.out.println("Hour (24-hour format): " + timeCalendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minute: " + timeCalendar.get(Calendar.MINUTE));
        System.out.println("Second: " + timeCalendar.get(Calendar.SECOND));
    }
}