package ua.nure.cpp.lab2.free_checkout;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CashDeskTest {

    @Test
    void removeCustomer() {
        FastFoodRestaurant mockRestaurant = Mockito.mock(FastFoodRestaurant.class);
        CashDesk cashDesk = new CashDesk(1, mockRestaurant);
        Customer mockCustomer = Mockito.mock(Customer.class);

        cashDesk.addCustomer(mockCustomer);
        cashDesk.removeCustomer(mockCustomer);

        assertEquals(0, cashDesk.getLineSize());
    }

    @Test
    void getLineSize() {
        FastFoodRestaurant mockRestaurant = Mockito.mock(FastFoodRestaurant.class);
        CashDesk cashDesk = new CashDesk(1, mockRestaurant);
        Customer mockCustomer1 = Mockito.mock(Customer.class);
        Customer mockCustomer2 = Mockito.mock(Customer.class);

        cashDesk.addCustomer(mockCustomer1);
        cashDesk.addCustomer(mockCustomer2);

        assertEquals(2, cashDesk.getLineSize());
    }

    @Test
    void isLineEmpty_WhenLineIsEmpty() {
        FastFoodRestaurant mockRestaurant = Mockito.mock(FastFoodRestaurant.class);
        CashDesk cashDesk = new CashDesk(1, mockRestaurant);

        assertTrue(cashDesk.isLineEmpty());
    }

    @Test
    void isLineEmpty_WhenLineIsNotEmpty() {
        FastFoodRestaurant mockRestaurant = Mockito.mock(FastFoodRestaurant.class);
        CashDesk cashDesk = new CashDesk(1, mockRestaurant);
        Customer mockCustomer = Mockito.mock(Customer.class);

        cashDesk.addCustomer(mockCustomer);

        assertFalse(cashDesk.isLineEmpty());
    }
}
