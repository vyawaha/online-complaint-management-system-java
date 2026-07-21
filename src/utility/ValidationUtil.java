package utility;


/**
 * Utility class for validating
 * user and complaint input data.
 *
 * Contains only static methods.
 */
public class ValidationUtil {


    /**
     * Validates user name.
     *
     * Rules:
     * - Cannot be null
     * - Cannot be empty
     *
     */
    public static boolean isValidName(
            String name
    ) {


        return name != null
                && !name.trim().isEmpty();


    }



    /**
     * Validates email format.
     *
     * Example:
     *
     * valid:
     * user@gmail.com
     *
     * invalid:
     * usergmail.com
     */
    public static boolean isValidEmail(
            String email
    ) {


        if(email == null || email.trim().isEmpty()) {

            return false;

        }


        return email.matches(
                "^[A-Za-z0-9+_.-]+@(.+)$"
        );


    }



    /**
     * Validates password.
     *
     * Minimum length:
     * 4 characters
     */
    public static boolean isValidPassword(
            String password
    ) {


        return password != null
                &&
                password.length() >= 4;


    }



    /**
     * Validates complaint title.
     *
     * Rules:
     * - Cannot be empty
     * - Minimum 3 characters
     */
    public static boolean isValidComplaintTitle(
            String title
    ) {


        return title != null
                &&
                title.trim().length() >= 3;


    }



    /**
     * Validates complaint description.
     *
     * Rules:
     * - Cannot be empty
     * - Minimum 10 characters
     */
    public static boolean isValidDescription(
            String description
    ) {


        return description != null
                &&
                description.trim().length() >= 10;


    }



    /**
     * Generic empty string check.
     */
    public static boolean isEmpty(
            String value
    ) {


        return value == null
                ||
                value.trim().isEmpty();


    }


}