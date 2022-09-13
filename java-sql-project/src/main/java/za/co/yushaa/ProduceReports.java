package za.co.yushaa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ProduceReports {

    public static void makeDatabaseQuery(String customerId) throws Exception {


    }


    public static void main(String[] args) {

        System.out.println("Customer Id : ");
        Scanner scanner = new Scanner(System.in);
        String customerId = scanner.nextLine(); //gets customer id from userInput

        DBUtils db = new DBUtils();

        db.query1(customerId);

        db.query2(customerId);

        db.query3(customerId);

//        try{
//            Class.forName("org.sqlite.JDBC");
//            Connection con= DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/testdatabase","root","VanillaIce@93"); // gets connection and logs into database specified
////here testdatabase is database name, root is username and password :VanillaIce@93
////first query
//            Statement addressStmt=con.createStatement();
//            ResultSet addressData=addressStmt.executeQuery("select address from customers" +
//                    " where customer_Id = "+ customerId);
//            while(addressData.next())
//                System.out.println("Query 1\n" +" Customers address : " +addressData.getString(1));
//
////second query
//            Statement accountStmt=con.createStatement();
//            ResultSet accountData=accountStmt.executeQuery("select sum(balance) from accounts where customer_Id = "+ customerId);
//            while(accountData.next())
//                System.out.println("Query 2\n" + " Total balance for all accounts : " + accountData.getString(1));
//
////third query
//            System.out.println("Query 3\n" +" Overview of transactions :");
//
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("SELECT account_number, date_of_transaction, transaction_type, amount from transactions\n" +
//                    "INNER JOIN Customers ON transactions.customer_Id = Customers.customer_Id\n" +
//                    "where transactions.customer_Id = "+customerId);
//            while(rs.next())
//                System.out.println(" - "+rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
//
//
//            con.close();
//        }catch(Exception e){ System.out.println(e);}
//
//    }
    }
}
