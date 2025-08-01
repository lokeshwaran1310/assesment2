package com.supportjavaconsole.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.supportjavaconsole.models.SupportTicket;
import com.supportjavaconsole.util.DbUtil;

public class TicketRepository {
    DbUtil db = new DbUtil();
    SupportTicket ticket;
    public void addTicket(SupportTicket ticket) {
        try {
            Connection con = db.getConnection();
            String query = "INSERT INTO support_ticket (description, status, assigned_to, created_by) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ticket.getDescription());
            ps.setString(2, ticket.getStatus());
            ps.setString(3, ticket.getAssigned_to());
            ps.setString(4, ticket.getCreated_by());
            ps.executeUpdate();
            System.out.println("Ticket added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SupportTicket> getAllTickets() {
        List<SupportTicket> tickets = new ArrayList<>();
        try {
            Connection con = db.getConnection();
            String query = "SELECT * FROM support_ticket";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SupportTicket ticket = new SupportTicket(
                    rs.getInt("ticket_id"),
                    rs.getString("description"),
                    rs.getString("status"),
                    rs.getString("assigned_to"),
                    rs.getString("created_by")
                );
                tickets.add(ticket);
            }
            tickets.sort((b1, b2) -> Integer.compare(b1.getTicket_id(), b2.getTicket_id()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }
    public void updateTicketStatus(int ticketId, String status) {
        try {
            Connection con = db.getConnection();
            String query = "UPDATE support_ticket SET status = ? WHERE ticket_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, ticketId);
            ps.executeUpdate();
            System.out.println("Ticket status updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteTicket(int ticketId) {
        try {
            Connection con = db.getConnection();
            String query = "DELETE FROM support_ticket WHERE ticket_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, ticketId);
            ps.executeUpdate();
            System.out.println("Ticket deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SupportTicket getTicketById(int id){
        try {
            Connection con = db.getConnection();
            String query = "SELECT * FROM support_ticket WHERE ticket_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ticket = new SupportTicket(
                    rs.getInt("ticket_id"),
                    rs.getString("description"),
                    rs.getString("status"),
                    rs.getString("assigned_to"),
                    rs.getString("created_by")
                );
                
            } else {
                System.out.println("Ticket not found with ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;

    }
}