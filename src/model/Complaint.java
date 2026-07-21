package model;


import java.time.LocalDateTime;


/**
 * Represents a complaint submitted by a user.
 *
 * Complaint lifecycle:
 *
 * OPEN
 * ASSIGNED
 * IN_PROGRESS
 * RESOLVED
 * CLOSED
 */
public class Complaint {


    private String complaintId;

    private int userId;

    private String title;

    private String description;

    private ComplaintCategory category;

    private ComplaintPriority priority;

    private ComplaintStatus status;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String assignedTo;

    private String resolution;



    public Complaint(
            String complaintId,
            int userId,
            String title,
            String description,
            ComplaintCategory category,
            ComplaintPriority priority
    ) {


        this.complaintId = complaintId;

        this.userId = userId;

        this.title = title;

        this.description = description;

        this.category = category;

        this.priority = priority;

        this.status = ComplaintStatus.OPEN;

        this.createdDate = LocalDateTime.now();

        this.updatedDate = LocalDateTime.now();

        this.assignedTo = "Not Assigned";

        this.resolution = "Pending";


    }



    public String getComplaintId() {

        return complaintId;

    }



    public int getUserId() {

        return userId;

    }



    public String getTitle() {

        return title;

    }



    public String getDescription() {

        return description;

    }



    public ComplaintCategory getCategory() {

        return category;

    }



    public ComplaintPriority getPriority() {

        return priority;

    }



    public ComplaintStatus getStatus() {

        return status;

    }



    public LocalDateTime getCreatedDate() {

        return createdDate;

    }



    public LocalDateTime getUpdatedDate() {

        return updatedDate;

    }



    public String getAssignedTo() {

        return assignedTo;

    }



    public String getResolution() {

        return resolution;

    }



    public void setStatus(
            ComplaintStatus status
    ) {

        this.status = status;

        this.updatedDate = LocalDateTime.now();

    }



    public void setAssignedTo(
            String assignedTo
    ) {

        this.assignedTo = assignedTo;

        this.updatedDate = LocalDateTime.now();

    }



    public void setResolution(
            String resolution
    ) {

        this.resolution = resolution;

        this.updatedDate = LocalDateTime.now();

    }



    @Override
    public String toString() {


        return "\nComplaint ID : " + complaintId +
                "\nUser ID      : " + userId +
                "\nTitle        : " + title +
                "\nDescription  : " + description +
                "\nCategory     : " + category +
                "\nPriority     : " + priority +
                "\nStatus       : " + status +
                "\nAssigned To  : " + assignedTo +
                "\nResolution   : " + resolution +
                "\nCreated Date : " + createdDate +
                "\nUpdated Date : " + updatedDate;


    }

}