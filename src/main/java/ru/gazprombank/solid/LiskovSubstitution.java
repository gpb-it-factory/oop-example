import java.math.BigDecimal;

/// Interfaces over inheritance?

public void main() {

}

public class Account {
    public BigDecimal balance(String numberAccount){
        //logic
        return BigDecimal.ZERO;
    };
    public void refill(String numberAccount, BigDecimal sum){
        //logic
    }
    public void payment(String numberAccount, BigDecimal sum){
        //logic
    }

}
public class SalaryAccount extends Account{
    @Override
    public BigDecimal balance(String numberAccount){
        //logic
        return BigDecimal.ZERO;
    };
    @Override
    public void refill(String numberAccount, BigDecimal sum){
        //logic
    }
    @Override
    public void payment(String numberAccount, BigDecimal sum){
        //logic
    }
}
public class DepositAccount extends Account{
    @Override
    public BigDecimal balance(String numberAccount){
        //logic
        return BigDecimal.ZERO;
    };
    @Override
    public void refill(String numberAccount, BigDecimal sum){
        //logic
    }
    @Override
    public void payment(String numberAccount, BigDecimal sum){
        throw new UnsupportedOperationException("Operation not supported");
    }
}

/////

public class DepositAccount2 extends Account{
    @Override
    public BigDecimal balance(String numberAccount){
        //logic
        return BigDecimal.ZERO;
    };
    @Override
    public void refill(String numberAccount, BigDecimal sum){
        //logic
    }
}

public class PaymentAccount extends Account{
    public void payment(String numberAccount, BigDecimal sum){
        //logic
    }
}

// ?????
public class SalaryAccount2 extends PaymentAccount{
    @Override
    public BigDecimal balance(String numberAccount){
        //logic
        return BigDecimal.ZERO;
    };
    @Override
    public void refill(String numberAccount, BigDecimal sum){
        //logic
    }
    @Override
    public void payment(String numberAccount, BigDecimal sum){
        //logic
    }
}