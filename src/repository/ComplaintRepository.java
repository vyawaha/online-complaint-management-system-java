package repository;


import model.Complaint;

import java.util.ArrayList;
import java.util.List;



/**
 * Repository class responsible for
 * complaint data management.
 */
public class ComplaintRepository {


    private final List<Complaint> complaints;



    public ComplaintRepository() {

        complaints = new ArrayList<>();

    }



    /**
     * Save complaint
     */
    public void save(
            Complaint complaint
    ) {


        complaints.add(complaint);


    }



    /**
     * Find complaint using ID
     */
    public Complaint findById(
            String complaintId
    ) {


        for(Complaint complaint : complaints) {


            if(complaint.getComplaintId()
                    .equalsIgnoreCase(complaintId)) {


                return complaint;

            }

        }


        return null;

    }




    /**
     * Find complaints created by user
     */
    public List<Complaint> findByUserId(
            int userId
    ) {


        List<Complaint> result =
                new ArrayList<>();


        for(Complaint complaint : complaints) {


            if(complaint.getUserId()
                    == userId) {


                result.add(complaint);

            }

        }


        return result;

    }




    /**
     * Return all complaints
     */
    public List<Complaint> findAll() {


        return complaints;


    }



    /**
     * Delete complaint
     */
    public boolean delete(
            String complaintId
    ) {


        Complaint complaint =
                findById(complaintId);


        if(complaint != null) {


            complaints.remove(complaint);

            return true;

        }


        return false;

    }


}