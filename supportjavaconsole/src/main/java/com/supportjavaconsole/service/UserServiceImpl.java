package com.supportjavaconsole.service;
import java.util.List;

import com.supportjavaconsole.models.SupportAgent;
import com.supportjavaconsole.models.User;
import com.supportjavaconsole.repository.UserRepository;
public class UserServiceImpl {
    private UserRepository userRepository;
    public UserServiceImpl() {
        this.userRepository = new UserRepository();
    }
SupportAgent agent1 = new SupportAgent(1, "Ravi", "ravi@support.com", "Networking");
SupportAgent agent2 = new SupportAgent(2, "Priya", "priya@support.com", "Software");
     public void addUser(User user) {
        if (user == null || user.getName() == null || user.getEmail() == null) {
            throw new IllegalArgumentException("User details cannot be null");
        }
        userRepository.addUser(user);

     }
        public User getUserById(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("User ID must be greater than zero");
        }
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
        return user;
    }
    
    public List<User> getAllUsers() {
        List<User> users = userRepository.getAllUsers();
        if (users.isEmpty()) {
            throw new IllegalArgumentException("No users found");
        }
        return users;

    }
    public void assignAgentToTicket(String agentName, int ticketId) {
        userRepository.assignAgentToTicket(agentName, ticketId);
    }
}
