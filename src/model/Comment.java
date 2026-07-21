package model;


import java.time.LocalDateTime;


/**
 * Represents communication history
 * between user and admin.
 */
public class Comment {


    private int commentId;

    private String complaintId;

    private int userId;

    private String message;

    private LocalDateTime timestamp;



    public Comment(
            int commentId,
            String complaintId,
            int userId,
            String message
    ) {


        this.commentId = commentId;

        this.complaintId = complaintId;

        this.userId = userId;

        this.message = message;

        this.timestamp = LocalDateTime.now();


    }



    public int getCommentId() {

        return commentId;

    }



    public String getComplaintId() {

        return complaintId;

    }



    public int getUserId() {

        return userId;

    }



    public String getMessage() {

        return message;

    }



    public LocalDateTime getTimestamp() {

        return timestamp;

    }



    @Override
    public String toString() {


        return "\nComment ID : " + commentId +
                "\nComplaint  : " + complaintId +
                "\nUser ID    : " + userId +
                "\nMessage    : " + message +
                "\nTime       : " + timestamp;


    }

}