import ru.gazprombank.oop.incapsulation.Account;
import ru.gazprombank.oop.incapsulation.PaymentAccount;
import ru.gazprombank.oop.polymorphism.OverdraftAccount;

import java.math.BigDecimal;

void main() {
    var account = new Account("Simple account");
    var paymentAccount = new PaymentAccount("Deposit account");
    var overdraftAccount = new OverdraftAccount("Overdraft account", BigDecimal.valueOf(200));

    var printer = new BalancePrinter();
    printer.print(account);
    printer.print(paymentAccount);
    printer.print(overdraftAccount);

}

// Generic
public interface Printer<T> {
    void print(T obj);
}

class BalancePrinter implements Printer<Account> {
    public void print(Account acc) {
        System.out.println(acc.getName() + ", balance: " + acc.getBalance());
    }
}