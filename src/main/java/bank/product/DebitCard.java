package bank.product;

import java.math.BigDecimal;

public class DebitCard extends Card {

    public DebitCard(String name, String currency, BigDecimal balance) {
        super(name, currency, balance);
    }
}
