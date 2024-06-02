package ua.nure.cpp.lab2.free_checkout;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.util.Comparator;
import java.util.List;

@Log4j2
public class Customer {
    private static int counter = 0;

    @Getter
    private final int id;
    private final FastFoodRestaurant fastFoodRestaurant;
    private CashDesk occupiedCashDesk;

    public Customer(FastFoodRestaurant fastFoodRestaurant) {
        this.fastFoodRestaurant = fastFoodRestaurant;
        this.id = counter++;
        LOGGER.trace("Customer with id={} was created", this.id);
    }

    public void chooseCashDesk() {
        CashDesk chosenDesk = findCashDeskWithShortestLine(fastFoodRestaurant.getCashDesks());
        chosenDesk.addCustomer(this);
        this.occupiedCashDesk = chosenDesk;
    }

    public boolean switchLineIfNecessary() {
        CashDesk cashDeskWithShortestLine = findCashDeskWithShortestLine(fastFoodRestaurant.getCashDesks());
        if (switchingLineIsReasonable(cashDeskWithShortestLine)) {
            switchLine(cashDeskWithShortestLine);
            return true;
        }

        return false;
    }

    private void switchLine(CashDesk cashDeskWithShortestLine) {
        occupiedCashDesk.removeCustomer(this);
        cashDeskWithShortestLine.addCustomer(this);
        CashDesk previouslyOccupiedCashDesk = occupiedCashDesk;
        occupiedCashDesk = cashDeskWithShortestLine;
        LOGGER.info("Customer#{} has changed the line: from CashDesk#{} to CashDesk#{}", this.id, previouslyOccupiedCashDesk.getId(), occupiedCashDesk.getId());
    }

    private boolean switchingLineIsReasonable(CashDesk cashDeskWithShortestLine) {
        if (occupiedCashDesk == cashDeskWithShortestLine) {
            return false;
        }

        return occupiedCashDesk.getLineSize() - cashDeskWithShortestLine.getLineSize() > 1
                || (occupiedCashDesk.getLineSize() > 1 && cashDeskWithShortestLine.isLineEmpty());
    }

    private CashDesk findCashDeskWithShortestLine(List<CashDesk> cashDesks) {
        return cashDesks.stream()
                .min(Comparator.comparingInt(CashDesk::getLineSize))
                .orElseThrow(() -> new IllegalArgumentException("Empty cashDesks list was provided as an argument"));
    }
}
