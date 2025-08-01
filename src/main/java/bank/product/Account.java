package bank.product;

import java.math.BigDecimal;

public interface Account {
    String getName();
    String getCurrency();
    BigDecimal getBalance();
}
