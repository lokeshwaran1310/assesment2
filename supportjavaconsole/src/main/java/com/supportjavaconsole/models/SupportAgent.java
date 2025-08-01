
package com.supportjavaconsole.models;
public class SupportAgent {
    private int agentId;
    private String name;
    private String email;
    private String expertise; 

    public SupportAgent(int agentId, String name, String email, String expertise) {
        this.agentId = agentId;
        this.name = name;
        this.email = email;
        this.expertise = expertise;
    }

    public int getAgentId() { 

        return agentId; 
        }
    public String getName() {
         return name;
         }
    public String getEmail() {
         return email; 
        }
    public String getExpertise() {
         return expertise; 
        }
}
