// Interface Segregation Principle - принцип разделения интерфейсов.
// Данный принцип означает, что не нужно заставлять клиента (класс) реализовывать интерфейс,
// который не имеет к нему отношения.
public void main() {
    var internetPaymentService = new InternetPaymentService();
    internetPaymentService.payWebMoney();
    internetPaymentService.payCreditCard();
    internetPaymentService.paySBP();

    var terminalPaymentService = new TerminalPaymentService();
    terminalPaymentService.payWebMoney();
    terminalPaymentService.payCreditCard();
    terminalPaymentService.paySBP();

    var internetPaymentServiceISP = new InternetPaymentServiceISP();
    internetPaymentServiceISP.payWebMoney();
    internetPaymentServiceISP.payCreditCard();
    internetPaymentServiceISP.paySBP();

    var terminalPaymentServiceISP = new TerminalPaymentServiceISP();
    terminalPaymentServiceISP.payCreditCard();
    terminalPaymentServiceISP.paySBP();
}

interface Payments {
    void payWebMoney();
    void payCreditCard();
    void paySBP();
}

class InternetPaymentService implements Payments {
    @Override
    public void payWebMoney() {
        System.out.println("Платёж через интернет по WebMoney");
    }
    @Override
    public void payCreditCard() {
        System.out.println("Платёж через интернет по кредитной карте");
    }
    @Override
    public void paySBP() {
        System.out.println("Платёж через интернет по СБП");
    }
}

class TerminalPaymentService implements Payments {
    @Override
    public void payWebMoney() {
        System.out.println("В данный момент не поддерживается");
    }
    @Override
    public void payCreditCard() {
        System.out.println("Платёж через терминал по кредитной карте");
    }
    @Override
    public void paySBP() {
        System.out.println("Платёж через терминал по СБП");
    }
}

/////

interface WebMoneyPayment {
    void payWebMoney();
}
interface CreditCardPayment {
    void payCreditCard();
}
interface SBPPayment {
    void paySBP();
}

class InternetPaymentServiceISP implements WebMoneyPayment,
        CreditCardPayment,
        SBPPayment {
    @Override
    public void payWebMoney() {
        System.out.println("Платёж через интернет по WebMoney");
    }
    @Override
    public void payCreditCard() {
        System.out.println("Платёж через интернет по кредитной карте");
    }
    @Override
    public void paySBP() {
        System.out.println("Платёж через интернет по СБП");
    }
}

class TerminalPaymentServiceISP implements CreditCardPayment, SBPPayment {
    @Override
    public void payCreditCard() {
        System.out.println("Платёж через терминал по кредитной карте");
    }
    @Override
    public void paySBP() {
        System.out.println("Платёж через терминал по СБП");
    }
}

