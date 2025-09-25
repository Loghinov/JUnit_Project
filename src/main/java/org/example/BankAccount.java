package org.example;

import java.util.Objects;

public class BankAccount {
    private final String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) throws IllegalAccessException {
        this.owner = Objects.requireNonNull(owner, "owner cannot be null");
        if (initialBalance < 0) throw new IllegalAccessException("Initial balance must be >=0");
        this.balance = initialBalance;
    }

    public String owner() {
        return owner;
    }

    public double balance() {
        return balance;
    }

    public void deposit(double amount) throws IllegalAccessException {
        if (amount <= 0) throw new IllegalAccessException("Deposit must be >0");
        balance += amount;
    }

    public void withdraw(double amount) throws IllegalAccessException {
        if (amount <= 0) throw new IllegalAccessException("Withdraw must be >0");
        if (amount > balance) throw new IllegalAccessException("Insufficient funds");
        balance -= amount;
    }

    public boolean isOverdrawn() {
        return balance < 0;
    }
}
