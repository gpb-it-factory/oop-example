package ru.gazprombank.oop.incapsulation;

import java.math.BigDecimal;

public class PaymentAccount extends Account {

    public PaymentAccount(String name) {
        super(name);
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
