package bank.service;

import bank.product.Card;

import java.math.BigDecimal;

public interface CardService {
    void replenish (Card card, BigDecimal amount);
    void takeOff (Card card, BigDecimal amount);
    BigDecimal checkBalance (Card card);
}
