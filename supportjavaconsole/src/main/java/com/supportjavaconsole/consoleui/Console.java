package com.supportjavaconsole.consoleui;

import java.util.List;
import java.util.Scanner;

import com.supportjavaconsole.exceptions.InvalidStatusException;
import com.supportjavaconsole.exceptions.TicketNotFound;
import com.supportjavaconsole.models.SupportTicket;
import com.supportjavaconsole.models.User;
import com.supportjavaconsole.service.TicketServiceImpl;
import com.supportjavaconsole.service.UserServiceImpl;

public class Console {
    Scanner scanner = new Scanner(System.in);
    private TicketServiceImpl ticketService;
    private UserServiceImpl userService;
    public Console() {
        this.ticketService = new TicketServiceImpl();
        this.userService = new UserServiceImpl();
    }
    public void start() throws Exception, TicketNotFound, InvalidStatusException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Support Java Console Application!");
        while(true){
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch(choice) {
                case 1:
                    System.out.println("Adding a new user...");
                    System.out.println("Enter id");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter user name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter user email:");
                    String email = scanner.nextLine();
                    User user = new User(id, name, email);
                    userService.addUser(user);
                    break;
                case 2:
                    System.out.println("Enter user ID to view:");
                    int userId = scanner.nextInt();
                    try {
                        User u=userService.getUserById(userId);
                        System.out.println(u.getUid() + ": " + u.getName() + " | " + u.getEmail());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        List<User> users = userService.getAllUsers();
                        for (User u : users) {
                            System.out.println(u.getUid() + ": " + u.getName() + " | " + u.getEmail());
                        }
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Enter agent name:");
                    String agentName = scanner.nextLine();
                    System.out.println("Enter ticket ID to assign:");
                    int ticketId = scanner.nextInt();
                    try {
                        userService.assignAgentToTicket(agentName, ticketId);
                        System.out.println("Agent assigned successfully.");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter ticket description:");
                    String description = scanner.nextLine();
                    System.out.println("Enter ticket status:");
                    String status = scanner.nextLine();
                    System.out.println("Enter assigned to:");
                    String assignedTo = scanner.nextLine();
                    System.out.println("Enter created by:");
                    String createdBy = scanner.nextLine();

                    SupportTicket ticket = new SupportTicket(0, description, status, assignedTo, createdBy);
                    ticketService.addTicket(ticket);
                    break;
                case 6:
                    System.out.println("Enter ticket ID to update:");
                    int ticketid = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("Enter new status:");
                    String newStatus = scanner.nextLine();
                    
                    try {
                        ticketService.updateTicketStatus(ticketid, newStatus);
                        System.out.println("Ticket status updated successfully.");
                    } catch (TicketNotFound | InvalidStatusException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Enter ticket ID to delete:");
                    int deleteId = scanner.nextInt();
                    
                    try {
                        ticketService.deleteTicket(deleteId);
                        System.out.println("Ticket deleted successfully.");
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        List<SupportTicket> tickets = ticketService.viewTicketDetails();
                        for (SupportTicket t : tickets) {
                            System.out.println(t.getTicket_id() + ": " + t.getDescription() + " | Status: " + t.getStatus() + " | Assigned To: " + t.getAssigned_to() + " | Created By: " + t.getCreated_by());
                        }
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Enter ticket ID to view:");
                    int viewId = scanner.nextInt();
                    SupportTicket ticketDetails = ticketService.getTicketById(viewId);
                    System.out.println(ticketDetails.getTicket_id() + ": " + ticketDetails.getDescription() + " | Status: " + ticketDetails.getStatus() + " | Assigned To: " + ticketDetails.getAssigned_to() + " | Created By: " + ticketDetails.getCreated_by());
                    break;
                case 10:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add User");
        System.out.println("2. View User By ID");
        System.out.println("3. View All Users");
        System.out.println("4. Assign Agent to Ticket");
        System.out.println("5. Create Ticket");
        System.out.println("6. Update Ticket Status");
        System.out.println("7. Delete Ticket");
        System.out.println("8. View Ticket Details");
        System.out.println("9.View Ticket By ID");
        System.out.println("10. Exit");
        System.out.print("Please select an option: ");

    }
}
