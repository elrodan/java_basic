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
      this.bankAccount -= amountToTake;
    }
  }

  boolean send(BankAccount receiver, double amount) {
    if (bankAccount >= amount && amount > 0) {
      this.take(amount);
      receiver.put(amount);
      return true;
    } else {
      return false;
    }
  }
}
