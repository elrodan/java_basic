package main.java;

public class LegalPerson extends Client {
    @Override
    public void take(double amountToTake) {
        double amountWithInterest = amountToTake + amountToTake/100;
        super.take(amountWithInterest);
    }
}
