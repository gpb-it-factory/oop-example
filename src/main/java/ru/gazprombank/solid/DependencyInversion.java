import java.math.BigDecimal;

///

public void main() {
}

public class Cash {
    public void doTransaction(BigDecimal amount){
        //logic
    }
}

public class Shop {
    private Cash cash;
    public Shop(Cash cash) {
        this.cash = cash;
    }
    public void doPayment(Object order, BigDecimal amount){
        cash.doTransaction(amount);
    }
}

///


public interface Payments {
    void doTransaction(BigDecimal amount);
}

public class Cash2 implements Payments {
    @Override
    public void doTransaction(BigDecimal amount) {
        //logic
    }
}
public class BankCard implements Payments{
    @Override
    public void doTransaction(BigDecimal amount) {
        //logic
    }
}
public class PayByPhone implements Payments {
    @Override
    public void doTransaction(BigDecimal amount) {
        //logic
    }
}