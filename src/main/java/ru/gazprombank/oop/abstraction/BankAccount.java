package ru.gazprombank.oop.abstraction;

import java.math.BigDecimal;

public abstract class BankAccount {

    private String name;
    protected BigDecimal balance;

    public BankAccount(String name) {
        this.name = name;
        this.balance = BigDecimal.ZERO;
    }

    public abstract BigDecimal fill(BigDecimal amount);

    public BigDecimal getBalance() {
        return this.balance;
    }

    public String getName() {
        return this.name;
    }

}

