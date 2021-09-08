package main.java;

import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;
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
        LocalDate checkDate = lastIncome.plusMonths(1);
        if (nowDate.compareTo(checkDate) >= 1 && amountToTake <= super.getAmount()) {
            super.take(amountToTake);
        }
    }

    @Override
    boolean send(BankAccount receiver, double amount) {
        LocalDate nowDate = LocalDate.now();
        LocalDate checkDate = lastIncome.plusMonths(1);
        if (nowDate.compareTo(checkDate) >= 1 && super.getAmount() <= super.getAmount()) {
            return super.send(receiver, amount);
        } else {
            return false;
        }

    }
}
