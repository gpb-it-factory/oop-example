package ru.gazprombank.oop.incapsulation;

import java.math.BigDecimal;

public class Account {

    private String name;
    protected BigDecimal balance;

    public Account(String name) {
        this.name = name;
        this.balance = BigDecimal.ZERO;
    }

    public BigDecimal fill(BigDecimal amount) {
        var newBalance = this.balance.add(amount);
        this.balance = newBalance;
        System.out.println("Refilling account for: " + amount);
        return newBalance;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public String getName() {
        return this.name;
    }

}

