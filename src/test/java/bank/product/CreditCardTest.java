package bank.product;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class CreditCardTest {
    private CreditCard card;

    @BeforeEach
     void setUp() {
        card = new CreditCard("Gold", "USD",
                BigDecimal.valueOf(1000), BigDecimal.valueOf(0.15));
    }


    @Test
    @DisplayName("Списание средств привело к сокращению баланса счета и увеличению долга")
    public void testCreditCardOperations() {
        card.debit(BigDecimal.valueOf(200));

        assertEquals(BigDecimal.valueOf(800), card.getBalance());
        assertEquals(BigDecimal.valueOf(200), card.getDebt());
    }

    @Test
    @DisplayName("Депозит уменьшился перед увеличением баланса счета")
    public void depositReducesDebFirst() {
        card.debit(BigDecimal.valueOf(300));
        card.deposit(BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(700), card.getBalance());
        assertEquals(BigDecimal.valueOf(200), card.getDebt());
    }

    @Test
    @DisplayName("При погашении депозит баланс счета увеличился")
    public void depositIncreasesBalanceAfterClearance() {
        card.debit(BigDecimal.valueOf(300));
        card.deposit(BigDecimal.valueOf(400));

        assertEquals(BigDecimal.valueOf(800), card.getBalance());
        assertEquals(BigDecimal.ZERO, card.getDebt());
    }

    @Test
    @DisplayName("Вывод отрицательной суммы должен вызвать исключение")
    public void debitNegativeAmountThrowsException() {
        assertThrows(IllegalArgumentException.class,
                ()-> card.debit(BigDecimal.valueOf(-50)));
    }

    @Test
    @DisplayName("При выводе средств, превышающих доступные, возникает исключение")
    public void debitExceedingFundsTrowsException() {
        assertThrows(IllegalStateException.class,
                ()-> card.debit(BigDecimal.valueOf(1500)));
    }

}
