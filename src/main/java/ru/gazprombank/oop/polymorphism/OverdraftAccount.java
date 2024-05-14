package ru.gazprombank.oop.polymorphism;

import ru.gazprombank.oop.incapsulation.PaymentAccount;

import java.math.BigDecimal;

public class OverdraftAccount extends PaymentAccount {

    private final BigDecimal overdraftLimit;

    public OverdraftAccount(String name, BigDecimal overdraftLimit) {
        super(name);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public BigDecimal charge(BigDecimal amount) {
        var newBalance = this.balance.subtract(amount);
        if (this.overdraftLimit.add(newBalance).compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Overdraft exceeded");
        } else {
            this.balance = newBalance;
            System.out.println("Charging account for: " + amount);
        }
        return this.balance;
    }

}
