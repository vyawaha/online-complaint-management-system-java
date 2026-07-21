import model.*;


public class TestModel {

    public static void main(String[] args) {


        User user =
                new User(
                        101,
                        "Rahul",
                        "rahul@gmail.com",
                        "12345",
                        Role.USER
                );


        Complaint complaint =
                new Complaint(
                        "CMP1001",
                        101,
                        "Projector Not Working",
                        "Projector is not turning on",
                        ComplaintCategory.TECHNICAL,
                        ComplaintPriority.HIGH
                );


        System.out.println(user);

        System.out.println(complaint);


    }

}