package main;

import com.bank.model.User;
import dao.UserDAO;

import java.util.List;

public class Test {

    public Test(){
        UserDAO uDAO = new UserDAO();

        // Add User
        User user = new User("Daniel", "0870955222", "50 The Road, Dublin", 30.000);
        uDAO.persistUser(user);


        // Remove User
        // uDAO.removeUser(user);

        // Get all Users
        List<User> users = uDAO.getAllUsers();
        for (User u : users) {
            System.out.println("User Name: " + u.getName());
            System.out.println("User Phone: " + u.getPhoneNumber());
            System.out.println("User Address: " + u.getAddress());
            System.out.println("User Salary: " + u.getAnnualSalary());
        }
    }

    public static void main(String[] args) {
        new Test();
    }

}

