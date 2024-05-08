public void main() {
}

interface Payments {
    void payWebMoney();
    void payCreditCard();
    void payPhoneNumber();
}

class InternetPaymentService implements Payments{
    @Override
    public void payWebMoney() {
        //logic
    }
    @Override
    public void payCreditCard() {
        //logic
    }
    @Override
    public void payPhoneNumber() {
        //logic
    }
}

class TerminalPaymentService implements Payments{
    @Override
    public void payWebMoney() {
        //logic
    }
    @Override
    public void payCreditCard() {
        //logic
    }
    @Override
    public void payPhoneNumber() {
        //???????
    }
}

/////


interface WebMoneyPayment {
    void payWebMoney();
}
interface CreditCardPayment {
    void payCreditCard();
}
interface PhoneNumberPayment {
    void payPhoneNumber();
}

class InternetPaymentService2 implements WebMoneyPayment,
        CreditCardPayment,
        PhoneNumberPayment{
    @Override
    public void payWebMoney() {
        //logic
    }
    @Override
    public void payCreditCard() {
        //logic
    }
    @Override
    public void payPhoneNumber() {
        //logic
    }
}

class TerminalPaymentService2 implements WebMoneyPayment, CreditCardPayment{
    @Override
    public void payWebMoney() {
        //logic
    }
    @Override
    public void payCreditCard() {
        //logic
    }
}

