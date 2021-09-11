package main.java;

public class IndividualBusinessman extends Client {
    @Override
    public void put(double amountToPut) {
        double amountWithInterest;
        if (amountToPut < 1000) {
            amountWithInterest = amountToPut - amountToPut/100;
        } else {
            amountWithInterest = amountToPut - amountToPut/200;
        }
        super.put(amountWithInterest);
    }
}
