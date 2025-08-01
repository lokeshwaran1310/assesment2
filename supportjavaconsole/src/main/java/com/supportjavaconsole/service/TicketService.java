package com.supportjavaconsole.service;

import com.supportjavaconsole.exceptions.InvalidStatusException;
import com.supportjavaconsole.exceptions.TicketNotFound;
import com.supportjavaconsole.models.SupportTicket;

public interface TicketService {
    void createTicket(SupportTicket ticket) throws Exception,InvalidStatusException;
    void updateTicketStatus(int ticketId, String status) throws TicketNotFound,InvalidStatusException;
    void deleteTicket(int ticketId) throws Exception, TicketNotFound;
    void viewTicketDetails() throws Exception, TicketNotFound;
    SupportTicket getTicketById(int ticketId) throws TicketNotFound;
    
}
