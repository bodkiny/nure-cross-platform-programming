package ua.nure.cpp.lab2.free_checkout;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
public class RestaurantStateDisplayer implements Runnable {
    private static final String delimiter = "\n----------------------------\n";
    private final FastFoodRestaurant fastFoodRestaurant;

    @Override
    public void run() {
        logCashDesksState();
    }

    private void logCashDesksState() {
        List<CashDesk> cashDesks = fastFoodRestaurant.getCashDesks();
        StringBuilder sb = new StringBuilder();
        sb.append(delimiter);
        for (CashDesk cashDesk : cashDesks) {
            sb.append(cashDesk);
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        sb.append(delimiter);

        LOGGER.info(sb.toString());
    }
}
