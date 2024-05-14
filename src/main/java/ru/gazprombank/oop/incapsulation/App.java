package ru.gazprombank.oop.incapsulation;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) throws Exception {
        var account = new Account("Deposit account");

        var paymentAccount = new PaymentAccount("Deposit account");
        paymentAccount.fill(BigDecimal.valueOf(100));
        System.out.println(paymentAccount.getBalance());
        paymentAccount.charge(BigDecimal.valueOf(200));
        System.out.println(paymentAccount.getBalance());

    }
}
