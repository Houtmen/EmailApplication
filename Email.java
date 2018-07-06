/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapp;

import java.util.Scanner;

/**
 *
 * @author marti
 */
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String company = "anycompany.com";
    
    // Contructor to recieve first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        
        // Call methode for actking for department
        this.department = setDepartment();
        
        // Call methode for returning random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("your password is: " + this.password);
        
        // Combine elements to generate email
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + company;
    }
    
    // Ask for department
    private String setDepartment()  {
        System.out.print("New Worker: " + firstName + " " + lastName + "\nDepartment codes:\n1 for Sales\n2 for Devlopment\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "Sales";
        }
        else if (depChoice == 2) {
            return "Development";
        }
        else if (depChoice == 3) {
            return "Accounting";
        }else {
            return "";
        }
    }
    
    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRESTUVWXYZ1234567890!@#$%&*";
        char[] password = new char[length];
        for(int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String (password);
    }
    
    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    
    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }
    public int getMailBoxCapacity() {
        return mailboxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;  
    }
    public String getPassword() {
        return password;
    }
    public String showInfo() {
        return "Display name: " + firstName + lastName + 
                "\nCompany email: " + email +
                "\nMailbox capacity: " + mailboxCapacity + "Mb";
                
    }
}

