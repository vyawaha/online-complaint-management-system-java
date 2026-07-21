package main;


import model.*;

import repository.UserRepository;
import repository.ComplaintRepository;

import service.UserService;
import service.ComplaintService;


import java.util.Scanner;



public class Main {


    private static final Scanner scanner =
            new Scanner(System.in);



    private static final UserRepository userRepository =
            new UserRepository();



    private static final ComplaintRepository complaintRepository =
            new ComplaintRepository();



    private static final UserService userService =
            new UserService(userRepository);



    private static final ComplaintService complaintService =
            new ComplaintService(complaintRepository);



    private static User currentUser;



    public static void main(String[] args) {


        createDefaultAdmin();
        createAdmin();

        while(true) {


            System.out.println(
                    "\n=============================="
            );

            System.out.println(
                    " Online Complaint Management "
            );

            System.out.println(
                    "=============================="
            );


            System.out.println(
                    "1. Register"
            );


            System.out.println(
                    "2. Login"
            );


            System.out.println(
                    "3. Exit"
            );


            System.out.print(
                    "Enter choice: "
            );


            int choice = readInteger();



            switch(choice) {


                case 1:

                    register();

                    break;



                case 2:

                    login();

                    break;



                case 3:

                    System.out.println(
                            "Application Closed"
                    );

                    System.exit(0);

                    break;



                default:

                    System.out.println(
                            "Invalid choice"
                    );

            }


        }


    }





    private static void createDefaultAdmin() {


        try {


            User admin =
                    new User(
                            1,
                            "Admin",
                            "admin@gmail.com",
                            "admin123",
                            Role.ADMIN
                    );


            userRepository.save(admin);



        }
        catch(Exception ignored) {


        }


    }








    private static void register() {


        System.out.println(
                "\n===== Registration ====="
        );


        System.out.print(
                "Name: "
        );


        String name =
                scanner.nextLine();



        System.out.print(
                "Email: "
        );


        String email =
                scanner.nextLine();



        System.out.print(
                "Password: "
        );


        String password =
                scanner.nextLine();




        try {


            User user =
                    userService.registerUser(
                            name,
                            email,
                            password
                    );



            System.out.println(
                    "Registration successful"
            );


            System.out.println(
                    "User ID : "
                    +
                    user.getUserId()
            );



        }
        catch(Exception e) {


            System.out.println(
                    e.getMessage()
            );


        }


    }










    private static void login() {


        System.out.println(
                "\n===== Login ====="
        );


        System.out.print(
                "Email: "
        );


        String email =
                scanner.nextLine();



        System.out.print(
                "Password: "
        );


        String password =
                scanner.nextLine();




        try {


            currentUser =
                    userService.login(
                            email,
                            password
                    );



            System.out.println(
                    "\nLogin successful"
            );


            System.out.println(
                    "Role : "
                    +
                    currentUser.getRole()
            );



            if(currentUser.getRole()
                    == Role.USER) {


                userMenu();


            }
            else {


                adminMenu();


            }




        }
        catch(Exception e) {


            System.out.println(
                    e.getMessage()
            );


        }


    }









    private static void userMenu() {


        while(true) {


            System.out.println(
                    "\n===== USER MENU ====="
            );


            System.out.println(
                    "1. Create Complaint"
            );


            System.out.println(
                    "2. View My Complaints"
            );


            System.out.println(
                    "3. Search Complaint"
            );


            System.out.println(
                    "4. Logout"
            );



            System.out.print(
                    "Choice: "
            );



            int choice =
                    readInteger();




            switch(choice) {


                case 1:

                    createComplaint();

                    break;



                case 2:


                    complaintService
                            .getUserComplaints(
                                    currentUser.getUserId()
                            )
                            .forEach(
                                    System.out::println
                            );


                    break;




                case 3:

                    searchComplaint();

                    break;



                case 4:

                    currentUser = null;

                    return;



                default:

                    System.out.println(
                            "Invalid choice"
                    );


            }


        }


    }









