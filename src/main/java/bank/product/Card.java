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

    
    public void deposit(@NonNull BigDecimal amountDeposit){
        if(amountDeposit.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException(illArg);
        }
        balance = balance.add(amountDeposit);
    }

   
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
