package com.supportjavaconsole.models;

public class SupportTicket {
    private int ticket_id;
    private String description;
    private String status;
    private String assigned_to;
    private String created_by;
    public SupportTicket(int ticket_id, String description, String status, String assigned_to, String created_by) {
        this.ticket_id = ticket_id;
        this.description = description;
        this.status = status;
        this.assigned_to = assigned_to;
        this.created_by = created_by;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getAssigned_to() {
        return assigned_to;
    }
    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }
    public String getCreated_by() {
        return created_by;
    }
    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
    public int getTicket_id() {
        return ticket_id;
    }
    public void setTicketid(int ticket_id) {
        this.ticket_id = ticket_id;
    }
    
    
}
