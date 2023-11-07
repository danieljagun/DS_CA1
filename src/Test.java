package main;

import com.bank.model.Deposit;
import com.bank.model.Loan;
import com.bank.model.User;
import dao.DepositDAO;
import dao.LoanDAO;
import dao.UserDAO;

import java.util.List;

public class Test {

    public Test(){
        UserDAO uDAO = new UserDAO();
        LoanDAO lDAO = new LoanDAO();
        DepositDAO dDao = new DepositDAO();

        // Add User
        User user = new User("Daniel", "0870955222", "50 The Road, Dublin", 30000);
        uDAO.persistUser(user);

        // Adding another User
        User user2 = new User("John", "0892334814", "20 The Street, Dublin", 40000);
        uDAO.persistUser(user2);

        // Remove User
        //uDAO.removeUser(user);

        // Get all Users
        List<User> users = uDAO.getAllUsers();
        for (User u : users) {
            System.out.println("User Name: " + u.getName());
            System.out.println("User Phone: " + u.getPhoneNumber());
            System.out.println("User Address: " + u.getAddress());
            System.out.println("User Salary: " + u.getAnnualSalary());
        }

        // Add Loan
        Loan loan = new Loan("Loan for Car", 5000, user);
        lDAO.persistLoan(loan);

        // Remove Loan
        //lDAO.removeLoan(loan);

        // Get all Loans
        List<Loan> loans = lDAO.getAllLoans();
        for (Loan l : loans) {
            System.out.println("Loan Description: " + l.getDescription());
            System.out.println("Loan Amount: " + l.getLoanAmount());
            System.out.println("Associated User ID: " + l.getUser().getId());
        }

        // Add Deposit
        Deposit deposit = new Deposit("30th April 2022", 1000, user);
        dDao.persistDeposit(deposit);

        // Remove Deposit
        //dDao.removeDeposit(deposit);

        // Get all Deposits
        List<Deposit> deposits = dDao.getAllDeposits();
        for (Deposit d : deposits) {
            System.out.println("Deposit Date: " + d.getDepositDate());
            System.out.println("Deposit Amount: " + d.getDepositAmount());
            System.out.println("Associated User ID: " + d.getUser().getId());
        }

    }

    public static void main(String[] args) {
        new Test();
    }

}

