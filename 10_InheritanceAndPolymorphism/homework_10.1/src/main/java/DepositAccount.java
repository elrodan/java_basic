package main.java;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;
    @Override
    public void put(double amountToPut) {
        lastIncome = LocalDate.now();
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake) {
        LocalDate nowDate = LocalDate.now();
        LocalDate checkDate = lastIncome.plusMonths(1);
        if (nowDate.compareTo(checkDate) >= 1) {
            super.take(amountToTake);
        }
    }
}
