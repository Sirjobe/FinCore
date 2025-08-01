package bank.product;

import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;

@Getter
public abstract class Card implements Account {
    private final  String name;
    private final String currency;
    private BigDecimal balance;
    private final String illArg= "Сумма должна быть больше нуля";

    public Card (String name, String currency, BigDecimal balance){
        this.name = name;
        this.currency = currency;
        this.balance = balance;
    }

    /**
     *  Пополнение баланса на значение amount
     *  проверка на null и значение amount <= 0
     */
    public void deposit(@NonNull BigDecimal amountDeposit){
        if(amountDeposit.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException(illArg);
        }
        balance = balance.add(amountDeposit);
    }

    /**
     *  Списание средств на значение amountDebit
     *  с проверкой на null и значение amountDebit <= 0, а также что баланс < 0
     */
    public void debit (@NonNull BigDecimal amountDebit){
        if (amountDebit.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException(illArg);
        }
        if(balance.compareTo(amountDebit) < 0){
            throw new IllegalStateException("Недостаточно средств");
        }
        balance = balance.subtract(amountDebit);
    }


}
