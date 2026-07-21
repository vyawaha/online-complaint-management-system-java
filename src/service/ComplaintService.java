package service;


import model.*;
import repository.ComplaintRepository;
import utility.IdGenerator;
import utility.ValidationUtil;


import java.util.List;



/**
 * Handles complaint related business logic.
 */
public class ComplaintService {


    private final ComplaintRepository complaintRepository;



    public ComplaintService(
            ComplaintRepository complaintRepository
    ) {

        this.complaintRepository =
                complaintRepository;

    }



    /**
     * Create new complaint
     */
    public Complaint createComplaint(

            int userId,
            String title,
            String description,
            ComplaintCategory category,
            ComplaintPriority priority

    ) {


        if(!ValidationUtil.isValidComplaintTitle(title)) {


            throw new RuntimeException(
                    "Invalid complaint title"
            );

        }



        if(!ValidationUtil.isValidDescription(description)) {


            throw new RuntimeException(
                    "Description must contain minimum 10 characters"
            );

        }



        Complaint complaint =
                new Complaint(

                        IdGenerator.generateComplaintId(),
                        userId,
                        title,
                        description,
                        category,
                        priority

                );



        complaintRepository.save(
                complaint
        );



        return complaint;

    }




    /**
     * Get complaint by ID
     */
    public Complaint getComplaint(
            String complaintId
    ) {


        Complaint complaint =
                complaintRepository.findById(
                        complaintId
                );



        if(complaint == null) {


            throw new RuntimeException(
                    "Complaint not found"
            );


        }


        return complaint;


    }





    /**
     * Get complaints created by user
     */
    public List<Complaint> getUserComplaints(
            int userId
    ) {


        return complaintRepository.findByUserId(
                userId
        );


    }





    /**
     * Get all complaints
     */
    public List<Complaint> getAllComplaints() {


        return complaintRepository.findAll();


    }





    /**
     * Update complaint status
     */
    public void updateStatus(

            String complaintId,
            ComplaintStatus status

    ) {


        Complaint complaint =
                getComplaint(
                        complaintId
                );



        complaint.setStatus(
                status
        );


    }





    /**
     * Assign complaint to person/team
     */
    public void assignComplaint(

            String complaintId,
            String assignedPerson

    ) {


        Complaint complaint =
                getComplaint(
                        complaintId
                );



        /*
         * Complaint.java uses setAssignedTo()
         * not setAssignedPerson()
         */
        complaint.setAssignedTo(
                assignedPerson
        );



        complaint.setStatus(
                ComplaintStatus.ASSIGNED
        );


    }





    /**
     * Add resolution details
     */
    public void addResolution(

            String complaintId,
            String resolution

    ) {


        Complaint complaint =
                getComplaint(
                        complaintId
                );



        complaint.setResolution(
                resolution
        );



        complaint.setStatus(
                ComplaintStatus.RESOLVED
        );


    }





    /**
     * Close complaint
     */
    public void closeComplaint(
            String complaintId
    ) {


        Complaint complaint =
                getComplaint(
                        complaintId
                );



        complaint.setStatus(
                ComplaintStatus.CLOSED
        );


    }


}