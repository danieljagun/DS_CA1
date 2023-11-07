package com.example.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.example.bank.model.Deposit;
import com.example.bank.model.Loan;
import com.example.bank.model.User;

@Path("/bankservice")
public class BankService {

    private static Map<String, User> users = new HashMap<>();

    static {
        User user1 = new User();
        user1.setUserId("1");
        user1.setName("Daniel");
        user1.setPhoneNumber("0870955222");
        user1.setAddress("50 The Road, Dublin");
        user1.setAnnualSalary(30000);
        users.put(user1.getUserId(), user1);

        User user2 = new User("2","John", "0892334814", "20 The Street, Dublin", 40000);
        users.put(String.valueOf(user2.getUserId()), user2);

    }

    @GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello() {
        return "Hello, welcome to the Bank Service.";
    }


    /* @GET
    @Path("/users/")
    @Produces({"application/json"})
    public List<User> listUsersJSON() {
        return new ArrayList<>(users.values());
    }
    */

    @POST
    @Path("/createUser")
    @Consumes({"application/json"})
    public String addUserToDB(User user) {
        UserDAO dao = new UserDAO();
        dao.persistUser(user);
        return "New User has been added to database " + user.getName();
    }

    @DELETE
    @Path("/removeUser/{userId}")
    @Consumes({"application/json"})
    public String removeUserFromDB(@PathParam("userId") String userId) {
        UserDAO dao = new UserDAO();
        User u = dao.getUserByUserId(userId);
        dao.removeUser(u);
        return "User " + u + " has been removed";
    }

    @PUT
    @Path("/updateUser")
    @Consumes({"application/json"})
    public String updateUser(User user) {
        UserDAO dao = new UserDAO();
        User updatedUser = dao.mergeUser(user);
        if (updatedUser != null) {
            return "User has been updated";
        } else {
            return "User could not be updated";
        }
    }

    @GET
    @Path("/users")
    @Produces("application/json")
    public List<User> getAllUsersFromDB() {
        UserDAO dao = new UserDAO();
        return dao.getAllUsers();
    }

    @POST
    @Path("/newLoan")
    @Consumes({"application/json"})
    public String addLoanToDB(Loan loan) {
        LoanDAO dao = new LoanDAO();
        dao.persistLoan(loan);
        return "New loan has been added to the database" + loan.getLoanId();
    }

    @DELETE
    @Path("/removeLoan/{loanId}")
    @Consumes({"application/json"})
    public String removeLoanFromDB(@PathParam("loanId") String loanId) {
        LoanDAO dao = new LoanDAO();
        Loan l = dao.getLoanByLoanId(loanId);
        dao.removeLoan(l);
        return "Loan" + l + " has been removed";
    }


    @GET
    @Path("/getAllLoans")
    @Produces("application/json")
    public List<Loan> getAllLoans() {
        LoanDAO dao = new LoanDAO();
        return dao.getAllLoans();
    }

    @POST
    @Path("/newDeposit")
    @Consumes({"application/json"})
    public String depositToDB(Deposit deposit) {
        DepositDAO dao = new DepositDAO();
        dao.persistDeposit(deposit);
        return "New Deposit made on " + deposit.getDepositDate();
    }

    @DELETE
    @Path("/removeDeposit{depId}")
    @Consumes({"application/json"})
    public String removeDepFromDB(@PathParam("depId") String depId) {
        DepositDAO dao = new DepositDAO();
        Deposit d = dao.getDepositByDepId(depId);
        dao.removeDeposit(d);
        return "Deposit" + d + " has been removed";
    }

    @GET
    @Path("/getAllDeposits")
    @Produces("application/json")
    public List<Deposit> getAllDeposits() {
        DepositDAO dao = new DepositDAO();
        return dao.getAllDeposits();
    }

}