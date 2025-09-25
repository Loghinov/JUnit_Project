package JUnitTesting;

import org.example.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() throws IllegalAccessException {
        account =new BankAccount("Ivan",new Double("100.00"));
    }

    @Test
    void constructor_valid_ok()throws IllegalAccessException{
        BankAccount a = new BankAccount("Alex", 50.0);
        assertThat(a.owner(), is("Alex"));
        assertThat(a.balance(), closeTo(50.00, 0.0001));
    }

    @Test
    void negativeData(){
        assertThrows(IllegalAccessException.class, ()->new BankAccount("X", -1.0));
    }

    @Test
    void nullOwner(){
        assertThrows(NullPointerException.class, ()->new BankAccount(null, 0.0));
    }

    @Test
    void depositValidIncreaseBalance()throws  IllegalAccessException{
        account.deposit(50.0);
        assertThat(account.balance(), closeTo(150.0, 0.0001));
    }

    @Test
    void depositZeroNegative(){
        assertThrows(IllegalAccessException.class, ()-> account.deposit(0.0));
        assertThrows(IllegalAccessException.class, () ->account.deposit(-0.5));
    }

    @Test
    void withdrawDecreaseBalance() throws IllegalAccessException {
        account.withdraw(30.0);
        assertThat(account.balance(), closeTo(70.0, 0.00001));
    }

    @Test
    void withdrawZeroOrNegative(){
        assertThrows(IllegalAccessException.class, () -> account.withdraw(0.0));
        assertThrows(IllegalAccessException.class, () ->account.withdraw(-2.0));
    }

    @Test
    void withdrawMoreOrLessBalance(){
        assertThrows(IllegalAccessException.class, ()-> account.withdraw(200.0));
        assertFalse(account.isOverdrawn());
        assertThat(account.balance(), closeTo(100.0, 0.00001));
    };


}
