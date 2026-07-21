package utility;


import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



/**
 * Handles file storage operations.
 *
 * Responsible for:
 *
 * Saving users
 * Loading users
 * Saving complaints
 * Loading complaints
 *
 */
public class FileManager {


    private static final String USER_FILE =
            "data/users.txt";


    private static final String COMPLAINT_FILE =
            "data/complaints.txt";



    /**
     * Save users into file
     */
    public static void saveUsers(
            List<User> users
    ) {


        try {


            File file =
                    new File(USER_FILE);



            file.getParentFile()
                    .mkdirs();



            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(file)
                    );



            for(User user : users) {


                writer.write(
                        user.getUserId()
                        + ","
                        + user.getName()
                        + ","
                        + user.getEmail()
                        + ","
                        + user.getPassword()
                        + ","
                        + user.getRole()
                );


                writer.newLine();


            }



            writer.close();



        }
        catch(IOException e) {


            System.out.println(
                    "Error saving users : "
                    + e.getMessage()
            );


        }


    }





    /**
     * Load users from file
     */
    public static List<User> loadUsers() {


        List<User> users =
                new ArrayList<>();



        File file =
                new File(USER_FILE);



        if(!file.exists()) {

            return users;

        }



        try {


            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );



            String line;



            while(
                    (line = reader.readLine())
                    != null
            ) {


                String[] data =
                        line.split(",");



                User user =
                        new User(
                                Integer.parseInt(data[0]),
                                data[1],
                                data[2],
                                data[3],
                                Role.valueOf(data[4])
                        );



                users.add(user);


            }



            reader.close();


        }
        catch(Exception e) {


            System.out.println(
                    "Error loading users : "
                    + e.getMessage()
            );


        }



        return users;


    }






    /**
     * Save complaints into file
     */
    public static void saveComplaints(
            List<Complaint> complaints
    ) {


        try {


            File file =
                    new File(COMPLAINT_FILE);



            file.getParentFile()
                    .mkdirs();



            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(file)
                    );



            for(Complaint complaint : complaints) {


                writer.write(

                        complaint.getComplaintId()
                        + ","
                        + complaint.getUserId()
                        + ","
                        + complaint.getTitle()
                        + ","
                        + complaint.getDescription()
                        + ","
                        + complaint.getCategory()
                        + ","
                        + complaint.getPriority()
                        + ","
                        + complaint.getStatus()

                );



                writer.newLine();


            }



            writer.close();



        }
        catch(IOException e) {


            System.out.println(
                    "Error saving complaints : "
                    + e.getMessage()
            );


        }


    }






    /**
     * Load complaints from file
     */
    public static List<Complaint> loadComplaints() {


        List<Complaint> complaints =
                new ArrayList<>();



        File file =
                new File(COMPLAINT_FILE);



        if(!file.exists()) {


            return complaints;


        }



        try {


            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );



            String line;



            while(
                    (line = reader.readLine())
                    != null
            ) {


                String[] data =
                        line.split(",");



                Complaint complaint =
                        new Complaint(

                                data[0],
                                Integer.parseInt(data[1]),
                                data[2],
                                data[3],
                                ComplaintCategory.valueOf(data[4]),
                                ComplaintPriority.valueOf(data[5])

                        );



                complaint.setStatus(
                        ComplaintStatus.valueOf(data[6])
                );



                complaints.add(complaint);



            }



            reader.close();


        }
        catch(Exception e) {


            System.out.println(
                    "Error loading complaints : "
                    + e.getMessage()
            );


        }



        return complaints;


    }


}