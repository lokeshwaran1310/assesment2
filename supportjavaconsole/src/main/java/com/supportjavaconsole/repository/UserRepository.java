package com.supportjavaconsole.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.supportjavaconsole.models.User;
import com.supportjavaconsole.util.DbUtil;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    DbUtil dbUtil = new DbUtil();
    public void addUser(User user) {
        try{
            Connection connection = dbUtil.getConnection();
            String query = "INSERT INTO users (uid, name, email) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getUid());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.executeUpdate();
            System.out.println("User added successfully.");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
    }   
    public User getUserById(int userId) {
        try {
            Connection connection = dbUtil.getConnection();
            String query = "SELECT * FROM users WHERE uid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                    resultSet.getInt("uid"),
                    resultSet.getString("name"),
                    resultSet.getString("email")
                );
            } else {
                System.out.println("User not found.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
   public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = dbUtil.getConnection();
            String query = "SELECT * FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                    resultSet.getInt("uid"),
                    resultSet.getString("name"),
                    resultSet.getString("email")
                );
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;

    }
public void assignAgentToTicket(String agentName, int ticketId) {
    try {
        Connection connection = dbUtil.getConnection();
        String query = "UPDATE support_ticket SET assigned_to = ? WHERE ticket_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, agentName);
        preparedStatement.setInt(2, ticketId);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Agent assigned to ticket successfully.");
        } else {
            System.out.println("Ticket ID not found.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
