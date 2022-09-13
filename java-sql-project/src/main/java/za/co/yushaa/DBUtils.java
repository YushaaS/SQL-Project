package za.co.yushaa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtils {

    public void query1(String customerId){

        try{
            Class.forName("org.sqlite.JDBC");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdatabase","root","VanillaIce@93"); // gets connection and logs into database specified
//here testdatabase is database name, root is username and password :VanillaIce@93
            Statement addressStmt=con.createStatement();
            ResultSet addressData=addressStmt.executeQuery("select address from customers" +
                    " where customer_Id = "+ customerId);
            while(addressData.next())
                System.out.println("Query 1\n" +" Customers address : " +addressData.getString(1));
            con.close();


        }catch(Exception e){ System.out.println(e);}

    }

    public void query2(String customerId){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdatabase","root","VanillaIce@93"); // gets connection and logs into database specified
//here testdatabase is database name, root is username and password :VanillaIce@93
            Statement accountStmt=con.createStatement();
            ResultSet accountData=accountStmt.executeQuery("select sum(balance) from accounts where customer_Id = "+ customerId);
            while(accountData.next())
                System.out.println("Query 2\n" + " Total balance for all accounts : " + accountData.getString(1));

            con.close();


        }catch(Exception e){ System.out.println(e);}

    }

    public void query3(String customerId){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdatabase", "root", "VanillaIce@93"); // gets connection and logs into database specified
//here testdatabase is database name, root is username and password :VanillaIce@93
            System.out.println("Query 3\n" + " Overview of transactions :");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT account_number, date_of_transaction, transaction_type, amount from transactions\n" +
                    "INNER JOIN Customers ON transactions.customer_Id = Customers.customer_Id\n" +
                    "where transactions.customer_Id = " + customerId);
            while (rs.next()){
                System.out.println(" - " + rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
            }

            con.close();


        }catch(Exception e){ System.out.println(e);}


    }

    public int test1 (){
        int count = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdatabase", "root", "VanillaIce@93"); // gets connection and logs into database specified
//here testdatabase is database name, root is username and password :VanillaIce@93

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(customer_Id) from customers");

            while (rs.next()){
                count = rs.getInt("count(customer_Id)");
            }
            System.out.println(" Number of users is as expected ");


            con.close();


        }catch(Exception e){ System.out.println(e);}
        return count;

    }
    public int test2 (){
        int count = 0;
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdatabase","root","VanillaIce@93"); // gets connection and logs into database specified
//here testdatabase is database name, root is username and password :VanillaIce@93

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select count(customer_Id) from accounts where customer_Id = 1001;");

            while(rs.next()) {
                count = rs.getInt("count(customer_Id)");
            }
            System.out.println(" all accounts for customer =  " + count);


            con.close();


        }catch(Exception e){ System.out.println(e);}
        return count;

    }

    private int depositSum (String accountNumber){
        int sum = 0;
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdatabase","root","VanillaIce@93"); // gets connection and logs into database specified
//here testdatabase is database name, root is username and password :VanillaIce@93

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select sum(amount) from transactions where transaction_type = 'deposit' and account_number =  '"+accountNumber+"'; ");

            while(rs.next())
                sum = rs.getInt("sum(amount)");

            con.close();


        }catch(Exception e){ System.out.println(e);}
        return sum;

    }
    //sum of transaction where the transaction type is from a specific account number
    private int withdrawalSum (String accountNumber){
        int sum = 0;
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdatabase","root","VanillaIce@93"); // gets connection and logs into database specified
//here testdatabase is database name, root is username and password :VanillaIce@93

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select sum(amount) from transactions where transaction_type = 'withdraw' and account_number =  '"+accountNumber+"'; ");

            while(rs.next())
                sum = rs.getInt("sum(amount)"); //total of column

            con.close();


        }catch(Exception e){ System.out.println(e);}
        return sum;

    }
    public int combineWithdrawAndDepositSum(String accountNumber){
        int sum = depositSum(accountNumber)-withdrawalSum(accountNumber);
        return sum;
    }

}