    private static void adminMenu() {


        while(true) {


            System.out.println(
                    "\n===== ADMIN MENU ====="
            );


            System.out.println(
                    "1. View All Complaints"
            );


            System.out.println(
                    "2. Search Complaint"
            );


            System.out.println(
                    "3. Assign Complaint"
            );


            System.out.println(
                    "4. Update Status"
            );


            System.out.println(
                    "5. Add Resolution"
            );


            System.out.println(
                    "6. Close Complaint"
            );


            System.out.println(
                    "7. Logout"
            );



            System.out.print(
                    "Choice: "
            );


            int choice =
                    readInteger();



            switch(choice) {


                case 1:


                    complaintService
                            .getAllComplaints()
                            .forEach(
                                    System.out::println
                            );


                    break;



                case 2:

                    searchComplaint();

                    break;



                case 3:

                    assignComplaint();

                    break;



                case 4:

                    updateStatus();

                    break;



                case 5:

                    addResolution();

                    break;



                case 6:

                    closeComplaint();

                    break;



                case 7:

                    currentUser = null;

                    return;



                default:

                    System.out.println(
                            "Invalid choice"
                    );


            }


        }


    }









    private static void createComplaint() {


        System.out.println(
                "\n===== New Complaint ====="
        );


        System.out.print(
                "Title: "
        );


        String title =
                scanner.nextLine();



        System.out.print(
                "Description: "
        );


        String description =
                scanner.nextLine();




        ComplaintCategory category =
                readCategory();



        ComplaintPriority priority =
                readPriority();




        try {


            Complaint complaint =
                    complaintService.createComplaint(
                            currentUser.getUserId(),
                            title,
                            description,
                            category,
                            priority
                    );



            System.out.println(
                    "\nComplaint Created"
            );


            System.out.println(
                    complaint
            );



        }
        catch(Exception e) {


            System.out.println(
                    e.getMessage()
            );


        }


    }









    private static void assignComplaint() {


        System.out.print(
                "Complaint ID: "
        );


        String id =
                scanner.nextLine();



        System.out.print(
                "Assign To: "
        );


        String person =
                scanner.nextLine();



        try {


            complaintService.assignComplaint(
                    id,
                    person
            );


            System.out.println(
                    "Complaint Assigned"
            );


        }
        catch(Exception e) {


            System.out.println(
                    e.getMessage()
            );


        }


    }









    private static void updateStatus() {


        System.out.print(
                "Complaint ID: "
        );


        String id =
                scanner.nextLine();



        System.out.println(
                "Enter Status:"
        );


        for(ComplaintStatus s:
                ComplaintStatus.values()) {


            System.out.println(s);


        }



        try {


            ComplaintStatus status =
                    ComplaintStatus.valueOf(
                            scanner.nextLine()
                                    .toUpperCase()
                    );



            complaintService.updateStatus(
                    id,
                    status
            );


            System.out.println(
                    "Status Updated"
            );



        }
        catch(Exception e) {


            System.out.println(
                    e.getMessage()
            );


        }


    }









    private static void addResolution() {


        System.out.print(
                "Complaint ID: "
        );


        String id =
                scanner.nextLine();



        System.out.print(
                "Resolution: "
        );


        String resolution =
                scanner.nextLine();



        complaintService.addResolution(
                id,
                resolution
        );


        System.out.println(
                "Resolution Added"
        );


    }









    private static void closeComplaint() {


        System.out.print(
                "Complaint ID: "
        );


        String id =
                scanner.nextLine();



        complaintService.closeComplaint(
                id
        );


        System.out.println(
                "Complaint Closed"
        );


    }









    private static void searchComplaint() {


        System.out.print(
                "Complaint ID: "
        );


        String id =
                scanner.nextLine();



        try {


            System.out.println(
                    complaintService.getComplaint(id)
            );


        }
        catch(Exception e) {


            System.out.println(
                    e.getMessage()
            );


        }


    }









    private static ComplaintCategory readCategory() {


        while(true) {


            try {


                return ComplaintCategory.valueOf(
                        scanner.nextLine()
                                .trim()
                                .toUpperCase()
                );


            }
            catch(Exception e) {


                System.out.println(
                        "Invalid category"
                );


            }


        }


    }









    private static ComplaintPriority readPriority() {


        while(true) {


            try {


                return ComplaintPriority.valueOf(
                        scanner.nextLine()
                                .trim()
                                .toUpperCase()
                );


            }
            catch(Exception e) {


                System.out.println(
                        "Invalid priority"
                );


            }


        }


    }









    private static int readInteger() {


        while(true) {


            try {


                return Integer.parseInt(
                        scanner.nextLine()
                );


            }
            catch(Exception e) {


                System.out.print(
                        "Enter valid number: "
                );


            }


        }


    }

private static void createAdmin() {

    User admin = new User(
            9999,
            "Admin",
            "admin@gmail.com",
            "admin123",
            Role.ADMIN
    );

    userRepository.save(admin);

    System.out.println("Admin created");

}

}