public void main() {
    // вся функциональность в одном классе
    var accountService = new AccountService();
    var account = accountService.findAccount("40702810200210000237");
    accountService.printCheck(account);
    accountService.sendSms(account, "+71231231233");

    // у каждого класса своя ответственность
    var refactoredAccountService = new SingleResponsibilityAccountService();
    var accountFromRefactoredService = refactoredAccountService.find("40702810200210000237");
    var checkService = new CheckService();
    checkService.print(accountFromRefactoredService);
    var smsService = new SmsService();
    smsService.send(accountFromRefactoredService, "+71231231233");
}

public class AccountService {
    public Account findAccount(String accountNumber) {
        System.out.println(STR."Найдён счёт в базе по номеру \{accountNumber}");
        return new Account();
    }

    public void printCheck(Account account) {
        System.out.println("Напечатана выписка по счёту");
    }

    public void sendSms(Account account, String phoneNumber) {
        System.out.println(STR."Отправлено уведомление о счёте по смс на номер \{phoneNumber}");
    }
}

public class SingleResponsibilityAccountService {
    public Account find(String accountNumber) {
        System.out.println(STR."Найдён счёт в базе по номеру \{accountNumber}");
        return new Account();
    }
}

public class CheckService {
    public void print(Account account) {
        System.out.println("Напечатана выписка по счёту");
    }
}

public class SmsService {
    public void send(Account account, String phoneNumber) {
        System.out.println(STR."Отправлено уведомление о счёте по смс на номер \{phoneNumber}");
    }
}


public class Account {
    // данные о счёте
}
