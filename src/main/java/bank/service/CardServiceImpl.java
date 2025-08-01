package bank.service;

import bank.product.Card;

import java.math.BigDecimal;

public class CardServiceImpl implements CardService{
    @Override
    public void replenish(Card card, BigDecimal amount) {
        card.deposit(amount);
    }

    @Override
    public void takeOff(Card card, BigDecimal amount) {
        card.debit(amount);
    }

    @Override
    public BigDecimal checkBalance(Card card) {
        return card.getBalance();
    }
}
