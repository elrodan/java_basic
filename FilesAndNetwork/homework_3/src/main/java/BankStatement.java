import java.text.DecimalFormat;
import java.util.HashMap;

public class BankStatement {

    public static final String RUB = " руб.";
    DecimalFormat df = new DecimalFormat("###,###.##");

    private double expenseSum;
    private double incomeSum;
    HashMap<String, Double> organizationsExpense;

    public BankStatement() {
        organizationsExpense = new HashMap<>();
    }

    public HashMap<String, Double> getOrganizationsExpense() {
        return organizationsExpense;
    }

    public void setOrganizationsExpense(HashMap<String, Double> organizationsExpense) {
        this.organizationsExpense = organizationsExpense;
    }

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

    private String listOrganizationsExpense() {
        String orgList = "";
        for (String key : organizationsExpense.keySet()) {
            orgList += key + " " + organizationsExpense.get(key) + '\n';
        }
        return orgList;
    }

    @Override
    public String toString() {
        return "Сумма расходов: " + df.format(expenseSum) + RUB +
                "\nСумма доходов: " + df.format(incomeSum) + RUB +
                "\n\nСуммы расходов по организациям:\n" +listOrganizationsExpense();
    }
}
