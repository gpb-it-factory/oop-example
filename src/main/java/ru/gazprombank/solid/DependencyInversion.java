import java.math.BigDecimal;

// Dependency Inversion Principle - принцип инверсии зависимостей.
// Модули верхнего уровня не должны зависеть от модулей нижнего уровня.
// И те, и другие должны зависеть от абстракции.
// Абстракции не должны зависеть от деталей. Детали должны зависеть от абстракций.
public void main() {
    var shop = new Shop(new Cash());
    var order = new Order(BigDecimal.valueOf(300));
    shop.doPayment(order);

    // зависим от абстракции, а не конкретной реализации
    // поэтому доступны разные методы оплаты
    var shopDIP = new ShopDIP(new CashDIP());
    shopDIP.doPayment(order);
    var shopCifRub = new ShopDIP(new CifRub());
    shopCifRub.doPayment(order);
    var shopCard = new ShopDIP(new BankCard());
    shopCard.doPayment(order);
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
    public void doPayment(Order order){
        cash.doTransaction(order.getAmount());
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
    public void doPayment(Order order){
        paymentMethod.doTransaction(order.getAmount());
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

public class Order {
    private final BigDecimal amount;

    public Order(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}