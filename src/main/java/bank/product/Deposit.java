package bank.product;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Deposit implements Account{
    private final String name;
    private final String currency;
    private BigDecimal balance;
    private boolean isClosed = false;

    public Deposit (String name, String currency, BigDecimal balance){
        this.name = name;
        this.currency = currency;
        this.balance = balance;
    }

    public void deposit (BigDecimal amount){
        if(isClosed) throw new IllegalStateException("Депозит закрыть");
        if(amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Сумма должна быть больше нуля");
        balance = balance.add(amount);
    }

    public BigDecimal close(){
        if(isClosed) throw new IllegalStateException("Депозит уже закрыт");
        isClosed = true;
        BigDecimal closedBalance = balance;
        balance = BigDecimal.ZERO;
        return closedBalance;
    }
}
