package ru.gazprombank.oop.abstraction;

import java.math.BigDecimal;

public class PaymentBankAccount extends BankAccount {

    public PaymentBankAccount(String name) {
        super(name);
    }

    @Override
    public BigDecimal fill(BigDecimal amount) {
        var newBalance = this.balance.add(amount);
        this.balance = newBalance;
        System.out.println("Refilling payment account for: " + amount);
        return newBalance;
    }

    public BigDecimal charge(BigDecimal amount) throws Exception {
        var newBalance = this.balance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Not enough balance");
        } else {
            this.balance = newBalance;
            System.out.println("Charging account for: " + amount);
        }
        return this.balance;
    }

}
