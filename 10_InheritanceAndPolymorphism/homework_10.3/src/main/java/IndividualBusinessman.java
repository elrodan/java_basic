package main.java;

public class IndividualBusinessman extends Client {
    @Override
    public void put(double amountToPut) {
        double amountWithInterest = amountToPut < 1000 ? amountToPut - amountToPut/100 : amountToPut - amountToPut/200;
        super.put(amountWithInterest);
    }
}
