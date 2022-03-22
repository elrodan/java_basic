import java.text.DecimalFormat;
import java.util.Map;
import java.util.Random;

public class Bank {

    public static final int AMOUNT_FOR_CHECK = 50000;
    private Map<String, Account> accounts;
    private final Random random = new Random();

    public final DecimalFormat NUMBER_FORMAT = new DecimalFormat( "###,###" );

    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        Account from = getAccountValue(fromAccountNum);
        Account to = getAccountValue(toAccountNum);
        if ((from != null && to != null) && (from != to)) {
            synchronized (from.compareTo(to) > 0 ? from : to) {
                synchronized (from.compareTo(to) > 0 ? to : from) {
                    if (!from.isBlock() && !to.isBlock()) {
                        try {
                            if (amount > AMOUNT_FOR_CHECK && isFraud(fromAccountNum, toAccountNum, amount)) {
                                from.setBlock(true);
                                to.setBlock(true);
                                System.out.println("Перевод из " + fromAccountNum + " в " + toAccountNum
                                        + " на сумму " + amount
                                        + "\nМошенническая операция. Транзакция заблокирована!\n");
                                return;
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (from.getMoney() < amount) return;
                        from.setMoney(getBalance(fromAccountNum) - amount);
                        to.setMoney(getBalance(toAccountNum) + amount);
                        System.out.println("Перевод из " + fromAccountNum + " в " + toAccountNum
                                + " на сумму " + amount
                                + "\nБаланс на счете " + fromAccountNum + " равен: "
                                + NUMBER_FORMAT.format(getBalance(String.valueOf(fromAccountNum)))
                                + "\nБаланс на счете " + toAccountNum + " равен: "
                                + NUMBER_FORMAT.format(getBalance(String.valueOf(toAccountNum))) + '\n');
                    } else {
                        System.out.println("Транзакция с заблокированным аккаунтом(ами).\n"
                                + "Из " + fromAccountNum + " (статус блокировки: " + from.isBlock() + ")"
                                + " в " + toAccountNum + " (статус блокировки: " + to.isBlock() + ")"
                                + " на сумму " + amount
                                + "\nТранзакция заблокирована!\n");
                    }
                }
            }
        }
    }

    public long getBalance(String accountNum) {
        return getAccountValue(accountNum)
                .getMoney();
    }

    public long getSumAllAccounts() {
        return 0;
    }

    private Account getAccountValue(String accountNum) {
        return accounts
                .entrySet()
                .parallelStream()
                .filter(acc -> acc.getValue().getAccNumber().equals(accountNum))
                .findAny()
                .get()
                .getValue();
    }
}
