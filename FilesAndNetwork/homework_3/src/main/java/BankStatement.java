import java.text.DecimalFormat;

public class BankStatement {

    public static final String RUB = " руб.";
    DecimalFormat df = new DecimalFormat("###,###.##");

    private double expenseSum;
    private double incomeSum;

    public double getExpenseSum() {
        return expenseSum;
    }

    public void setExpenseSum(double expenseSum) {
        this.expenseSum = expenseSum;
    }

    public double getIncomeSum() {
        return incomeSum;
    }

    public void setIncomeSum(double incomeSum) {
        this.incomeSum = incomeSum;
    }

    @Override
    public String toString() {
        return "\nСумма расходов: " + df.format(expenseSum) + RUB +
                "\nСумма доходов: " + df.format(incomeSum) + RUB;
    }
}
