package bank.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class DebitCardTest {
    private DebitCard card;

    @BeforeEach
    void setUp(){
        card = new DebitCard("Standart", "EUR", BigDecimal.valueOf(500));
    }

    @Test
    @DisplayName("Депозит увеличил баланс счета")
    public void depositIncreasesBalance() {
        card.deposit(BigDecimal.valueOf(200));
        assertEquals(BigDecimal.valueOf(700), card.getBalance());
    }

    @Test
    @DisplayName("Вывод средств привел к уменьшению баланса счета")
    public void debitReducesBalance() {
        card.debit(BigDecimal.valueOf(300));
        assertEquals(BigDecimal.valueOf(200),card.getBalance());
    }

    @Test
    @DisplayName("Вывод средств выше лимита вызывает исключение")
    public void debitInsufficientFundsThrowsException() {
        assertThrows(IllegalStateException.class,
                () -> card.debit(BigDecimal.valueOf(5000)));
    }

    @Test
    @DisplayName("Отрицательный депозит вызывает исключение")
    public void depositNegativeAmountThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> card.deposit(BigDecimal.valueOf(-100)));
    }


}
