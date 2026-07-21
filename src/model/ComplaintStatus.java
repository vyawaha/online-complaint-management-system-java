package model;

/**
 * Represents the complete lifecycle of a complaint.
 *
 * Workflow:
 *
 * OPEN
 *   |
 * ASSIGNED
 *   |
 * IN_PROGRESS
 *   |
 * RESOLVED
 *   |
 * CLOSED
 *
 * REJECTED is an alternate ending state.
 */
public enum ComplaintStatus {

    OPEN,

    ASSIGNED,

    IN_PROGRESS,

    RESOLVED,

    CLOSED,

    REJECTED

}