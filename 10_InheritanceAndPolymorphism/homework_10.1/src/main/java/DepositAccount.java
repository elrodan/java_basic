package main.java;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    protected LocalDate lastIncome;
    @Override
    public void put(double amountToPut) {
        if (amountToPut > 0) {
            lastIncome = LocalDate.now();
            super.put(amountToPut);
        }
    }

    @Override
    public void take(double amountToTake) {
        LocalDate nowDate = LocalDate.now();
        if (nowDate.compareTo(lastIncome) >= 1 && amountToTake <= bankAccount) {
            super.take(amountToTake);
        }
    }
}
