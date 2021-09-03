package main.java;

public class CardAccount extends BankAccount {
    @Override
    public void take(double amountToTake) {
        double amountWithInterest = amountToTake + amountToTake/100;
        if (amountWithInterest <= bankAccount && amountToTake > 0) {
            bankAccount -= amountWithInterest;
        }
    }
}
