package main.java;

public class BankAccount {
  protected double bankAccount;

  public double getAmount() {
    return bankAccount;
  }

  public void put(double amountToPut) {
    if (amountToPut > 0) {
      bankAccount += amountToPut;
    }
  }

  public void take(double amountToTake) {
    if (bankAccount >= amountToTake && amountToTake > 0) {
      bankAccount -= amountToTake;
    }
  }
}
