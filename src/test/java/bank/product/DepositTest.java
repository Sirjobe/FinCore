package bank.product;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;


public class DepositTest {
    private Deposit deposit;

    @BeforeEach
    void setUp(){
        deposit = new Deposit("Saving", "RUB", BigDecimal.valueOf(10000));
    }

    @Test
    @DisplayName("Депозит увеличивает баланс")
    public void depositIncreasesBalance() {
        deposit.deposit(BigDecimal.valueOf(5000));
        assertEquals(BigDecimal.valueOf(15000), deposit.getBalance());
    }

    @Test
    @DisplayName("Закрытие депозита возвращает баланс и нулевой счет")
    public void closeReturnsBalanceAndResetAccount() {
        deposit.deposit(BigDecimal.valueOf(3000));
        BigDecimal closedAmount = deposit.close();
        assertEquals(BigDecimal.valueOf(13000), closedAmount);
        assertEquals(BigDecimal.ZERO, deposit.getBalance());
        assertTrue(deposit.isClosed());
    }

    @Test
    @DisplayName("Депозит после закрытия вызывает исключение")
    public void depositAfterCloseThrowsException() {
        deposit.close();
        assertThrows(IllegalStateException.class,
                () -> deposit.deposit(BigDecimal.valueOf(1000)));
    }

    @Test
    @DisplayName("Отрицательный депозит вызывает исключение")
    public void depositNegativeAmountThrowsException(){
        assertThrows(IllegalArgumentException.class, ()-> deposit.deposit(BigDecimal.valueOf(-1000)));
    }
}
