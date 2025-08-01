package bank.service;

import bank.product.Deposit;

import java.math.BigDecimal;

public class DepositService {

    public void replenish(Deposit deposit, BigDecimal amount){
        deposit.deposit(amount);
    }

    public BigDecimal checkBalance(Deposit deposit){
        return deposit.getBalance();
    }

    public BigDecimal closeDeposit(Deposit deposit){
        return deposit.close();
    }

}
