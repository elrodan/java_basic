package main.java;

public class CardAccount extends BankAccount {
    @Override
    public void take(double amountToTake) {
        double amountWithInterest = amountToTake + amountToTake/100;
            super.take(amountWithInterest);
    }

    @Override
    boolean send(BankAccount receiver, double amount) {
        return send(receiver, amount);
    }
}
