package ua.nure.cpp.lab2.free_checkout;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FastFoodRestaurantTest {
    @Test
    void addCashDesk() {
        FastFoodRestaurant restaurant = new FastFoodRestaurant();
        CashDesk mockCashDesk = Mockito.mock(CashDesk.class);

        restaurant.addCashDesk(mockCashDesk);

        assertEquals(1, restaurant.getCashDesks().size());
    }

    @Test
    void isEmpty_WhenRestaurantIsEmpty() {
        FastFoodRestaurant restaurant = new FastFoodRestaurant();
        CashDesk mockCashDesk = Mockito.mock(CashDesk.class);
        when(mockCashDesk.isLineEmpty()).thenReturn(true);

        restaurant.addCashDesk(mockCashDesk);

        assertTrue(restaurant.isEmpty());
    }

    @Test
    void isEmpty_WhenRestaurantIsNotEmpty() {
        FastFoodRestaurant restaurant = new FastFoodRestaurant();
        CashDesk mockCashDesk = Mockito.mock(CashDesk.class);
        when(mockCashDesk.isLineEmpty()).thenReturn(false);

        restaurant.addCashDesk(mockCashDesk);

        assertFalse(restaurant.isEmpty());
    }
}
