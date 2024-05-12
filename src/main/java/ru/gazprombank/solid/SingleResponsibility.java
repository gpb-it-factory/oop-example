public void main() {
    var accountService = new AccountService();
    var account = accountService.findAccount("40702810200210000237");
    accountService.printCheck(account);
    accountService.sendSms(account, "+71231231233");

    var refactoredAccountService = new SingleResponsibilityAccountService();
    var accountFromRefactoredService = refactoredAccountService.find("40702810200210000237");
    var checkService = new CheckService();
    checkService.print(accountFromRefactoredService);
    var smsService = new SmsService();
    smsService.send(accountFromRefactoredService, "+71231231233");
}

public class AccountService {
    public Account findAccount(String accountNumber) {
        // поиск счёта в базе
        return new Account();
    }

    public void printCheck(Account account) {
        // печать выписки
    }

    public void sendSms(Account account, String phoneNumber) {
        // отправка смс-оповещения по счёту
    }
}

public class SingleResponsibilityAccountService {
    public Account find(String accountNumber) {
        // поиск счёта в базе
        return new Account();
    }
}

public class CheckService {
    public void print(Account account) {
        // печать выписки
    }
}

public class SmsService {
    public void send(Account account, String phoneNumber) {
        // отправка смс-оповещения по счёту
    }
}


public class Account {
    // данные о счёте
}
