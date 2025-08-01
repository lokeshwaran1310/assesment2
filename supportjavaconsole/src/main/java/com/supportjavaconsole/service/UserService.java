package com.supportjavaconsole.service;

import java.util.List;

import com.supportjavaconsole.models.User;

public interface UserService {

public void addUser(User user);
public User getUserById(int userId);
public List<User> getAllUsers();
public void assignAgentToTicket(String agentName, int ticketId);

}
