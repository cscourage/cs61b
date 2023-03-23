/** Class that determines whether or not a year is a leap year.
<<<<<<< HEAD
 *  @author YOUR NAME HERE
=======
 *  @author Tyrone
>>>>>>> 61f35c9fa9542eaa400e4bb929b0cecbda1fbaf4
 */
public class LeapYear {

    /** Calls isLeapYear to print correct statement.
     *  @param  year to be analyzed
     */
    private static void checkLeapYear(int year) {
        if (isLeapYear(year)) {
            System.out.printf("%d is a leap year.\n", year);
        } else {
            System.out.printf("%d is not a leap year.\n", year);
        }
    }

<<<<<<< HEAD
=======
    /** Judge if the given year is a leap year. */
    public static boolean isLeapYear(int year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

>>>>>>> 61f35c9fa9542eaa400e4bb929b0cecbda1fbaf4
    /** Must be provided an integer as a command line argument ARGS. */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter command line arguments.");
            System.out.println("e.g. java Year 2000");
        }
        for (int i = 0; i < args.length; i++) {
            try {
                int year = Integer.parseInt(args[i]);
                checkLeapYear(year);
            } catch (NumberFormatException e) {
                System.out.printf("%s is not a valid number.\n", args[i]);
            }
        }
    }
}

