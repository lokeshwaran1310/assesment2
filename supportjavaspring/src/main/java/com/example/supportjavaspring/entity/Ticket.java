package com.example.supportjavaspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "support_ticket")
public class Ticket {

    @Id
    private int ticket_id;
    private String description;
    private String status;
    private String created_by;
    private String assigned_to;

    public int getTicket_id() { 
        return ticket_id; 
    }
    public void setTicket_id(int ticket_id) {
         this.ticket_id = ticket_id; 
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

    public String getCreated_by() {
         return created_by; 
        }
    public void setCreated_by(String created_by) {
         this.created_by = created_by; 
        }

    public String getAssigned_to() { 
        return assigned_to; 
    }
    public void setAssigned_to(String assigned_to) {
         this.assigned_to = assigned_to;
         }
}
