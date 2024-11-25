package pr3;

import static org.junit.Assert.*;

import org.junit.Test;

public class pr3test {

	private final pr3 app = new pr3();

    @Test
    public void testExtractProductPrice() {
        // Проверим корректность извлечения цены из строки
        String product = "Наушники - 200 руб.";
        int expectedPrice = 200;
        int actualPrice = app.extractProductPrice(product);
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testCalculateTotalCost_WithCourier() {
        // Проверим, что цена с курьером рассчитывается правильно
        String product = "Сигареты - 100 руб.";
        boolean isCourier = true;  // выбрали курьера
        int expectedCost = 100 + 50;  // цена товара + стоимость доставки
        int actualCost = app.calculateTotalCost(product, isCourier);
        assertEquals(expectedCost, actualCost);
    }
    @Test
    public void testCalculateTotalCost_WithPickup() {
        // Проверим, что цена без курьера (пункт выдачи) рассчитывается правильно
        String product = "Молоко - 300 руб.";
        boolean isCourier = false;  // выбрали пункт выдачи
        int expectedCost = 300;  // только цена товара, без доставки
        int actualCost = app.calculateTotalCost(product, isCourier);
        assertEquals(expectedCost, actualCost);
    }
}
