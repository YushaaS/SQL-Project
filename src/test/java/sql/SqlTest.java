package sql;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.yushaa.DBUtils;

public class SqlTest {

    // Retrieve the number of customers from the database

    // Check that the total number of customers is equal to 2
    @Test
    public void getAllCustomers_checkNumber_shouldBeTwo() {
        DBUtils db = new DBUtils();
        Assertions.assertEquals(2, db.test1());
    }

    // Retrieve all accounts for customer Sarah from the database
    // Check that the total number of accounts for her is 2
    @Test
    public void getAccountsForSarah_checkNumber_shouldBeTwo() {
        DBUtils db = new DBUtils();
        Assertions.assertEquals(2, db.test2());

    }

    // A test that checks that the total of all transactions is equal to (sum) for a given account.
    // Doing this for a single account is enough,
    // and you’re allowed to use the account ID for that account in the query
    @Test
    public void retrieveTransactionsForAccount_checkTotalBalance_shouldBeZero() {
        DBUtils db = new DBUtils();
        Assertions.assertEquals(-400, db.combineWithdrawAndDepositSum("CQ32040"));
    }
}
