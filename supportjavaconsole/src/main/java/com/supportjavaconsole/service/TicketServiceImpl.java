package com.supportjavaconsole.service;

import java.util.Arrays;
import java.util.List;

import com.supportjavaconsole.exceptions.InvalidStatusException;
import com.supportjavaconsole.exceptions.TicketNotFound;
import com.supportjavaconsole.models.SupportTicket;
import com.supportjavaconsole.repository.TicketRepository;

public class TicketServiceImpl {
    private TicketRepository ticketRepository;
    public TicketServiceImpl() {
        this.ticketRepository = new TicketRepository();
    }
    public void addTicket(SupportTicket ticket) throws  Exception, InvalidStatusException   {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null");
        }

        if (ticket.getDescription() == null || ticket.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Ticket description cannot be empty");
        }
        if (ticket.getStatus() == null || ticket.getStatus().isEmpty()|| !Arrays.asList("Open", "In Progress", "Closed").contains(ticket.getStatus())) {
            throw new IllegalArgumentException("Ticket status cannot be empty");
        }
        if (ticket.getAssigned_to() == null || ticket.getAssigned_to().isEmpty()) {
            throw new IllegalArgumentException("Ticket assigned_to cannot be empty");
        }
        if (ticket.getCreated_by() == null || ticket.getCreated_by().isEmpty()) {
            throw new IllegalArgumentException("Ticket created_by cannot be empty");
        }

        ticketRepository.addTicket(ticket);
    }

    public void updateTicketStatus(int ticketId, String status) throws TicketNotFound, InvalidStatusException {
    if (ticketId <= 0) {
        throw new IllegalArgumentException("Invalid ticket ID");
    }

    List<String> validStatuses = Arrays.asList("Open", "In Progress", "Closed");
    if (status == null || status.isEmpty() || !validStatuses.contains(status)) {
        throw new InvalidStatusException("Status must be one of: Open, In Progress, Closed");
    }

    SupportTicket ticket = ticketRepository.getTicketById(ticketId);
    if (ticket == null) {
        throw new TicketNotFound("Ticket not found with ID: " + ticketId);
    }

    ticketRepository.updateTicketStatus(ticketId, status);
}
    
    
    
    public void deleteTicket(int ticketId) throws Exception {
        if (ticketId <= 0) {
            throw new IllegalArgumentException("Invalid ticket ID");
        }
        
        SupportTicket ticket = ticketRepository.getTicketById(ticketId);
        if (ticket == null) {
            throw new TicketNotFound("Ticket not found with ID: " + ticketId);
        }
        
        ticketRepository.deleteTicket(ticketId);
    }

    public List<SupportTicket> viewTicketDetails() throws Exception {
        List<SupportTicket> tickets = ticketRepository.getAllTickets();
        if (tickets.isEmpty()) {
            throw new TicketNotFound("No tickets found");
        }
        return tickets;
    }

    public SupportTicket getTicketById(int ticketId) throws TicketNotFound {
         SupportTicket st= ticketRepository.getTicketById(ticketId);
        if (st == null) {
            throw new TicketNotFound("Ticket not found with ID: " + ticketId);
        }
        SupportTicket ticket = ticketRepository.getTicketById(ticketId);
    
   return st;
    }
}