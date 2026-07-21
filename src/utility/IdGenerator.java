package utility;


/**
 * Generates unique IDs for complaints.
 *
 * Example:
 *
 * CMP1001
 * CMP1002
 * CMP1003
 *
 */
public class IdGenerator {


    private static int complaintCounter = 1000;



    /**
     * Generates complaint ID
     *
     * @return unique complaint ID
     */
    public static String generateComplaintId() {


        complaintCounter++;


        return "CMP" + complaintCounter;


    }



    /**
     * Generates user ID
     *
     * @return unique user ID
     */
    public static int generateUserId() {


        return ++complaintCounter;


    }


}