import java.math.BigDecimal;

public void main() {
    var shop = new Shop(new Cash());
    shop.doPayment(new Order(), BigDecimal.valueOf(300));

    var shopDIP = new ShopDIP(new CashDIP());
    shopDIP.doPayment(new Order(), BigDecimal.valueOf(400));
    var shopCifRub = new ShopDIP(new CifRub());
    shopCifRub.doPayment(new Order(), BigDecimal.valueOf(400));
    var shopCard = new ShopDIP(new BankCard());
    shopCard.doPayment(new Order(), BigDecimal.valueOf(500));
}

public class Cash {
    public void doTransaction(BigDecimal amount) {
        System.out.println(STR."Совершена транзакция наличными на сумму \{amount}");
    }
}

public class Shop {
    private final Cash cash;
    public Shop(Cash cash) {
        this.cash = cash;
    }
    public void doPayment(Order order, BigDecimal amount){
        cash.doTransaction(amount);
    }
}

///

public interface PaymentMethod {
    void doTransaction(BigDecimal amount);
}

public class ShopDIP {
    private final PaymentMethod paymentMethod;
    public ShopDIP(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void doPayment(Order order, BigDecimal amount){
        paymentMethod.doTransaction(amount);
    }
}

public class CashDIP implements PaymentMethod {
    @Override
    public void doTransaction(BigDecimal amount) {
        System.out.println(STR."Совершена транзакция наличными на сумму \{amount}");
    }
}
public class BankCard implements PaymentMethod {
    @Override
    public void doTransaction(BigDecimal amount) {
        System.out.println(STR."Совершена транзакция с карты на сумму \{amount}");
    }
}
public class CifRub implements PaymentMethod {
    @Override
    public void doTransaction(BigDecimal amount) {
        System.out.println(STR."Совершена транзакция цифровым рублём на сумму \{amount}");
    }
}

public class Order {}