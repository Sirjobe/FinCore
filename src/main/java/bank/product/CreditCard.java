package bank.product;

import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;

@Getter
public class CreditCard extends Card{
    private final BigDecimal interestRate;
    private BigDecimal debt = BigDecimal.ZERO;


    public CreditCard(String name, String currency, BigDecimal balance, BigDecimal interestRate) {
        super(name, currency, balance);
        this.interestRate = interestRate;
    }

    
    @Override
    public void deposit(@NonNull BigDecimal amount) {
        if (debt.compareTo(BigDecimal.ZERO) > 0){
            if(amount.compareTo(debt) <= 0){
                debt = debt.subtract(amount);
            }else {
                BigDecimal remainder = amount.subtract(debt);
                debt = BigDecimal.ZERO;
                super.deposit(remainder);
            }
        }else{
            super.deposit(amount);
        }

    }

    
    @Override
    public void debit(@NonNull BigDecimal amountDebit) {

        super.debit(amountDebit);
        debt = debt.add(amountDebit);
    }

}
