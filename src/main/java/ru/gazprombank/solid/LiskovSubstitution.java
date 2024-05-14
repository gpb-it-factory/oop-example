import java.math.BigDecimal;

// Liskov substitution Principle - принцип подстановки Барбары Лисков.
// Должна быть возможность вместо базового (родительского) типа (класса) подставить любой его подтип (класс-наследник),
// при этом работа программы не должна измениться.
public void main() {
    Account salaryAccount = new SalaryAccount();
    salaryAccount.withdraw("40702810200210000237", BigDecimal.valueOf(150));

    Account depositAccount = new DepositAccount();
    try {
        depositAccount.withdraw("40702810200210000238", BigDecimal.valueOf(100));
    } catch (UnsupportedOperationException e) {
        System.out.println(e.getMessage());
    }

    var lspSalaryAccount = new LSPSalaryAccount();
    lspSalaryAccount.withdraw("40702810200210000237", BigDecimal.valueOf(150));
    var lspDepositAccount = new LSPDepositAccount();
    // lspDepositAccount.withdraw() - такого метода даже нет, невозможно вызвать ошибку
}

public class Account {
    public BigDecimal balance(String accountNumber) {
        System.out.println(STR."Получен баланс по счёту \{accountNumber}");
        return BigDecimal.ZERO;
    };
    public void refill(String accountNumber, BigDecimal amount) {
        System.out.println(STR."Пополнен счёт \{accountNumber} на сумму \{amount}");
    }
    public void withdraw(String accountNumber, BigDecimal amount) {
        System.out.println(STR."Со счёта \{accountNumber} снята сумма \{amount}");
    }
}

public class SalaryAccount extends Account {
    @Override
    public void refill(String accountNumber, BigDecimal amount) {
        System.out.println(STR."Получена зарплата \{amount}");
        super.refill(accountNumber, amount);
    }
}

public class DepositAccount extends Account {
    @Override
    public void withdraw(String accountNumber, BigDecimal amount) {
        throw new UnsupportedOperationException("Ошибка, с депозита нельзя снимать средства");
    }
}

public class LSPAccount {
    public BigDecimal balance(String accountNumber) {
        System.out.println(STR."Получен баланс по счёту \{accountNumber}");
        return BigDecimal.ZERO;
    }
}

public interface Refillable {
    void refill(String accountNumber, BigDecimal amount);
}


public interface Withdrawable {
    void withdraw(String accountNumber, BigDecimal amount);
}

public class LSPDepositAccount extends LSPAccount implements Refillable {
    @Override
    public BigDecimal balance(String accountNumber) {
        System.out.println(STR."Получен баланс по депозиту \{accountNumber}");
        return BigDecimal.ZERO;
    };
    @Override
    public void refill(String accountNumber, BigDecimal amount) {
        System.out.println(STR."Пополнен депозит \{accountNumber} на сумму \{amount}");
    }
}

public class LSPSalaryAccount extends LSPAccount implements Refillable, Withdrawable {
    @Override
    public void refill(String accountNumber, BigDecimal amount) {
        System.out.println(STR."Пополнен зарплатный счёт \{accountNumber} на сумму \{amount}");
    }
    @Override
    public void withdraw(String accountNumber, BigDecimal amount) {
        System.out.println(STR."С зарплатного счёта \{accountNumber} снята сумма \{amount}");
    }
}