package ua.nure.cpp.lab2.free_checkout;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Log4j2
public class ApplicationRunner {
    private static final int NUMBER_OF_CASH_DESKS_IN_RESTAURANT = 5;
    private static final int APPROXIMATE_SIMULATION_TIME = 20_000;
    private static final int RESTAURANT_DISPLAYER_INITIAL_DELAY = 1000;
    private static final int RESTAURANT_DISPLAYER_PERIOD = 500;
    private static FastFoodRestaurant restaurant;
    private static RestaurantStateDisplayer restaurantDisplayer;
    private static ScheduledExecutorService service;

    @SneakyThrows
    public static void main(String[] args) {
        restaurant = new FastFoodRestaurant();
        restaurantDisplayer = new RestaurantStateDisplayer(restaurant);
        initializeRestaurantDisplayer();

        addCashDesksToTheRestaurant(restaurant);
        restaurant.initialize();
        restaurant.startRestaurant();
        Thread.sleep(APPROXIMATE_SIMULATION_TIME);
        while (!restaurant.isEmpty()) {
            Thread.sleep(2000);
        }
        restaurant.closeRestaurant();

        shutdownRestaurantDisplayer();
    }

    private static void shutdownRestaurantDisplayer() {
        service.shutdownNow();
    }

    private static void initializeRestaurantDisplayer() {
        service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(restaurantDisplayer,
                RESTAURANT_DISPLAYER_INITIAL_DELAY,
                RESTAURANT_DISPLAYER_PERIOD,
                TimeUnit.MILLISECONDS);
    }

    private static void addCashDesksToTheRestaurant(FastFoodRestaurant fastFoodRestaurant) {
        for (int i = 0; i < NUMBER_OF_CASH_DESKS_IN_RESTAURANT; i++) {
            CashDesk cashDesk = new CashDesk(i, fastFoodRestaurant);
            fastFoodRestaurant.addCashDesk(cashDesk);
        }

        LOGGER.info("{} CashDesks have been added to the restaurant", NUMBER_OF_CASH_DESKS_IN_RESTAURANT);
    }
}
