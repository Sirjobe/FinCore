package bank.product;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CurrencyDebitCardTest {
   private CurrencyDebitCard card;

   @BeforeEach
   void setUp(){
       card = new CurrencyDebitCard("MultiCurrency", "GBP" , BigDecimal.valueOf(200));
   }
    @Test
    @DisplayName("Депозит должен увеличить баланс")
    public void depositIncreasesBalance() {
        card.deposit(BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(300), card.getBalance());
    }

    @Test
    @DisplayName("Вывод средств должен привести к уменьшению баланса")
    public void debitReducesBalance(){
        card.debit(BigDecimal.valueOf(50));

        assertEquals(BigDecimal.valueOf(150), card.getBalance());
    }

}
