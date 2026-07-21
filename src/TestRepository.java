import model.*;
import repository.*;


public class TestRepository {


    public static void main(String[] args) {


        UserRepository userRepository =
                new UserRepository();



        User user =
                new User(
                        101,
                        "Rahul",
                        "rahul@gmail.com",
                        "12345",
                        Role.USER
                );


        userRepository.save(user);



        System.out.println(
                userRepository.findByEmail(
                        "rahul@gmail.com"
                )
        );



        ComplaintRepository complaintRepository =
                new ComplaintRepository();



        Complaint complaint =
                new Complaint(
                        "CMP1001",
                        101,
                        "Internet Issue",
                        "College WiFi not working",
                        ComplaintCategory.TECHNICAL,
                        ComplaintPriority.HIGH
                );



        complaintRepository.save(complaint);



        System.out.println(
                complaintRepository.findById(
                        "CMP1001"
                )
        );


    }

}