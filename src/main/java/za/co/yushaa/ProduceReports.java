package za.co.yushaa;

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

    }
}
