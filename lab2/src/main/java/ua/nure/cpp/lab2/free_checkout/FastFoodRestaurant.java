package ua.nure.cpp.lab2.free_checkout;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Log4j2
public class FastFoodRestaurant {
    private static final int MIN_START_AMOUNT_OF_CUSTOMERS = 30;
    private static final int MAX_START_AMOUNT_OF_CUSTOMERS = 40;

    @Getter
    private final List<CashDesk> cashDesks = new ArrayList<>();
    private ExecutorService executorService;

    @Getter
    private boolean isClosed = false;

    public void openRestaurant() {
        executorService = Executors.newFixedThreadPool(cashDesks.size());
        cashDesks.forEach(executorService::execute);
        LOGGER.info("Restaurant has started serving!");
    }

    public void initialize() {
        int numberOfCustomers = ThreadLocalRandom.current().nextInt(MIN_START_AMOUNT_OF_CUSTOMERS, MAX_START_AMOUNT_OF_CUSTOMERS + 1);
        fillRestaurantCashDesksWithCustomers(numberOfCustomers);

        LOGGER.debug("All restaurant CashDesks have been successfully filled with clients. Initialization successful.");
    }

    public void closeRestaurant() {
        isClosed = true;
        executorService.shutdown();
        LOGGER.info("Restaurant is closed!");
    }

    public void addCashDesk(CashDesk cashDesk) {
        cashDesks.add(cashDesk);
        LOGGER.trace("CashDesk#{} has been added to the restaurant", cashDesk.getId());
    }

    public boolean isEmpty() {
        for (CashDesk cashDesk : cashDesks) {
            if (!cashDesk.isLineEmpty()) {
                return false;
            }
        }

        return true;
    }

    private void fillRestaurantCashDesksWithCustomers(int numberOfCustomers) {
        for (int i = 0; i < numberOfCustomers; i++) {
            Customer customer = new Customer(this);
            customer.chooseCashDesk();
        }
    }
}

