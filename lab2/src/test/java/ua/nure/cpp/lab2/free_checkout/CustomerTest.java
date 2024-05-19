package ua.nure.cpp.lab2.free_checkout;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CustomerTest {

    @Test
    void chooseCashDesk_WhenThereIsOneCashDesk() {
        FastFoodRestaurant mockRestaurant = Mockito.mock(FastFoodRestaurant.class);
        CashDesk mockCashDesk = Mockito.mock(CashDesk.class);
        when(mockRestaurant.getCashDesks()).thenReturn(List.of(mockCashDesk));

        Customer customer = new Customer(mockRestaurant);
        customer.chooseCashDesk();

        verify(mockCashDesk, times(1)).addCustomer(customer);
    }

    @Test
    void chooseCashDesk_WhenThereAreMultipleCashDesks() {
        FastFoodRestaurant mockRestaurant = Mockito.mock(FastFoodRestaurant.class);
        CashDesk mockCashDesk1 = Mockito.mock(CashDesk.class);
        CashDesk mockCashDesk2 = Mockito.mock(CashDesk.class);
        CashDesk mockCashDesk3 = Mockito.mock(CashDesk.class);
        BlockingDeque<Customer> mockLine1 = new LinkedBlockingDeque<>();
        BlockingDeque<Customer> mockLine2 = new LinkedBlockingDeque<>();
        BlockingDeque<Customer> mockLine3 = new LinkedBlockingDeque<>();
        when(mockCashDesk1.getLine()).thenReturn(mockLine1);
        when(mockCashDesk2.getLine()).thenReturn(mockLine2);
        when(mockCashDesk3.getLine()).thenReturn(mockLine3);
        when(mockRestaurant.getCashDesks()).thenReturn(List.of(mockCashDesk1, mockCashDesk2, mockCashDesk3));
        when(mockCashDesk1.getLineSize()).thenReturn(2);
        when(mockCashDesk2.getLineSize()).thenReturn(1);
        when(mockCashDesk3.getLineSize()).thenReturn(3);

        Customer customer = new Customer(mockRestaurant);
        customer.chooseCashDesk();

        verify(mockCashDesk2, times(1)).addCustomer(customer);
    }

    @Test
    void chooseCashDesk_WhenAllCashDesksHaveSameNumberOfCustomers() {
        FastFoodRestaurant mockRestaurant = Mockito.mock(FastFoodRestaurant.class);
        CashDesk mockCashDesk1 = Mockito.mock(CashDesk.class);
        CashDesk mockCashDesk2 = Mockito.mock(CashDesk.class);
        BlockingDeque<Customer> mockLine1 = new LinkedBlockingDeque<>();
        BlockingDeque<Customer> mockLine2 = new LinkedBlockingDeque<>();
        when(mockCashDesk1.getLine()).thenReturn(mockLine1);
        when(mockCashDesk2.getLine()).thenReturn(mockLine2);
        when(mockRestaurant.getCashDesks()).thenReturn(List.of(mockCashDesk1, mockCashDesk2));
        when(mockCashDesk1.getLineSize()).thenReturn(2);
        when(mockCashDesk2.getLineSize()).thenReturn(2);

        Customer customer = new Customer(mockRestaurant);
        customer.chooseCashDesk();

        verify(mockCashDesk1, times(1)).addCustomer(customer);
    }

    @Test
    void switchLineIfNecessary_WhenOtherLineHasZeroCustomers() {
        FastFoodRestaurant mockRestaurant = Mockito.mock(FastFoodRestaurant.class);
        CashDesk mockCashDesk1 = Mockito.mock(CashDesk.class);
        CashDesk mockCashDesk2 = Mockito.mock(CashDesk.class);
        BlockingDeque<Customer> mockLine1 = new LinkedBlockingDeque<>();
        BlockingDeque<Customer> mockLine2 = new LinkedBlockingDeque<>();
        when(mockCashDesk1.getLine()).thenReturn(mockLine1);
        when(mockCashDesk2.getLine()).thenReturn(mockLine2);
        when(mockRestaurant.getCashDesks()).thenReturn(List.of(mockCashDesk1, mockCashDesk2));
        when(mockCashDesk1.getLineSize()).thenReturn(3);
        when(mockCashDesk2.getLineSize()).thenReturn(2);

        Customer customer = new Customer(mockRestaurant);
        customer.chooseCashDesk();

        when(mockCashDesk1.getLineSize()).thenReturn(0);

        boolean hasSwitched = customer.switchLineIfNecessary();

        verify(mockCashDesk2, times(1)).addCustomer(customer);
        verify(mockCashDesk2, times(1)).removeCustomer(customer);
        verify(mockCashDesk1, times(1)).addCustomer(customer);
        assertTrue(hasSwitched);
    }

    @Test
    void switchLineIfNecessary_WhenOtherLineHasSignificantlyLessCustomers() {
        FastFoodRestaurant mockRestaurant = Mockito.mock(FastFoodRestaurant.class);
        CashDesk mockCashDesk1 = Mockito.mock(CashDesk.class);
        CashDesk mockCashDesk2 = Mockito.mock(CashDesk.class);
        BlockingDeque<Customer> mockLine1 = new LinkedBlockingDeque<>();
        BlockingDeque<Customer> mockLine2 = new LinkedBlockingDeque<>();
        when(mockCashDesk1.getLine()).thenReturn(mockLine1);
        when(mockCashDesk2.getLine()).thenReturn(mockLine2);
        when(mockRestaurant.getCashDesks()).thenReturn(List.of(mockCashDesk1, mockCashDesk2));
        when(mockCashDesk1.getLineSize()).thenReturn(4);
        when(mockCashDesk2.getLineSize()).thenReturn(3);

        Customer customer = new Customer(mockRestaurant);
        customer.chooseCashDesk();

        when(mockCashDesk1.getLineSize()).thenReturn(1);

        boolean hasSwitched = customer.switchLineIfNecessary();

        verify(mockCashDesk2, times(1)).addCustomer(customer);
        verify(mockCashDesk2, times(1)).removeCustomer(customer);
        verify(mockCashDesk1, times(1)).addCustomer(customer);
        assertTrue(hasSwitched);
    }

    @Test
    void switchLineIfNecessary_WhenSwitchingIsNotReasonable() {
        FastFoodRestaurant mockRestaurant = Mockito.mock(FastFoodRestaurant.class);
        CashDesk mockCashDesk1 = Mockito.mock(CashDesk.class);
        CashDesk mockCashDesk2 = Mockito.mock(CashDesk.class);
        BlockingDeque<Customer> mockLine1 = new LinkedBlockingDeque<>();
        BlockingDeque<Customer> mockLine2 = new LinkedBlockingDeque<>();
        when(mockCashDesk1.getLine()).thenReturn(mockLine1);
        when(mockCashDesk2.getLine()).thenReturn(mockLine2);
        when(mockRestaurant.getCashDesks()).thenReturn(List.of(mockCashDesk1, mockCashDesk2));
        when(mockCashDesk1.getLineSize()).thenReturn(2);
        when(mockCashDesk2.getLineSize()).thenReturn(1);

        Customer customer = new Customer(mockRestaurant);
        customer.chooseCashDesk();
        boolean hasSwitched = customer.switchLineIfNecessary();

        verify(mockCashDesk1, never()).removeCustomer(customer);
        verify(mockCashDesk2, atMostOnce()).addCustomer(customer);
        assertFalse(hasSwitched);
    }
}
