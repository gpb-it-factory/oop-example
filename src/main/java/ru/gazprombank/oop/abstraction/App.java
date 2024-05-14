package ru.gazprombank.oop.abstraction;

import ru.gazprombank.oop.incapsulation.PaymentAccount;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) throws Exception {
        //var account = new BankAccount("Deposit account"); // abstract class instance cannot be initialized
        var paymentAccount = new PaymentBankAccount("Payment account");

        paymentAccount.fill(BigDecimal.valueOf(100));
        System.out.println(paymentAccount);

        paymentAccount.charge(BigDecimal.valueOf(200));
        System.out.println(paymentAccount);

    }
}
