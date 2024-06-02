package ua.nure.cpp.lab2.free_checkout;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Log4j2
public class CashDesk implements Runnable {
    private static final int MIN_SERVICE_TIME_MSEC = 2_000;
    private static final int MAX_SERVICE_TIME_MSEC = 10_000;
    private final int cashDeskServingTime = ThreadLocalRandom.current().nextInt(MIN_SERVICE_TIME_MSEC, MAX_SERVICE_TIME_MSEC);

    @Getter
    private final BlockingDeque<Customer> line = new LinkedBlockingDeque<>();

    @Getter
    private final int id;
    private final FastFoodRestaurant fastFoodRestaurant;

    @Override
    @SneakyThrows
    public void run() {
        LOGGER.info("CashDesk#{} have started serving customers", id);
        while (!fastFoodRestaurant.isClosed()) {
            Customer servedCustomer = line.peek();
            if (servedCustomer != null) {
                Thread.sleep(cashDeskServingTime);
                servedCustomer = line.poll();
                LOGGER.info("CashDesk#{} has served the Customer#{}", id, servedCustomer.getId());
                offerLastCustomerToSwitchTheLine();
            } else {
                LOGGER.info("CashDesk#{} is waiting for customers", id);
                Thread.sleep(1000);
            }
        }

        LOGGER.info("Restaurant is closed, CashDesk#{} has stopped serving", id);
    }

    public void addCustomer(Customer customer) {
        line.add(customer);
        LOGGER.trace("Customer#{} was added to CashDesk's#{} line", customer.getId(), this.id);
    }

    public void removeCustomer(Customer customer) {
        boolean removed = line.remove(customer);
        if (removed) {
            LOGGER.trace("Customer#{} was removed from CashDesk's#{} line", customer.getId(), this.id);
        }
    }

    public int getLineSize() {
        return line.size();
    }

    public boolean isLineEmpty() {
        return line.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashDesk#").append(id).append(": ");
        sb.append("*".repeat(line.size()));
        return sb.toString();
    }

    private void offerLastCustomerToSwitchTheLine() {
        Customer theLastCustomerInTheLine = line.peekLast();
        while (theLastCustomerInTheLine != null) {
            boolean haveSwitched = theLastCustomerInTheLine.switchLineIfNecessary();
            theLastCustomerInTheLine = line.peekLast();

            if (!haveSwitched) {
                break;
            }
        }
    }
}