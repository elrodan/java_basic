package main.java;

public abstract class Client {
    private double invoiceAmount;

    public double getAmount() {
        return invoiceAmount;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            invoiceAmount += amountToPut;
        }
    }

    public void take(double amountToTake) {
        //TODO: реализуйте метод и удалите todo
        if (amountToTake < invoiceAmount && amountToTake > 0) {
            invoiceAmount -= amountToTake;
        }
    }

}
