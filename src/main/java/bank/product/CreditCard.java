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

    /**
     * Пополнение баланса на значение amount
     * проверка на null и значение amount <= 0
     *
     * @param amount
     */
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

    /**
     * Списание средств на значение amountDebit
     * с проверкой на null и значение amountDebit <= 0, а также что баланс < 0
     *
     * @param amountDebit
     */
    @Override
    public void debit(@NonNull BigDecimal amountDebit) {

        super.debit(amountDebit);
        debt = debt.add(amountDebit);
    }

}
